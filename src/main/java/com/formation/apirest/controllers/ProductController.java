package com.formation.apirest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formation.apirest.dao.Product;
import com.formation.apirest.dao.ProductDao;

/**
 * 
 * Ce controller prend en charge le CRUD sur la ressource products
 * GET /products -> lister les produits
 * GET /products/{idProduct} -> lister le produit dont l'id = idProduct
 * POST /products -> Création d'un produit
 * PUT /products/{idProduct} -> Mise à jour d'un produit dont l'id = idProduct
 * DELETE /products/{idProduct} -> Suppression d'un produit dont l'id = idProduct
 * GET /products/search?name=pi -> lister les produits dont le nom contient par exemple pi
 * 
 */
@RestController
@RequestMapping("/products")
public class ProductController {
	
	private ProductDao dao = new ProductDao();
	
	/*
	@GetMapping("")
	//@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Map<String, Object>> getListProducts() {
		return List.of(
				Map.of("name", "Pizza", "price", 15.2),
				Map.of("name", "Hamburger", "price", 10.0)				
		);
	}
	*/
	/*
	@GetMapping("")
	//@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Product> getListProducts() {
		return List.of(
				new Product("Pizza", 15.2),
				new Product("Hamburger", 10.0)
		);
	}
	*/
	
	@GetMapping("")
	//--> GET http://127.0.0.1:8080/products
	//sur Postman --> https://pasteboard.co/ElErxDXul1Ob.png
	//@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Product> getListProducts() {
		return dao.getListProducts();
	}
	
	//@GetMapping("/{idProduct}")
	//--> GET http://127.0.0.1:8080/products/{idProduct}
	//sur Postman --> https://pasteboard.co/YP34Y3OxH2x1.png
	//@RequestMapping(value = "/{idProduct}", method = RequestMethod.GET)
	/*
	public String getProduct(@PathVariable("idProduct") Integer idProduct) {
		ObjectMapper objectMapper = new ObjectMapper();
		Product p = dao.getProduct(idProduct);
		String str = objectMapper.writeValueAsString(p);			
		return str;
	}
	*/
	
	@GetMapping("/{idProduct}")
	//--> GET http://127.0.0.1:8080/products/{idProduct}
	//sur Postman --> https://pasteboard.co/YP34Y3OxH2x1.png
	//@RequestMapping(value = "/{idProduct}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("idProduct") Integer idProduct) {
		return dao.getProduct(idProduct);
	}
	
	@PostMapping("")
	//--> POST http://127.0.0.1:8080/products
	//sur Postman -->
	//   https://pasteboard.co/v5DjZTHWd0pO.png
	//   https://pasteboard.co/gT0GV02cNj3j.png
	//@RequestMapping(value = "", method = RequestMethod.POST)
	public void addProduct(@RequestBody Product p) {
		dao.addProduct(p);
	}
	
	@PutMapping("/{idProduct}")
	//--> PUT http://127.0.0.1:8080/products/{idProduct}
	//sur Postman -->
	//   https://pasteboard.co/ogAIwsrJ8Ayd.png
	//   https://pasteboard.co/obIHpZlQFTa9.png
	//   https://pasteboard.co/MDgIsviNaWlY.png
	//@RequestMapping(value = "/{idProduct}", method = RequestMethod.PUT)
	public boolean updateProduct(
			@PathVariable("idProduct") Integer idProduct, 
			@RequestBody Product p) {
		p.setId(idProduct);		
		return dao.updateProduct(p);
	}
	
	
	@DeleteMapping("/{idProduct}")
	//--> DELETE http://127.0.0.1:8080/products/{idProduct}
	//sur Postman -->
	//   https://pasteboard.co/ogAIwsrJ8Ayd.png
	//   https://pasteboard.co/F0NAxFtySLwa.png
	//@RequestMapping(value = "/{idProduct}", method = RequestMethod.DELETE)
	public void deleteProduct(
			@PathVariable("idProduct") Integer idProduct) {
		dao.deleteProduct(idProduct);
	}
	
	
	@GetMapping("/search")
	//--> GET /products/search?name=pi&pricePlancher=3  RequestParam clé=valeur
	//(on oblige à l'utilisateur que name est obligatoire et priceGreatherThan non obligatoire si priceGreatherThan > 3)
	//sur Postman --> https://pasteboard.co/R7gzKzn22xGq.png
	//@RequestMapping(value = "/search", method = RequestMethod.GET)	
	//@RequestParam String name =======> @RequestParam(value="name", required=true) String name
	//@RequestParam(value="pricePlancher", required=false) ========> @RequestParam(value="pricePlancher", required=false, defaultValue=null)
	public List<Product> searchProducts(
			@RequestParam(value="name", required=true) String name, 
			@RequestParam(value="pricePlancher", required=false) Double pricePlancher) {
		return dao.searchProducts(name, pricePlancher);
	}
	
}
