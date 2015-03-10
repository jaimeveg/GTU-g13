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
	public List<CardRequest> listUserRequests() {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			//	read	the	existing	entries
			Query q = em
					.createQuery("select	cr	from	CardRequest	cr	where	cr.entity	=	:entity");
			q.setParameter("entity", "User");
			List<CardRequest> userRequest = q.getResultList();
			return userRequest;
		}
	}

	@Override
	public List<CardRequest> listUniversityRequests() {
		EntityManager	em =	EMFService.get().createEntityManager();
		//	read	the	existing	entries
		Query q =	em.createQuery("select	cr	from	CardRequest	cr	where	cr.entity	=	University");
		List<CardRequest> universityRequest =	q.getResultList();
		return universityRequest;
	}

	@Override
	public List<CardRequest> listBankRequests() {
		EntityManager	em =	EMFService.get().createEntityManager();
		//	read	the	existing	entries
		Query q =	em.createQuery("select	cr	from	CardRequest	cr	where	cr.entity	=	Bank");
		List<CardRequest> bankRequest =	q.getResultList();
		return bankRequest;
	}

	@Override
	public void update(String entity, String user) {

		synchronized (this)	{
			EntityManager	em =	EMFService.get().createEntityManager();
			Query q =	em.createQuery("select	cr from CardRequest cr	where cr.user	=	:userId");
			q.setParameter("userId",	user);
			CardRequest cardRequest = (CardRequest) q.getSingleResult();
			cardRequest.setEntity(entity);
			em.persist(cardRequest);
			em.close();
		}
		
	}

}
