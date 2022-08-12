package mmit.z2p.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import mmit.z2p.model.entity.Course;

public class CourseService {

	private EntityManager em;
	
	public CourseService(EntityManager em) {
		this.em = em;
	}

	public List<Course> findAll() {
		
		return em.createNamedQuery("getAllCourse", Course.class)
				.getResultList();
	}
}
