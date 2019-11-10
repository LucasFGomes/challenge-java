<%@page import="br.com.challengeJava.controller.UserController"%>
<%@page import="br.com.challengeJava.model.bean.User"%>
<%@page import="br.com.challengeJava.model.bean.Phone"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Challenge Java</title>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.min.js"></script>

	<script src="script.js" type="text/javascript"></script>
</head>

<body>
	<div class="container">
		<form class="form" action="" method="post">
			<div class="row">
				<div class="col-sm">
					<div class="form-group">
						<label for="exampleFormControlInput1">Nome</label> <input type="text" class="form-control" id="name"
							name="name" placeholder="Seu nome" required="required">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">CPF</label> <input type="text" class="form-control" id="cpf"
							name="cpf" placeholder="000.000.000-00" required="required">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">E-mail</label> <input type="email" class="form-control" id="email"
							name="email" placeholder="name@example.com" required="required">
					</div>
					<div class="form-group">
						<label for="exampleFormControlInput1">Senha</label> <input type="password" class="form-control"
							id="password" name="password" placeholder="Sua senha" required="required">
					</div>
				</div>

				<div class="col-sm">
					<div class="form-group">
						<label for="exampleFormControlInput1">DDD</label> <input type="number" class="form-control" id="dddPhone"
							name="dddPhone" placeholder="ddd" value="0" min="0" required="required">
					</div>

					<div id="fieldsPhone">
						<div class="form-group">
							<label for="exampleFormControlInput1">Número</label> <input type="text" class="form-control"
								id="numberPhone" name="numberPhone" placeholder="00000-0000" required="required">
						</div>

						<div class="form-group" id="divTypePhone">
							<label for="exampleFormControlInput1">Tipo</label> <input type="text" class="form-control" id="typePhone"
								name="typePhone" placeholder="Ex.: Celular" required="required">
						</div>
					</div>

					<input type="button" id="morePhone" class="btn btn-primary btn-sm" value="+ Telefone" />

				</div>
			</div>
			<div class="form-group">
				<input type="submit" id="btnSubmit" class="btn btn-primary" value="Salvar" />
			</div>
		</form>


		<div class="row">
			<h3>Listagem de Usuários</h3>
			<table id="tableUsers" class="table table-striped">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Nome</th>
					<th scope="col">CPF</th>
					<th scope="col">E-mail</th>
					<th scope="col"></th>
				</tr>

				<jsp:useBean id="userController" class="br.com.challengeJava.controller.UserController"></jsp:useBean>

				<c:forEach var="user" items="${userController.findUsersAll()}">
					<tr>
						<td>${user.getId()}</td>
						<td>${user.getName()}</td>
						<td>${user.getCpf()}</td>
						<td>${user.getEmail()}</td>
						<td id="actionsUser">
							<button type="button" onclick="alterUser()">Alterar</button>
							<button type="button" onclick="removeUser(this)">Remover</button>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>

		<div class="row">
			<h3>Listagem dos Telefones</h3>
			<table class="table table-striped">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">DDD</th>
					<th scope="col">Número</th>
					<th scope="col">Tipo</th>
					<th scope="col">CPF do Usuário</th>
					<th scope="col"></th>
				</tr>

				<jsp:useBean id="phoneController" class="br.com.challengeJava.controller.PhoneController"></jsp:useBean>

				<c:forEach var="phone" items="${phoneController.findPhonesAll()}">
					<tr>
						<td>${phone.getId()}</td>
						<td>${phone.getDdd()}</td>
						<td>${phone.getNumber()}</td>
						<td>${phone.getType()}</td>
						<td>${phone.getUser().getCpf()}</td>
						<td id="actionsPhone">
							<button type="button" onclick="alterPhone()">Alterar</button>
							<button type="button" onclick="removePhone()">Remover</button>
						</td>
					</tr>
				</c:forEach>

			</table>
		</div>

	</div>

</body>

</html>