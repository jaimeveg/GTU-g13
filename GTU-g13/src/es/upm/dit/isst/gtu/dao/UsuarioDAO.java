package es.upm.dit.isst.gtu.dao;

import es.upm.dit.isst.gtu.model.Usuario;

public interface UsuarioDAO {
	
	public void add(String userId, String name, String surname, String dni, String university, String bank);
	public Usuario getUsuarioByUserId(String userId);

}
