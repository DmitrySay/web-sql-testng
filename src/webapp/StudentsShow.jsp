<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Список студентов:</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
</head>
<body>


	<div class="container">
		<div class="row">
			<div class="main-wrapper">

				<nav class="navbar navbar-inverse"> <a class="navbar-brand"
					href="GlobalServlet?action=listStudent">Список студентов</a> <a
					class="navbar-brand" href="GlobalServlet?action=listGroup">Список
					групп</a> <a class="navbar-brand" href="GlobalServlet?action=listMark">Журнал
					Оценок</a> </nav>





				<h3>Список студентов:</h3>
				<table class="table table-bordered">

					<tr>
						<td>ID</td>
						<td>Имя</td>
						<td>Фамилия</td>
						<td>Код группы</td>
						<td>Предмет</td>
						<td>Действие</td>
						<td>Действие</td>

					</tr>


					<c:forEach items="${listStudent}" var="student">
						<tr>
							<td>${student.id}</td>
							<td>${student.name}</td>
							<td>${student.surname}</td>
							<td>${student.number}</td>
							<td>${student.department}</td>



							<td><a
								href="GlobalServlet?action=deleteStudent&id=<c:out value="${student.id}"/>">Удалить</a></td>
							<td><a
								href="GlobalServlet?action=updateFormStudent&id=<c:out value="${student.id}"/>">Обновить</a></td>

						</tr>
					</c:forEach>

				</table>
				<p>
					<a href="GlobalServlet?action=insertStudent">Добавить студента</a>
				</p>


				<h5>
					<a href="/lesson11/MainPage.html">На главную страницу</a>
				</h5>


			</div>
		</div>
	</div>

</body>
</html>