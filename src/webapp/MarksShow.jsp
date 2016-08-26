<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Список оценок</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="main-wrapper">
				<h2>Список оценок студентов:</h2>
				<div class="col-md-12 col-sm-12 col-xs-12">

					<table class="table table-bordered">

						<tr>
							<td>id</td>
							<td>ID студента</td>
							<td>Имя</td>
							<td>Фамилия</td>
							<td>Оценка</td>
							<td>Действие</td>
							<td>Действие</td>

						</tr>


						<c:forEach items="${listMark}" var="mark">
							<tr>
								<td>${mark.id}</td>
								<td>${mark.studentId}</td>
								<td>${mark.name}</td>
								<td>${mark.surname}</td>
								<td>${mark.mark}</td>
								<td><a
									href="GlobalServlet?action=deleteMark&idMark=<c:out value="${mark.id}"/>">Удалить</a></td>
								<td><a
									href="GlobalServlet?action=updateFormMark&idMark=<c:out value="${mark.id}"/>">Обновить</a></td>

							</tr>
						</c:forEach>

					</table>


				</div>


				<p>
					<a href="GlobalServlet?action=insertMark">Добавить оценку</a>
				</p>
				<p>
					<a href="/lesson11/MainPage.html">На главную страницу</a>
				</p>


			</div>
		</div>
	</div>

</body>
</html>