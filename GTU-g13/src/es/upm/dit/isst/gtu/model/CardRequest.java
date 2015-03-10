package es.upm.dit.isst.gtu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CardRequest implements Serializable{
	
	private static final long serialVersionUID =	1L;
	
	@Id
	@GeneratedValue(strategy	=	GenerationType.IDENTITY)
	private Long id;
	private String entity;
	private String user;
	
	public CardRequest(String entity, String user){
		this.entity = entity;
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	

}
