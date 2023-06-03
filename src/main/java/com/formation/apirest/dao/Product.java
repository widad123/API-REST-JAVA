package com.formation.apirest.dao;

import java.util.concurrent.atomic.AtomicInteger;

//POJO ou JavaBeans ou Entité
//Classe qui contient les données
public class Product {
	
	private Integer id;
	private String name;
	private Double price;
	
	private static AtomicInteger SEQUENCE_NEXT_ID = new AtomicInteger(1);
	
	public Product(String name, Double price) {
		super();
		this.id = SEQUENCE_NEXT_ID.getAndIncrement();
		this.name = name;
		this.price = price;
	}
	
	
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
