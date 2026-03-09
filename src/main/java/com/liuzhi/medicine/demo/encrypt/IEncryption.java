package com.liuzhi.medicine.demo.encrypt;

/**
 * 加密接口
 * @author guowei
 **/
public interface IEncryption {

    /**
     * 加密算法RSA
     */
    String KEY_RSA_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    String SIGNATURE_ALGORITHM = "SHA1withRSA";

    /**
     * RSA最大解密密文大小
     */
    int MAX_DECRYPT_BLOCK = 128;
    /**
     * RSA最大加密
     */
    int MAX_ENCRYPT_BLOCK = 117;

    /**
     * 编码方式
     */
    String CHARSET = "UTF-8";


    /**
     * 公钥加密
     *
     * @param data      数据
     * @param publicKey public key
     * @return String
     * @throws Exception 异常
     */
    String encryptByPublicKey(String data, String publicKey) throws Exception;

    /**
     * 私钥解密
     *
     * @param data       数据
     * @param privateKey private key
     * @return String
     */
    String decryptByPrivateKey(String data, String privateKey) throws Exception;

    /**
     * 签名
     *
     * @param data 数据
     * @return String
     */
    String sign(String data, String privateKey) throws Exception;


    /**
     * 校验签名
     *
     * @param data      数据
     * @param publicKey 公钥
     * @param sign      sign
     * @return boolean
     */
    boolean checkSign(String data, String publicKey, String sign) throws Exception;


}
