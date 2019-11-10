package br.com.challengeJava.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
	
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("challengeJava");

	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
}
