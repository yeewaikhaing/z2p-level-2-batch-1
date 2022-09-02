package com.mmit.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.mmit.entities.Product;
import com.mmit.services.ProductService;

import jakarta.annotation.PostConstruct;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.annotation.RequestParameterMap;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ProductBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Product> products;
	private Product product;
	
	@Inject
	private ProductService service;
	
	@RequestParameterMap
	@Inject
	private Map<String, String> params; // pId -> 1
	@PostConstruct
	private void init() {
		System.out.println("params: " + params);
	 	String id = params.get("pId");
	 	if(id == null)
	 		product = new Product();
	 	else
	 		product = service.findById(Integer.parseInt(id));
	 	
		products = service.findAll();
	}

	public String save() {
		System.out.println("product id = " + product.getId());
		service.save(product);
		
		return "/index?faces-redirect=true";
	}
	
	public String delete(int proudctId) {
		
		service.deleteById(proudctId);
		
		return "/index?faces-redirect=true";
	}
	public List<Product> getProducts() {
		return products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
