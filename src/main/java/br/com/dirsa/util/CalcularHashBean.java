package br.com.dirsa.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

/**
 * @author frederikfra Classe responsavel pela criptografia dos dados
 **/

public class CalcularHashBean {

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
}