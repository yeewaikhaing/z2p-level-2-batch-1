package com.mmit;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(OrderAnnotation.class)
class Testing_1 {

	static EntityManagerFactory emf;
	static EntityManager em;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("jpa-tut-03");
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
	//@Order(1)
	void persit_dept() {
		var dept = new Department();
		dept.setName("Business IT");
		
		var emp1 = new Employee();
		emp1.setName("Aung Aung");
		
		var emp2 = new Employee();
		emp2.setName("Kyaw Kyaw");
		
		dept.addEmployee(emp1);
		dept.addEmployee(emp2);
		
		em.getTransaction().begin();
		em.persist(dept);
		em.getTransaction().commit();
	}
	

	//@Test
	//@Order(2)
	void fetch_data() {
		var dept = em.find(Department.class, 1);
		System.err.println("Employee List");
		System.out.println("No of emp: " + dept.getEmployees().size());
	}
	@Test
	@Order(3)
	void cascade_persist() {
		var person = new Person();
		var phone = new Phone();
		phone.setNumber("12345678");
		
		person.setName("Kyaw Kyaw");
		person.addPhone(phone);
		
		em.getTransaction().begin();
		em.persist(person); // auto persist phone
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(4)
	void cascade_merge() {
		var phone = em.find(Phone.class, 1);
		var person = phone.getPerson();
		
		person.setName("Aung Aung");
		phone.setNumber("111111111");
		
		em.getTransaction().begin();
		em.merge(person); // auto merge phone 
		em.getTransaction().commit();
		
	}
	
	@Test
	@Order(6)
	void test_orphan_removal() {
		var emp = em.find(Person.class, 1);
		
		em.getTransaction().begin();
		emp.getPhones().remove(0);
		em.getTransaction().commit();
		
		System.out.println("--- This is orphan removal sampel--");
	}
	//@Test
	//@Order(5)
	void cascade_remove() {
		var person = em.find(Person.class, 1);
		
		em.getTransaction().begin();
		em.remove(person); // auto remove phone
		em.getTransaction().commit();
	}

}
