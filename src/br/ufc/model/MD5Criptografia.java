package br.ufc.model;
import java.security.*;
import java.math.*;

public class MD5Criptografia {
    public String criptografar(String valor){ 
        MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        m.update(valor.getBytes(),0,valor.length());
        
        return new BigInteger(1,m.digest()).toString(16);
    }

}
