package com.pomot.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProdutorEntityManager {

	private EntityManagerFactory factory;
	
	public ProdutorEntityManager() {
		this.factory = Persistence.createEntityManagerFactory("Util");
	}
	
	@Produces
	@ApplicationScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager){
		manager.close();
	}
}
