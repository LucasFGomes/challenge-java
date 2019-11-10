package br.com.challengeJava.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.challengeJava.connection.ConnectionFactory;
import br.com.challengeJava.model.bean.Phone;

public class PhoneDAO {
	
	public Phone create(Phone phone) {

		EntityManager entityManager = ConnectionFactory.getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(phone);
		entityManager.getTransaction().commit();

		entityManager.close();
		
		return phone;

	}
	
	public List<Phone> findAll() {

		EntityManager entityManager = ConnectionFactory.getEntityManager();

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM Phone phone LEFT JOIN FETCH phone.user");
		@SuppressWarnings("unchecked")
		List<Phone> phones = query.getResultList();
		entityManager.getTransaction().commit();

		entityManager.close();
		
		return phones;
	}

}
