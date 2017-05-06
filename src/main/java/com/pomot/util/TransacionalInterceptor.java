package com.pomot.util;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Interceptor
@Transacional
@Priority(Interceptor.Priority.APPLICATION)
public class TransacionalInterceptor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject 
	public EntityManager manager;
	
	@AroundInvoke
	public Object invocar(InvocationContext context) throws Exception{
		EntityTransaction trx = manager.getTransaction();
		boolean criador = false;
		
		try {
			if (trx.isActive()) {
				trx.begin();
				trx.rollback();
				// Truque feito para voltar os commits que foram realizados
				// sem estares denotados Transacionais
				trx.begin();
				
				criador = true;
			}
			return context.proceed();
			
		} catch(Exception e) {
			
			if (trx != null && criador) {
				trx.rollback();
			}
			throw e;
			
		} finally {
			
			if (trx != null && trx.isActive() && criador) {
				trx.commit();
			}
		}
	}
}
