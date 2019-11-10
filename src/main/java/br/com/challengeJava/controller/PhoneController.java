package br.com.challengeJava.controller;

import java.util.List;

import br.com.challengeJava.model.bean.Phone;
import br.com.challengeJava.model.dao.PhoneDAO;

public class PhoneController {
	
	private PhoneDAO phoneDao;
	
	public PhoneController() {
		this.phoneDao = new PhoneDAO();
	}

	public Phone createPhone(Phone phone) {
		return this.phoneDao.create(phone);
	}
	
	public List<Phone> findPhonesAll() {
		return this.phoneDao.findAll();
	}

}
