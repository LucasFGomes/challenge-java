package br.com.challengeJava.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.challengeJava.controller.PhoneController;
import br.com.challengeJava.controller.UserController;
import br.com.challengeJava.model.bean.Phone;
import br.com.challengeJava.model.bean.User;

public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterUser() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		int ddd = Integer.parseInt(request.getParameter("dddPhone"));
		String[] numberPhones = request.getParameterValues("numberPhone");
		String[] typePhones = request.getParameterValues("typePhone");

		List<Phone> phones = new ArrayList<Phone>();
		List<Phone> phonesRegistered = new ArrayList<Phone>();
		UserController userController = new UserController();
		PhoneController phoneController = new PhoneController();
		
		User user = new User();
		user.setName(name);
		user.setCpf(cpf);
		user.setEmail(email);
		user.setPassword(password);
		
		for (int i = 0; i < numberPhones.length; i++) {
			Phone phone = new Phone();
			phone.setDdd(ddd);
			phone.setNumber(numberPhones[i]);
			phone.setType(typePhones[i]);
			phone.setUser(user);
			phones.add(phone);
		}
		
		userController.createUser(user);
		
		for (Phone phone : phones) {
			Phone p = phoneController.createPhone(phone);
			phonesRegistered.add(p);
		}
		
		Gson gson = new Gson();
		String phoneJson = gson.toJson(phonesRegistered);

		response.getWriter().write(phoneJson);
	}

}
