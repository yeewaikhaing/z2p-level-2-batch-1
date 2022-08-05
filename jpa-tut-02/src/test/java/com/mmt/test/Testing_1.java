package com.mmt.test;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mmit.entity.Batch;
import com.mmit.entity.Student;

class Testing_1 {

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
		em = emf.createEntityManager(); // get entity manager
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	//@Test
	void test() {
		// new or transient state
		var student = new Student();
		student.setEmail("min@gmail.com");
		student.setName("Aung Aung");
		
		System.out.println("Id before persist: " + student.getId());
		em.getTransaction().begin();
		em.persist(student); // from new to managed state
		//em.flush();
		em.getTransaction().commit();
		
		System.out.println("Id after persist: " + student.getId());
	}
	//@Test
	void test2() {
		var student = new Student();
		student.setEmail("aung@gmail.com");
		student.setName("Aung Aung");
		
		var batch = new Batch();// new state
		batch.setName("Batch 1");
		
		student.setBatch(batch);
		
		em.getTransaction().begin();
		em.persist(batch); // managed state
		em.persist(student);
		em.getTransaction().commit();
		
	}
	//@Test
	void test3() {
		var std = new Student();
		std.setEmail("may@gmail.com");
		std.setName("May Oo May");
		
		//var batch = em.find(Batch.class, 1); // managed state
		var batch = em.getReference(Batch.class, 1); // just contain id, 
		
		std.setBatch(batch);
		
		em.getTransaction().begin();
		em.persist(std);
		em.getTransaction().commit();
		System.out.println("-------------");
		System.out.println("Batch name: " + batch.getName());
		System.out.println("Batch Id: " + batch.getId());
		//var batch_1 = em.find(Batch.class, 1); // not hit db, just retrieve pc.
	}
	
	//@Test
	void test4() {
		var student = em.find(Student.class, 1); // managed state
		 //em.detach(student); // managed state to detached state(out of context)
		 em.clear(); // detached state
		 
		 
		 var student_1 = em.merge(student); // from detached to managed state
		 
		 
		 System.out.println("Contain in context: " + em.contains(student_1));
	}
	//@Test
	void test5() {
		var std = em.find(Student.class, 1); // managed state
		
		em.getTransaction().begin();
		std.setName("Jeon"); // update via setXXX()
		em.getTransaction().commit();
	}
	
	//@Test
	void test6() {
		var student = em.find(Student.class, 1); // managed state
		
		em.detach(student); // detached state
		
		em.getTransaction().begin();
		student.setEmail("jeon@gmail.com");
		em.merge(student);
		em.getTransaction().commit();
	}
	
	@Test
	void test7() {
		var student = em.find(Student.class, 1); // managed state
		
		em.getTransaction().begin();
		em.remove(student); // managed to remove state
		
		//em.clear();// removed state to detached state
		//em.persist(student); // removed to managed state
		em.getTransaction().commit();
		
		//System.out.println("contain: " + em.contains(student));
		
		
	}

}
