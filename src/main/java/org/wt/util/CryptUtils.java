package org.wt.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public abstract class CryptUtils {
    public static final String enc(String data){
        try {
            return Base64.getEncoder().encodeToString(data.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    public static final String dec(String base64){
        byte[] bytes = Base64.getDecoder().decode(base64);
        try {
            return new String(bytes,"utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
