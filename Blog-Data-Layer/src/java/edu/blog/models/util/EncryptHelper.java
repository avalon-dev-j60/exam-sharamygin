
package edu.blog.models.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class EncryptHelper {
    private EncryptHelper() {}
    
    public static String md5(String source){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte[] bytes = md.digest();
            return new String(bytes);
        }
        catch (NoSuchAlgorithmException e){
            throw new IllegalStateException(e);
        }
        
    }
    
    
}
