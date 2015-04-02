package es.upm.dit.isst.gtu.dao;

import java.util.List;

import es.upm.dit.isst.gtu.model.Usuario;

public interface UsuarioDAO {
	
	public void add(String entity, String userId, String name, String surname, String dni, String university, String bank);
	public Usuario getUsuarioByUserId(String userId);
	public List<Usuario> listUsersByEntity(String entity);
	public void remove(Long id);

}
