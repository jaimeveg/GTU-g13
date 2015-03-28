package es.upm.dit.isst.gtu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import es.upm.dit.isst.gtu.model.CardRequest;
import es.upm.dit.isst.gtu.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private static UsuarioDAOImpl instance;
	
	private UsuarioDAOImpl(){
	}

	public static UsuarioDAOImpl getInstance(){
		if (instance ==	null)
			instance =	new UsuarioDAOImpl();
		return instance;
	}
	
	@Override
	public void add(String entity, String userId, String name, String surname, String dni,
			String university, String bank) {

		EntityManager	em =	EMFService.get().createEntityManager();
		Usuario usuario =	new Usuario(entity, userId, name, surname, dni, university, bank);
		em.persist(usuario);
		em.close();

	}

	@Override
	public Usuario getUsuarioByUserId(String userId) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			//	read	the	existing	entries
			try{
				Query q = em
					.createQuery("select	u	from	Usuario	u	where	u.userId	=	:userId");
				q.setParameter("userId", userId);
				Usuario usuario = (Usuario) q.getSingleResult();
				return usuario;
			}catch(NoResultException e){
				Usuario usuario = null;
				return usuario;
			}
		}
	}
	
	public List<Usuario> listUsersByEntity(String entity){
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			//	read	the	existing	entries
			try {
				Query q = em
						.createQuery("select	u	from	Usuario	u	where	u.entity	=	:entity");
				q.setParameter("entity", entity);
				List<Usuario> userRequest = q.getResultList();
				return userRequest;
			} catch (NoResultException e) {
				List<Usuario> userRequest = null;
				return userRequest;
			}
		}
	}

}
