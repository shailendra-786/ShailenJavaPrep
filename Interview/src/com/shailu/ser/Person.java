package com.shailu.ser;

import java.io.Serializable;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private transient String password;
    private byte[] encryptedPassword;
    private SecretKey secretKey;
    
    public Person(String name, String password) throws Exception {
        this.name = name;
        this.password = password;
        this.secretKey = KeyGenerator.getInstance("AES").generateKey();
        this.encryptedPassword = encryptPassword(password, secretKey);
    }
    
    public String getName() {
        return name;
    }
    
    public String getPassword() throws Exception {
        return decryptPassword(secretKey);
    }
    
    public void setPassword(String password) throws Exception {
        this.password = password;
        
    }
    
    private byte[] encryptPassword(String password, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(password.getBytes());
    }

    private String decryptPassword(SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(encryptedPassword);
        return new String(decrypted);
    }}
