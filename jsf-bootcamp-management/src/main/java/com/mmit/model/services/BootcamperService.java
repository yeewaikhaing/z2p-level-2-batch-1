package com.mmit.model.services;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class BootcamperService {

	@PersistenceContext
	private EntityManager em;
}
