package br.com.challengeJava.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.challengeJava.connection.ConnectionFactory;
import br.com.challengeJava.model.bean.User;

public class UserDAO {

	public User create(User user) {

		EntityManager entityManager = ConnectionFactory.getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

		entityManager.close();

		return user;
	}

	public User read(Long id) {

		EntityManager entityManager = ConnectionFactory.getEntityManager();

		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, id);
		entityManager.getTransaction().commit();

		entityManager.close();

		return user;

	}

	public List<User> findAll() {

		EntityManager entityManager = ConnectionFactory.getEntityManager();

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("FROM User user");
		@SuppressWarnings("unchecked")
		List<User> users =  query.getResultList();
		entityManager.getTransaction().commit();

		entityManager.close();

		return users;
	}

	public User update(User user) {

		EntityManager entityManager = ConnectionFactory.getEntityManager();

		entityManager.getTransaction().begin();
		User newUser = entityManager.merge(user);
		entityManager.getTransaction().commit();

		entityManager.close();

		return newUser;
	}

	public void delete(User user) {

		EntityManager entityManager = ConnectionFactory.getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}

}
