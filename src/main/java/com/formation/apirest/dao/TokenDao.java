package com.formation.apirest.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TokenDao {
	
private static List<User> users = Collections.synchronizedList(new ArrayList<>());
private TokenManager tokenManager = new TokenManager();
private Map<String, TokenData> tokenMap = new HashMap<>();
	
	public TokenManager getTokenManager() {
	return tokenManager;
}

	static {
		users.addAll(
				List.of(
						new User("widad","khatiri.widad@gmail.com","123paris"),
						new User("chahra zad","khatiri.chahrazad4@gmail.com","lika123")
				)
		);
	}	
	
	/***
	 * fonction qui génére un token pour un utilisateur
	 * */
	public String genereteToken(String email) {
		String token = UUID.randomUUID().toString();
		tokenMap.put(token, new TokenData(email));
		return token;
	}
	
	
	/***
	 * fonction qui vérifie les identifiants */
	
	public boolean logIn(String email,String password) {
		for(User user : users) {
			if(user.getEmail().equals(email) ) {
				if(user.getPassword().equals(password)) {
					return true;
				}
				
			}
		}
		return false;
	}
	
	/***
	 * fonction qui suprime un token */
	public boolean logOut(String token) {
		if(tokenMap.containsKey(token)){
			tokenMap.remove(token);
			return true;
		}
		return false;
	}

	/***
	 * fonction qui vérifie la validité de token */
	public boolean isValid(String token){
		boolean isValid= false;
		if(tokenMap.containsKey(token)){
			if(tokenMap.get(token).expirationTime > System.currentTimeMillis()){
				isValid=true;
				return isValid;
			}
		}
			return isValid;
		
	}
	
  
	
}
