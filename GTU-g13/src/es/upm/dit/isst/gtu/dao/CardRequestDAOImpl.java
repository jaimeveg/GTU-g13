package es.upm.dit.isst.gtu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	public CardRequest getCardRequestByUserId(String userId) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			//	read	the	existing	entries
			try {
				Query q = em
						.createQuery("select	cr	from	CardRequest	cr	where	cr.user	=	:userId");
				q.setParameter("userId", userId);
				CardRequest request = (CardRequest) q.getSingleResult();
				return request;
			} catch (NoResultException e) {
				CardRequest request = null;
				return request;
			}
		}
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
	public void add(String entity, String user, boolean monedero, String state) {

			System.out.println("El usuario "+ user +" ha realizado peticion. Fase: " + entity);
			EntityManager	em =	EMFService.get().createEntityManager();
			CardRequest cardRequest =	new CardRequest(entity, user, monedero, state);
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
	public List<CardRequest> listRequests(String entity, String state) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			//	read	the	existing	entries
			Query q = em
					.createQuery("select	cr	from	CardRequest	cr	where	cr.entity	=	:entity and cr.state = :state");
			q.setParameter("entity", entity);
			q.setParameter("state", state);
			List<CardRequest> userRequest = q.getResultList();
			return userRequest;
		}
	}


	@Override
	public void updateEntity(long id, String entity) {

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
	
	@Override
	public void updateState(long id, String state) {

		synchronized (this)	{
			EntityManager em = EMFService.get().createEntityManager();
			try {
				CardRequest cardRequest = em.find(CardRequest.class, id);
				cardRequest.setState(state);
				em.merge(cardRequest);
			} finally {
				em.close();
			}
		}
		
	}

}
