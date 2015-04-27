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
	private boolean monedero;
	private String state;
	private String dni;
	
	
	public CardRequest(String entity, String user, boolean monedero, String state, String dni){
		this.entity = entity;
		this.user = user;
		this.monedero = monedero;
		this.state = state;
		this.dni = dni;
	
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public boolean getMonedero() {
		return monedero;
	}

	public void setMonedero(boolean mondero) {
		this.monedero = mondero;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
}