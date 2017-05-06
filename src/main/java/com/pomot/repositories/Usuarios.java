package com.pomot.repositories;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.pomot.entities.Usuario;
import com.pomot.util.Transacional;

public class Usuarios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private EntityManager manager;
	
	@Transacional
	public Usuario procurarPorId(Long id) {
		return manager.find(Usuario.class, id);
	}
	
	@Transacional
	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	@Transacional 
	public void remover(Usuario usuario) {
		usuario = procurarPorId(usuario.getId());
		manager.remove(usuario);
	}
	
	
}
