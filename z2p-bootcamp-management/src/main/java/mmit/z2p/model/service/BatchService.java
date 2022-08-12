package mmit.z2p.model.service;

import java.util.List;

import javax.persistence.EntityManager;

import mmit.z2p.model.entity.Batch;

public class BatchService {

	private EntityManager em;
	
	public BatchService(EntityManager em) {
		this.em = em;
	}

	public List<Batch> findAll() {
		
		return em.createNamedQuery("getAllBatch", Batch.class).getResultList();
	}

	public Batch findById(int id) {
		
		return em.find(Batch.class, id);
	}

	public void save(Batch batch) {
		em.getTransaction().begin();
		if(batch.getId() == 0)
			em.persist(batch);
		else
			em.merge(batch);
		em.getTransaction().commit();
		
	}
}
