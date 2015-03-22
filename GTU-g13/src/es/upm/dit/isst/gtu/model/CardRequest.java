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
	private boolean tarj_mon;
	
	public CardRequest(String entity, String user, Boolean tarj_mon){
		this.entity = entity;
		this.user = user;
		this.tarj_mon = tarj_mon;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getTarj_mon() {
		return tarj_mon;
	}

	public void setTarj_mon(Boolean tarj_mon) {
		this.tarj_mon = tarj_mon;
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
