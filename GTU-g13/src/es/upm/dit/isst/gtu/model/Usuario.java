package es.upm.dit.isst.gtu.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable{
	
private static final long serialVersionUID =	1L;
	
	@Id
	@GeneratedValue(strategy	=	GenerationType.IDENTITY)
	private Long id;
	private String entity;
	private String userId;
	private String name;
	private String surname;
	private String dni;
	private String university;
	private String bank;
	private String address;
	
	public Usuario(String entity, String userId, String name, String surname, String dni, String university, String bank, String address) {
		this.entity = entity;
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.dni = dni;
		this.university = university;
		this.bank = bank;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
