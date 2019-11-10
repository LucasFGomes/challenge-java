$(document).ready(function () {
			$(function () {
				$('.form').submit(function () {
					$.ajax({
						url: '/challenge-java/RegisterUser',
						type: 'POST',
						data: $('.form').serialize(),
						success: function (data) {
							console.log('DADOS: ', data);

							var dataFormat = JSON.parse(data);
							//User
							var tbodyUser = document.querySelectorAll('tbody')[0];
							var trUser = document.createElement('tr');
							
							var td = document.createElement('td');
							var contentTd = document.createTextNode(dataFormat[0].user.id);
							td.appendChild(contentTd);
							trUser.appendChild(td);
							
							var td = document.createElement('td');
							var contentTd = document.createTextNode(dataFormat[0].user.name);
							td.appendChild(contentTd);
							trUser.appendChild(td);
							
							var td = document.createElement('td');
							var contentTd = document.createTextNode(dataFormat[0].user.cpf);
							td.appendChild(contentTd);
							trUser.appendChild(td);
							
							var td = document.createElement('td');
							var contentTd = document.createTextNode(dataFormat[0].user.email);
							td.appendChild(contentTd);
							trUser.appendChild(td);
							
							var btnAlter = document.createElement('button');
							var btnDelete = document.createElement('button');
							
							btnAlter.innerHTML = "Alterar";
							btnAlter.setAttribute("onclick", "alterUser(this)");
							
							btnDelete.innerHTML = "Remover";
							btnDelete.setAttribute("onclick", "removeUser(this)");
							
							var tdButtons = document.createElement("td");
							
							tdButtons.appendChild(btnAlter);
							tdButtons.appendChild(btnDelete);
							
							trUser.appendChild(tdButtons);
							tbodyUser.appendChild(trUser);
							
							//Phones
							var tbodyPhone = document.querySelectorAll('tbody')[1];
							var trPhone = document.createElement('tr');
							
							dataFormat.forEach((element) => {
								var td = document.createElement('td');
								var contentTd = document.createTextNode(element.id);
								td.appendChild(contentTd);
								trPhone.appendChild(td);
								
								var td = document.createElement('td');
								var contentTd = document.createTextNode(element.ddd);
								td.appendChild(contentTd);
								trPhone.appendChild(td);
								
								var td = document.createElement('td');
								var contentTd = document.createTextNode(element.number);
								td.appendChild(contentTd);
								trPhone.appendChild(td);
								
								var td = document.createElement('td');
								var contentTd = document.createTextNode(element.type);
								td.appendChild(contentTd);
								trPhone.appendChild(td);
								
								var td = document.createElement('td');
								var contentTd = document.createTextNode(element.user.cpf);
								td.appendChild(contentTd);
								trPhone.appendChild(td);
							})
							
							var btnAlterPhone = document.createElement('button');
							var btnDeletePhone = document.createElement('button');
							
							btnAlterPhone.innerHTML = "Alterar";
							btnAlterPhone.setAttribute("onclick", "alterPhone(this)");
							
							btnDeletePhone.innerHTML = "Remover";
							btnDeletePhone.setAttribute("onclick", "removePhone(this)");
							
							var tdButtons = document.createElement("td");
							
							tdButtons.appendChild(btnAlterPhone);
							tdButtons.appendChild(btnDeletePhone);
							 
							trPhone.appendChild(tdButtons);
							tbodyPhone.appendChild(trPhone);
							
							
							$("#name").val("");
							$("#cpf").val("");
							$("#email").val("");
							$("#password").val("");
							
							$("#dddPhone").val(0);
							$("#numberPhone").val("");
							$("#typePhone").val("");
							
						}
					})
					return false;
				})
			})
	
			$('#cpf').mask('000.000.000-00', {
				reverse: true
			});

			$('#morePhone').click(function () {
				$('#fieldsPhone').append('<div class="form-group"> <label for="exampleFormControlInput1">Número</label>' +
					'<input type="text" class="form-control" id="numberPhone" name="numberPhone" placeholder="00000-0000">' +
					'</div>' +
					'<div class="form-group" id="divTypePhone"> <label for="exampleFormControlInput1">Tipo</label>' +
					'<input type="text" class="form-control" id="typePhone" name="typePhone" placeholder="Ex.: Celular">' +
					'</div>');
			});
		})
		
		function alterUser() {
		}
		
		function alterPhone() {
		}
		
		function removeUser(row) {
			console.log("DELETAR USER");
			var d = row.parentNode.parentNode.rowIndex;
			console.log(d);
		}
		
		function removePhone() {
			console.log("DELETAR PHONE");
		}