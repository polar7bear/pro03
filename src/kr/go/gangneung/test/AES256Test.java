package kr.go.gangneung.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.crypto.util.AES256;

public class AES256Test {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidParameterSpecException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
		String pw = "1234";
		String key = "%03b";
		
		System.out.println("비밀번호 : "+pw+", 암호화 된 비밀번호 : "+AES256.encryptAES256(pw, key));
		
		String dec = "ZzcXZxYqzGaxNUUpYJWEJu3TfgXHaEIiUxpxV7F4Epi0doBJfWlFttOyG3KOD25oSUH6Dg==";
		
		System.out.println("복호화 된 비밀번호 : "+AES256.decryptAES256(dec, key));
	}

}

