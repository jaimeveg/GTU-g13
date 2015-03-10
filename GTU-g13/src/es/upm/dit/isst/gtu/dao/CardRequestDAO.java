package es.upm.dit.isst.gtu.dao;

import java.util.List;

import es.upm.dit.isst.gtu.model.CardRequest;

public interface CardRequestDAO {

	public List<CardRequest> listCardRequests();
	public List<CardRequest> listUserRequests();
	public List<CardRequest> listUniversityRequests();
	public List<CardRequest> listBankRequests();
	public void add	(String	entity, String user);
	public void update (String entity, String user);
	//public List<CardRequest>	getCardRequest(String userId);
	public void remove	(long id);
	//public List<String>	getUsers();
	
}
