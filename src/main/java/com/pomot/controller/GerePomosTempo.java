package com.pomot.controller;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.pomot.entities.PomoTempo;

@Named
@ViewScoped
public class GerePomosTempo {

	@Inject
	private PomoTempo pomotempo;
	
	
	public String criarPomoTempo(PomoTempo novoPomoTempo) {
		
		// Implementar e criar p�gina de redirecionamento
		
		return "P�gina de Redirecionamento";
	}
	
	public String excluirPomoTempo(PomoTempo excluiPomoTempo) {
		
		// Implementar e criar p�gina de redirecionamento
		
		return "P�gina de Redirecionamento";
	}
	
	public String alterarPomoTempo(PomoTempo alteraPomoTempo) {
		
		// Implementar e criar p�gina de redirecionamento
		
		return "P�gina de Redirecionamento";
	}
}
