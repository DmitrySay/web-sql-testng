<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Список групп:</title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="main-wrapper">
				<h2>Список групп:</h2>
				<table class="table table-bordered">

					<tr>
						<td>Id</td>
						<td>Код группы</td>
						<td>Предмет</td>
						<td>Действие</td>
						<td>Действие</td>
					</tr>


					<c:forEach items="${messageGroup}" var="group">
						<tr>
							<td>${group.id}</td>
							<td>${group.number}</td>
							<td>${group.department}</td>
							<td><a
								href="GlobalServlet?action=deleteGroup&idGroup=<c:out value="${group.id}"/>">Удалить</a></td>
							<td><a
								href="GlobalServlet?action=updateFormGroup&idGroup=<c:out value="${group.id}"/>">Обновить</a></td>

						</tr>
					</c:forEach>

				</table>
				<p>
					<a href="GlobalServlet?action=insertGroup">Добавить группу</a>
				</p>
				<p>
					<a href="/lesson11/MainPage.html">На главную страницу</a>
				</p>

			</div>
		</div>
	</div>
</body>
</html>