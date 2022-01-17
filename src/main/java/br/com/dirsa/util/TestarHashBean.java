package br.com.dirsa.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class TestarHashBean {

	public static String md5(String senha) {

		String criptografada = "";
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		criptografada = hash.toString(16);
		return criptografada;
	}

	public static String sha256(String senha) {

		String criptografada = null;

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(senha.getBytes("UTF-8"));
			return bytesToHex(hash);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return criptografada;
	}

	private static String bytesToHex(byte[] hash) {
		return DatatypeConverter.printHexBinary(hash);
	}

	
	  public static void main(String[] args) { 
		  String sha256 =
	  CalcularHashBean.sha256("sices@17"); 
	  System.out.println("SHA256 - " + sha256); 
	  System.out.println("\n\n"); 
	  /*String md5 = CalcularHashBean.md5("root"); 
	  System.out.println("MD5 - " + md5);*/ 
	  
	  }
	 
}