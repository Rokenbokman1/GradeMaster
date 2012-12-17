package com.grademaster.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.grademaster.Globals;

public class Hasher {
	private String original;
	private String hashed;
	public Hasher(String str) {
		this.original=str;
	}
	//Digests original bypassing cache
	public String digest() throws NoSuchAlgorithmException {
		//IDK what this does
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(original.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
		return hexString.toString();
	}
	// Gets hashed version of original and digests if not cached
	public String getHashed() {
		if (hashed==null) {
			try {
				hashed=digest();
			} catch (NoSuchAlgorithmException e) {
				Globals.getLogger().log(e);
			}
		}
		return hashed;
	}
}
