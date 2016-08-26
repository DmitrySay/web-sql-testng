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

				<h2>Обновить оценку</h2>



				<br> <br>

				<form class="form-group" method="POST"
					action="GlobalServlet?action=formMarkUpdate" name="formMarkUpdate">
					<table>

						<tr>
							<td>Обновление оценки:</td>
						</tr>

						<tr>
							<td>Id</td>
							<td><input type="text" name="idMark" readonly="readonly"
								class="form-control" value='<c:out value="${mark.id}"/>'></td>


						</tr>

						<tr>
							<td>Id студента</td>
							<td><input type="text" name="studentId" class="form-control"
								value="${mark.studentId}"></td>
						</tr>

						<tr>
							<td>Оценка</td>
							<td><input type="text" name="mark" class="form-control"
								value='<c:out value="${mark.mark}"/>'></td>
						</tr>

						<tr>
							<td><input type="submit" class="form-control"
								value=" Сохранить "></td>
						</tr>

					</table>
				</form>

				<p>
					<a href="/lesson11/MainPage.html">На главную страницу</a>
				</p>
				<p>
					<a href="GlobalServlet?action=listMark">Журнал оценок</a>
				</p>




			</div>
		</div>
	</div>



</body>
</html>