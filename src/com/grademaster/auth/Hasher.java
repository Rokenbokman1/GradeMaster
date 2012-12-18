package com.grademaster.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.grademaster.Globals;
/**
 * The hasher provides methods to hash strings using SHA-256 (E.g. a password)
 * @author jake
 *
 */
public class Hasher {
	/**
	 * The original string (E.g. a password)
	 */
	private String original;
	/**
	 * The cached version of the hashed String
	 */
	private String hashed;
	/**
	 * Constructs a hasher object with a given original string (E.g. a password)
	 * @param str The original string of the Hasher object
	 */
	public Hasher(String str) {
		this.original=str;
	}
	/**
	 * Digests and returns original string bypassing all caching.  I honestly have no idea what most of this method does.
	 * @return a String of the original given String hashed with SHA-256
	 * @throws NoSuchAlgorithmException this should never be thrown because I use a static String, but I was too lazy to write a try/catch
	 */
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
	/**
	 * Returns the hashed version of the original string.  This uses a cache and only digests the message once.
	 * @return a SHA-256 hashed version of the original string
	 */
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
