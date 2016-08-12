package com.vendas.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// É AppScoped pois deve existir uma factory por aplicação.
@ApplicationScoped
public class EnityManagerProducer {

	private EntityManagerFactory factory;
	
	public EnityManagerProducer() {
		factory = Persistence.createEntityManagerFactory("PedidoPU");
	}
	
	// É reqScoped pois deve existir um enity manager pra cada requisição
	@Produces @RequestScoped
	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	
	// Quando a requisição finalizar, o @Disposes será chamado e fechará o manager
	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
	
}
