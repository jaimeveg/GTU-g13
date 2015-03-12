package es.upm.dit.isst.gtu.dao;

import java.util.List;

import es.upm.dit.isst.gtu.model.CardRequest;

public interface CardRequestDAO {

	public List<CardRequest> listCardRequests();
	public List<CardRequest> listEntityRequests(String entity);
	public void add	(String	entity, String user);
	public void update (long id, String entity);
	//public List<CardRequest>	getCardRequest(String userId);
	public void remove	(long id);
	//public List<String>	getUsers();
	
}
