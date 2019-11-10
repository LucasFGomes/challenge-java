package br.com.challengeJava.controller;

import java.util.List;

import br.com.challengeJava.model.bean.User;
import br.com.challengeJava.model.dao.UserDAO;

public class UserController {

	private UserDAO userDao;

	public UserController() {
		this.userDao = new UserDAO();
	}

	public User createUser(User user) {
		return this.userDao.create(user);
	}

	public List<User> findUsersAll() {
		return this.userDao.findAll();
	}

	public User readUser(Long id) {
		return this.userDao.read(id);
	}

	public User updateUser(User user) {
		return this.userDao.update(user);
	}

	public void deleteUser(User user) {
		this.userDao.delete(user);
	}

}
