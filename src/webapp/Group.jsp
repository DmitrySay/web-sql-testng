<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="main-wrapper">

				<h2>Группа:</h2>




				<form class="form-group" method="POST"
					action="GlobalServlet?action=formGroupUpdate"
					name="formGroupUpdate">
					<table>

						<tr>
							<td>Обновление группы:</td>
						</tr>

						<tr>
							<td>Id</td>
							<td><input type="text" name="idGroup" readonly="readonly"
								class="form-control" value="<c:out value="${group.id}"/>"></td>


						</tr>

						<tr>
							<td>Код группы</td>
							<td><input type="text" name="number" class="form-control"
								value="${group.number}"></td>
						</tr>

						<tr>
							<td>Предмет</td>
							<td><input type="text" name="department"
								class="form-control"
								value="<c:out value="${group.department}"/>"></td>
						</tr>

						<tr>
							<td><input type="submit" value="Сохранить"
								class="form-control"></td>
						</tr>

					</table>
				</form>

				<p>
					<a href="/lesson11/MainPage.html">На главную страницу</a>
				</p>
				<p>
					<a href="GlobalServlet?action=listGroup">Посмотрите все группы!</a>
				</p>

			</div>
		</div>
	</div>

</body>
</html>