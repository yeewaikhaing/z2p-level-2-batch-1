package com.mmt.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PostLoad;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.entity.User;

class Testing_2 {

	static EntityManagerFactory emf;
	static EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tut-02");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	//@Test
	void internat_callbacks() {
		var user = new User();
		user.setFirstName("Jeon");
		user.setLastName("Kook");
		
		em.getTransaction().begin();
		em.persist(user);
		
		em.getTransaction().commit();
		//em.detach(user);
		//var user1 = em.find(User.class, "cust_8ef7e4f2-ff9c-4c2e-bdc7-6a91c3019be4");
		
		//System.out.println("full name: " + user1.getFullName());
		
	}
	
	//@Test
	void external_callbacks() {
		var user = new User();
		user.setFirstName("Aung");
		user.setLastName("Aung");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		System.out.println("Id: " + user.getId());
	}

	@Test
	void external_cb_remove() {
//		var user = em.find(User.class, "cust_4b2c448e-1279-45d8-a100-0f56cf6bd66c");
//		
//		em.getTransaction().begin();
//		em.remove(user);
//		em.getTransaction().commit();
	}
	
	//@Test
	void test3() {
		var user = new User();
		user.setFirstName("Aung");
		user.setLastName("Aung");
		
		user.setPhones(List.of("11111", "22222"));
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	@Test
	void test4() {
		var user = em.find(User.class,"cust_481b0ce1-2761-44fd-9f26-2e5e1fba532c");
		
		System.out.println("user: " + user);
		user.getPhones().add("333333");
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
	}
}
