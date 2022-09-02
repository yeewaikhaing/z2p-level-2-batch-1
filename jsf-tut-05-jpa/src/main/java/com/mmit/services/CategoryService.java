package com.mmit.services;

import java.util.List;

import com.mmit.entities.Category;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CategoryService {

	@PersistenceContext
	private EntityManager em;

	public List<Category> findAll() {
		
		return em.createNamedQuery("findAllCategoy", Category.class)
				.getResultList();
	}

	public Category findById(int id) {
		
		return em.find(Category.class, id);
	}
}
