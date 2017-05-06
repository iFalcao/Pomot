package com.pomot.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.pomot.entities.PomoTempo;
import com.pomot.util.Transacional;

public class PomosTempos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transacional
	public PomoTempo procurarPorId(Long id) {
		return manager.find(PomoTempo.class, id);
	}
	
	@Transacional
	public List<PomoTempo> pesquisarNome(String nome) {
		TypedQuery<PomoTempo> query = manager.createQuery("from pomo_tempo where nome_pomo like ?", PomoTempo.class);
		query.setParameter(1, "%" + nome + "%"); 
		return query.getResultList();
	}
	
	@Transacional
	public List<PomoTempo> listarTodos() {
		TypedQuery<PomoTempo> query = manager.createQuery("select * from pomo_tempo", PomoTempo.class);
		return query.getResultList();
	}
	
	@Transacional
	public PomoTempo guardar(PomoTempo pomot) {
		return manager.merge(pomot);
	}

	@Transacional
	public void remover(PomoTempo pomot) {
		pomot = procurarPorId(pomot.getId());
		manager.remove(pomot);
	}

}
