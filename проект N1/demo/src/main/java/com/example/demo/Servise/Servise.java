package com.example.demo.Servise;

import org.springframework.stereotype.Service;
import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;

@Service
public class Servise {

    private final Cipher cipher;

    public Servise() throws Exception {
        
        this.cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
        
    }


    public KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        

        return generator.generateKeyPair();
    }

    public String encrypt(String password , PublicKey k) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, k);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedData, PrivateKey k) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, k);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        

        return new String(decryptedBytes);
    }

}