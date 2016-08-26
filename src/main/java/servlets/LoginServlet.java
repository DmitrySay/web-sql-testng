package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

import domain.User;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		
		PrintWriter out = response.getWriter();

		if ((username != null) && (password != null)) {
			HttpSession session = request.getSession();
			UserDao userDao = (UserDao) session.getAttribute("userDao");
			try {
				List<User> userlist = userDao.selectAllUsers();

				for (int i = 0; i < userlist.size(); i++) {

					if ((userlist.get(i).getUsername().equals(username))
							&& (userlist.get(i).getPassword().equals(password))) {
						User u = new User();
						u.setUsername(username);
						u.setPassword(password);
						session.setAttribute("PRINCIPAL", u);
						response.sendRedirect("/lesson11/MainPage.html");

					} else {
						
						out.println("Нет такого пользователя или пароля");
					}

				}

			} catch (Exception e) {

				out.println("Ошибка выполнения selectAllUsers");
			}
		}else {out.println("null");}

		out.close();
	}

}
