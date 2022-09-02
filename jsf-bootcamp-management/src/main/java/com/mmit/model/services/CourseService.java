package com.mmit.model.services;

import java.util.List;

import com.mmit.model.entities.Course;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;

@Stateless
public class CourseService {

	@PersistenceContext
	private EntityManager em;
	
	
	public List<Course> findAll() {
		
		return em.createNamedQuery("getAllCourse", Course.class)
				.getResultList();
	}

	public Course findById(int parseInt) {
		
		return em.find(Course.class, parseInt);
	}

	public void save(Course course) {
		if(course.getId() == 0)
			em.persist(course);
		else
			em.merge(course);
		
	}

	public List<Course> findByLevelId(int lvlId) {
		
		return em.createNamedQuery("getCourseByLevelId", Course.class)
				.setParameter("levelId", lvlId)
				.getResultList();
	}

	public void deleteById(int id) {
		var course = findById(id);
		em.remove(course);
		
		
	}
}
