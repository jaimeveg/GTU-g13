package es.upm.dit.isst.gtu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.upm.dit.isst.gtu.model.CardRequest;
import es.upm.dit.isst.gtu.dao.EMFService;

public class CardRequestDAOImpl implements CardRequestDAO {
	
	private static CardRequestDAOImpl instance;
	
	private CardRequestDAOImpl()	{
	}
	
	public static CardRequestDAOImpl getInstance(){
		if (instance ==	null)
			instance =	new CardRequestDAOImpl();
		return instance;
	}

	@Override
	public List<CardRequest> listCardRequests() {
		EntityManager	em =	EMFService.get().createEntityManager();
		//	read	the	existing	entries
		Query q =	em.createQuery("select	m	from	CardRequest	m");
		List<CardRequest> cardRequest =	q.getResultList();
		return cardRequest;
	}

	@Override
	public void add(String entity, String user) {

			System.out.println("El usuario "+ user +" ha realizado peticion. Fase: " + entity);
			EntityManager	em =	EMFService.get().createEntityManager();
			CardRequest cardRequest =	new CardRequest(entity, user);
			em.persist(cardRequest);
			em.close();

	}

	@Override
	public void remove(long id) {

		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			try {
				CardRequest cardRequest = em.find(CardRequest.class, id);
				em.remove(cardRequest);
			} finally {
				em.close();
			}
		}

	}

	@Override
	public List<CardRequest> listEntityRequests(String entity) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			//	read	the	existing	entries
			Query q = em
					.createQuery("select	cr	from	CardRequest	cr	where	cr.entity	=	:entity");
			q.setParameter("entity", entity);
			List<CardRequest> userRequest = q.getResultList();
			return userRequest;
		}
	}


	@Override
	public void update(long id, String entity) {

		synchronized (this)	{
			EntityManager em = EMFService.get().createEntityManager();
			try {
				CardRequest cardRequest = em.find(CardRequest.class, id);
				cardRequest.setEntity(entity);
				em.merge(cardRequest);
			} finally {
				em.close();
			}
		}
		
	}

}
