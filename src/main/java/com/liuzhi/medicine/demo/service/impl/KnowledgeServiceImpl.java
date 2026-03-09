package com.liuzhi.medicine.demo.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSONObject;
import com.liuzhi.medicine.demo.beans.KnowledgeSignBean;
import com.liuzhi.medicine.demo.beans.RespEntity;
import com.liuzhi.medicine.demo.encrypt.RSAEncryption;
import com.liuzhi.medicine.demo.properties.KnowledgeProperties;
import com.liuzhi.medicine.demo.service.IKnowledgeService;
import com.liuzhi.medicine.demo.utils.ParamsUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

/**
 * @author guowei
 */
@Service
@Slf4j
public class KnowledgeServiceImpl implements IKnowledgeService {

    private final KnowledgeProperties knowledgeProperties;
    private final RestTemplate restTemplate;
    private final RSAEncryption rsaEncryption;

    public KnowledgeServiceImpl(KnowledgeProperties knowledgeProperties, RestTemplate restTemplate, RSAEncryption rsaEncryption) {
        this.knowledgeProperties = knowledgeProperties;
        this.restTemplate = restTemplate;
        this.rsaEncryption = rsaEncryption;
    }


    /**
     * 请求知识库接口
     * @param method 方法名
     * @return 返回值
     * @throws ParseException 异常
     */
    @Override
    public Object postKnow(String method, Object data) throws Exception {

        getKnowledgeToken();

        if (knowledgeProperties.getEffectiveTime() == null
                || knowledgeProperties.getEffectiveTime().getTime() - System.currentTimeMillis() < 60 * 1000) {
            getKnowledgeToken();
        }

        KnowledgeSignBean bean = new KnowledgeSignBean();
        bean.setAppId(knowledgeProperties.getAppId());
        bean.setToken(knowledgeProperties.getToken());
        bean.setTimestamp(System.currentTimeMillis());
        bean.setData(data);
        String linkParam = ParamsUtils.linkParam(data);
        String sha256Hex = DigestUtil.sha256Hex(linkParam);
        bean.setEncryptData(sha256Hex);
        bean.setSign(rsaEncryption.encryptByPublicKey(bean.toSignString(), knowledgeProperties.getRsaPublicKey()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(bean, headers);

        log.info("know before URL：{}, params：{}", knowledgeProperties.getUrlPrefix() + method, request);

        RespEntity<?> result = restTemplate.postForObject(knowledgeProperties.getUrlPrefix() + method, request, RespEntity.class);

        log.info("know after URL：{}, params：{}, result: {}", knowledgeProperties.getUrlPrefix() + method, request, result);
        if (result != null) {
            if (result.isStatus()) {
                //成功
                return result.getData();
            } else {
                log.error(result.getMessage());
            }
        }
        return null;
    }


    /**
     * 获取凭证
     * <p>
     * 建议缓存knowledgeProperties
     * </p>
     * @throws ParseException 异常
     */
    public void getKnowledgeToken() throws ParseException {

        String url = knowledgeProperties.getUrlPrefix() + "sys/app/token?appId=" + knowledgeProperties.getAppId() + "&appPwd=" + knowledgeProperties.getAppPwd();

        log.info("know token params: {}", url);
        ResponseEntity<JSONObject> response = restTemplate.getForEntity(url, JSONObject.class);
        JSONObject result = response.getBody();
        log.info("know token result: {}", result);
        if (result != null) {
            JSONObject data = result.getJSONObject("data");
            String token = data.getString("token");
            String effective = data.getString("effective");
            knowledgeProperties.setToken(token);
            knowledgeProperties.setEffectiveTime(DateUtils.parseDate(effective, "yyyy-MM-dd HH:mm:ss"));
        }
    }
}
