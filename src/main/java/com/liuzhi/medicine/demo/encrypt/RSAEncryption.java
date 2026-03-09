package com.liuzhi.medicine.demo.encrypt;


import com.liuzhi.medicine.demo.utils.Base64Utils;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 非对称加密
 * @author guowei
 **/
@Component
public class RSAEncryption implements IEncryption {

    @Override
    public String encryptByPublicKey(String data, String publicKey) throws Exception {
        byte[] dataStrBytes = data.getBytes(CHARSET);
        Key publicK = getPublicKey(publicKey);
        Cipher cipher = Cipher.getInstance(KEY_RSA_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        byte[] encryptedData = this.getValue(dataStrBytes, cipher, MAX_ENCRYPT_BLOCK);
        return Base64Utils.encode(encryptedData);

    }


    @Override
    public String decryptByPrivateKey(String data, String privateKey) throws Exception {
        byte[] dataStrBytes = Base64Utils.decode(data);
        Key privateK = this.getPrivateKey(privateKey);
        Cipher cipher = Cipher.getInstance(KEY_RSA_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        byte[] encryptedData = this.getValue(dataStrBytes, cipher, MAX_DECRYPT_BLOCK);
        return new String(encryptedData, CHARSET);
    }

    @Override
    public String sign(String data, String privateKey) throws Exception {
        PrivateKey privateK = getPrivateKey(privateKey);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data.getBytes(CHARSET));
        return Base64Utils.encode(signature.sign());
    }

    @Override
    public boolean checkSign(String data, String publicKey, String sign) throws Exception {
        PublicKey publicK = getPublicKey(publicKey);
        byte[] dataStrBytes = data.getBytes(CHARSET);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(dataStrBytes);
        return signature.verify(Base64Utils.decode(sign));
    }

    /**
     * 获得 公钥Key
     *
     * @param publicKey publicKey
     * @return Key
     * @throws Exception 异常
     */

    private PublicKey getPublicKey(String publicKey) throws Exception {

        byte[] keyBytes = Base64Utils.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_RSA_ALGORITHM);
        return keyFactory.generatePublic(x509KeySpec);

    }

    /**
     * 获得密钥Key
     *
     * @param privateKey privateKey
     * @return Key
     * @throws Exception 异常
     */
    private PrivateKey getPrivateKey(String privateKey) throws Exception {

        byte[] keyBytes = Base64Utils.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_RSA_ALGORITHM);
        return keyFactory.generatePrivate(pkcs8KeySpec);


    }

    /**
     * 分段加解密方法
     *
     * @param dataStrBytes 加密数据byte[]
     * @param cipher       cipher
     * @return byte[]
     * @throws Exception 异常
     */
    private byte[] getValue(byte[] dataStrBytes, Cipher cipher, int maxSize) throws Exception {
        int inputLen = dataStrBytes.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > maxSize) {
                cache = cipher.doFinal(dataStrBytes, offSet, maxSize);
            } else {
                cache = cipher.doFinal(dataStrBytes, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * maxSize;
        }
        byte[] data = out.toByteArray();
        out.close();
        return data;

    }

}
