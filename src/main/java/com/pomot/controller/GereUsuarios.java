package com.pomot.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pomot.entities.Usuario;

@Named
@ViewScoped
public class GereUsuarios {
	
	@Inject
	private Usuario usuario;
	
	
	public String cadastroUsuario(Usuario novoUsuario) {
		
		// Implementar e criar a página de redirecionamento
		return "Página-Redirecionamento";
		
	}
	
	
}
