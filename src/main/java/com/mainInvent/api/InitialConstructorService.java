package com.mainInvent.api;

import java.util.Base64;

public class InitialConstructorService {
	
	public String wordEncoder(String string) {
		return Base64.getEncoder().encodeToString(string.getBytes());
	}
	
	public String wordDecoder(String string) {
		byte[] decode = Base64.getDecoder().decode(string);
		return new String(decode);
	}
}