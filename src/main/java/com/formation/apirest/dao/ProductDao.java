package com.formation.apirest.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//POJO ou JavaBeans ou Entité
//Classe qui contient les données
public class ProductDao {
	
	//ATTENTION : List.of() -> génère une ArrayList immuable 
	//(add, remove, toute modification de la liste lève une exception)
	//donc dans notre cas utiliser new ArrayList<>()
	//Utilisez synchronized List pour que les méthodes de modifications 
	//ne soient pas perturbés lorsqu'il y a plusieurs requêtes
	//qui sont exécutés en même temps
	private static List<Product> products = Collections.synchronizedList(new ArrayList<>());
	
	static {
		products.addAll(
				List.of(
						new Product("Pizza", 15.2),
						new Product("Hamburger", 10.0)
				)
		);
	}	
	
	public List<Product> getListProducts() {
		return products;
	}
	
	public Product getProduct(Integer id) {
		for(Product p : products) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public void deleteProduct(Integer id) {
		for(int index = 0; index < products.size(); index++) {
			if(products.get(index).getId().equals(id)) {
				products.remove(index);
				return;
			}
		}
	}
	
	public boolean updateProduct(Product pNew) {
		Product pOld = this.getProduct(pNew.getId());
		if(pOld == null) {
			return false;
		}
		pOld.setName(pNew.getName());
		pOld.setPrice(pNew.getPrice());
		return true;
	}
	
	public List<Product> searchProducts(String name, Double pricePlancher) {
		List<Product> results = new ArrayList<>();
		for(Product p : products) {
			if(p.getName().toUpperCase().contains(name.toUpperCase())) {
				if(pricePlancher == null || p.getPrice() > pricePlancher) {
					results.add(p);
				}
			}
		}
		return results;		
	}
	
}
