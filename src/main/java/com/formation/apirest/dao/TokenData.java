package com.formation.apirest.dao;

public class TokenData {

	String email;
	long expirationTime;
	
	public TokenData(String email){
		this.email = email;
		//15 minutes à partir de maintenant
		expirationTime = System.currentTimeMillis() + 15 * 60 * 1000;
	}
}
