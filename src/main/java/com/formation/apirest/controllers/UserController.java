package com.formation.apirest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.apirest.dao.User;
import com.formation.apirest.dao.UserDao;

/***
 * *
 * GET /users : Récupérer la liste de tous les utilisateurs.
GET /users/{userId} : Récupérer les détails d'un utilisateur spécifique.
POST /users : Créer un nouvel utilisateur.
PUT /users/{userId} : Mettre à jour les informations d'un utilisateur existant.
DELETE /users/{userId} : Supprimer un utilisateur.
*
**/

@RestController
@RequestMapping("/users")
public class UserController {
	
private UserDao userDao = new UserDao();
	
// * GET /users : Récupérer la liste de tous les utilisateurs.
	@GetMapping("")
	public List<User> getListUsers() {
		return userDao.getUsers();
	}
	
	
	//GET /users/{userId} : Récupérer les détails d'un utilisateur spécifique.
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") Integer userId) {
		return userDao.getUser(userId);
	}
	
	//POST /users : Créer un nouvel utilisateur.
	@PostMapping("")
	public void addUser(@RequestBody User user) {
		userDao.addUser(user);
	}
	
	//PUT /users/{userId} : Mettre à jour les informations d'un utilisateur existant.
	@PutMapping("/{userId}")
	public boolean updateUser(
			@PathVariable("userId") Integer userId, 
			@RequestBody User user) {
		user.setId(userId);		
		return userDao.updateUser(user);
	}
	
	//DELETE /users/{userId} : Supprimer un utilisateur.
	@DeleteMapping("/{userId}")
	public void deleteUser(
			@PathVariable("userId") Integer userId) {
		 userDao.deleteUser(userId);
	}
	
	

}
