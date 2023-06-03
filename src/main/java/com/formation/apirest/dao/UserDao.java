package com.formation.apirest.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDao {
	
	private static List<User> users = Collections.synchronizedList(new ArrayList<>());
	
	static {
		users.addAll(
				List.of(
						new User("widad","khatiri.widad@gmail.com","123paris"),
						new User("chahra zad","khatiri.chahrazad4@gmail.com","lika123")
				)
		);
	}	
	
	/***
	 * Fonction qui retourne une liste d'utilisateurs
	 * ***/
	public List<User> getUsers() {
		return users;
	}
	
	/***
	 * Fonction qui retourne un seul utilisateur prend en paramètre son id
	 * retourne null si id ne corresponds pas à aucun utilisateur  
	 * */
	public User getUser(Integer id) {
		for(User user : users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	
	/***
	 * fonction qui ajoute un utilisateur à la liste d'utilisateur
	 * **/
	public void addUser(User user) {
		users.add(user);
	}
	
	/**
	 * fonction qui suprime un user grace à son id***/
	public void deleteUser(Integer id) {
		for(int index = 0; index < users.size(); index++) {
			if(users.get(index).getId()==id) {
				users.remove(index);
				return;
			}
		}
	}
	
	/***
	 * fonction qui mis à jour un utilisateur
	 * */
	public boolean updateUser(User _user) {
		User user = this.getUser(_user.getId());
		if(user == null) {
			return false;
		}
		user.setName(_user.getName());
		user.setEmail(_user.getEmail());
		user.setPassword(_user.getPassword());
		return true;
	}
	
//	/***
//	 * fonction qui cherche un utilisateur prend en parametre son nom, email et password*/
//	public List<User> searchUsers(String name, String email, String password) {
//		List<User> results = new ArrayList<>();
//		for(User u : users) {
//			if(u.getName().toUpperCase().contains(name.toUpperCase())
//					&& u.getEmail().toUpperCase().contains(email.toUpperCase())
//					&& u.getPassword().toUpperCase().contains(password.toUpperCase())) {
//				
//					results.add(u);
//				
//			}
//		}
//		return results;		
//	}
	

}
