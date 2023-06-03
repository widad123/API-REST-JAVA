package com.formation.apirest.controllers;
import com.formation.apirest.dao.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class TokenController {

	TokenDao tokenDao= new TokenDao();
	/***
	 * POST /login : Permet à l'utilisateur de se connecter en fournissant un nom d'utilisateur et un mot de passe (en RequestBody). En cas de succès, un token est généré et renvoyé en réponse.
GET /logout?token=<TOKEN> : Permet à l'utilisateur de se déconnecter avec le TOKEN. L'utilisateur est déconnecté 
et le token devient invalide.
GET /isvalid?token=<TOKEN> : Permet à l'utilisateur de dire si le token est valide (true ou false). 
*/
	
//POST /login : Permet à l'utilisateur de se connecter en fournissant un nom d'utilisateur et un mot de passe (en RequestBody).
	//En cas de succès, un token est généré et renvoyé en réponse
	@PostMapping("login")
	public String logIn(@RequestBody User user){
	if(tokenDao.logIn(user.getEmail(), user.getPassword())) {
		return tokenDao.genereteToken(user.getEmail());
	}
	 return null;
	}
	
	/***
	 * GET /logout?token=<TOKEN> : Permet à l'utilisateur de se déconnecter avec le TOKEN. L'utilisateur est déconnecté 
et le token devient invalide.
*/
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public boolean logOut(@RequestParam(value="token", required=true) String token) {
		return tokenDao.logOut(token);
	}
	
/***
 * GET /isvalid?token=<TOKEN> : Permet à l'utilisateur de dire si le token est valide (true ou false). 
*/
	@RequestMapping(value = "/isvalid", method = RequestMethod.GET)
	public boolean isValid(@RequestParam(value="token", required=true)  String jeton) {
		return tokenDao.isValid(jeton);
	}

	
	
}
