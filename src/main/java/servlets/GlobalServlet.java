package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GroupDao;
import dao.MarkDao;
import dao.StudentDao;
import domain.Group;
import domain.Mark;
import domain.Student;

public class GlobalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void selectAllMarks(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			MarkDao markDao = (MarkDao) session.getAttribute("markDao");
			PrintWriter out = response.getWriter();

			try {
				List<Mark> listmark = markDao.selectAllMarks();
				session.setAttribute("listMark", listmark);
				RequestDispatcher rd = request.getRequestDispatcher("/MarksShow.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения selectAllMarks");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода selectAllMarks в Servlet");
		}

	}

	public void deleteMark(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			MarkDao markDao = (MarkDao) session.getAttribute("markDao");
			PrintWriter out = response.getWriter();

			int id = Integer.parseInt(request.getParameter("idMark"));

			try {
				markDao.deleteMark(id);

				List<Mark> listmark = markDao.selectAllMarks();
				session.setAttribute("listMark", listmark);
				RequestDispatcher rd = request.getRequestDispatcher("/MarksShow.jsp");
				rd.forward(request, response);

			} catch (Exception e) {

				out.println("Ошибка выполнения deleteMark");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода deleteMark в Servlet");
		}
	}

	public void selectMark(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			MarkDao markDao = (MarkDao) session.getAttribute("markDao");
			PrintWriter out = response.getWriter();

			int id = Integer.parseInt(request.getParameter("idMark"));

			try {
				Mark mark = markDao.selectMark(id);

				session.setAttribute("mark", mark);
				RequestDispatcher rd = request.getRequestDispatcher("/Mark.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения SelectMark");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода selectMark в Servlet");
		}

	}

	public void insertMark(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			MarkDao markDao = (MarkDao) session.getAttribute("markDao");
			PrintWriter out = response.getWriter();

			try {

				int studentId = Integer.parseInt(request.getParameter("studentId"));
				int mark = Integer.parseInt(request.getParameter("mark"));

				markDao.insertMark(studentId, mark);

				List<Mark> listmark = markDao.selectAllMarks();
				session.setAttribute("listMark", listmark);
				RequestDispatcher rd = request.getRequestDispatcher("/MarksShow.jsp");
				rd.forward(request, response);

			} catch (Exception e) {

				out.println("Ошибка выполнения insertMark");
			}

			out.close();
		} catch (Exception e) {

			System.out.println("Ошибка выполнения метода insertMark в Servlet ");
		}

	}

	public void updateMark(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			HttpSession session = request.getSession();
			MarkDao markDao = (MarkDao) session.getAttribute("markDao");
			PrintWriter out = response.getWriter();

			try {
				int mark = Integer.parseInt(request.getParameter("mark"));
				int studentId = Integer.parseInt(request.getParameter("studentId"));
				int id = Integer.parseInt(request.getParameter("idMark"));

				markDao.updateMark(id, studentId, mark);

				Mark m = markDao.selectMark(id);
				session.setAttribute("mark", m);
				RequestDispatcher rd = request.getRequestDispatcher("/Mark.jsp");
				rd.forward(request, response);

			} catch (Exception e) {

				out.println("Ошибка выполнения updateMark");
			}

			out.close();

		} catch (Exception e) {

			System.out.println("Ошибка выполнения метода updateMark в Servlet ");
		}

	}

	public void selectAllGroups(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			GroupDao groupDao = (GroupDao) session.getAttribute("groupDao");
			PrintWriter out = response.getWriter();

			try {
				List<Group> group = groupDao.selectAllGroups();
				session.setAttribute("messageGroup", group);

				RequestDispatcher rd = request.getRequestDispatcher("/GroupsShow.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения selectAllGroups");
			}
			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода selectAllGroups в Servlet");
		}
	}

	public void deleteGroup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			GroupDao groupDao = (GroupDao) session.getAttribute("groupDao");
			PrintWriter out = response.getWriter();

			int id = Integer.parseInt(request.getParameter("idGroup"));

			try {
				groupDao.deleteGroup(id);

				List<Group> group = groupDao.selectAllGroups();
				session.setAttribute("messageGroup", group);

				RequestDispatcher rd = request.getRequestDispatcher("/GroupsShow.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения deleteGroup");
			}
			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода deleteGroup в Servlet");
		}

	}

	public void selectGroup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			GroupDao groupDao = (GroupDao) session.getAttribute("groupDao");
			PrintWriter out = response.getWriter();

			int id = Integer.parseInt(request.getParameter("idGroup"));

			try {

				Group g = groupDao.selectGroup(id);
				session.setAttribute("group", g);

				RequestDispatcher rd = request.getRequestDispatcher("/Group.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения selectGroup");
			}
			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода selectGroup в Servlet");
		}
	}

	public void updateGroup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			GroupDao groupDao = (GroupDao) session.getAttribute("groupDao");
			PrintWriter out = response.getWriter();

			try {
				int id = Integer.parseInt(request.getParameter("idGroup"));
				int number = Integer.parseInt(request.getParameter("number"));
				String department = request.getParameter("department");

				groupDao.updateGroup(id, number, department);

				Group g = groupDao.selectGroup(id);
				session.setAttribute("group", g);

				RequestDispatcher rd = request.getRequestDispatcher("/Group.jsp");
				rd.forward(request, response);

			} catch (Exception e) {

				out.println("Ошибка выполнения updateGroup");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода updateGroup в Servlet");
		}
	}

	public void insertGroup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			GroupDao groupDao = (GroupDao) session.getAttribute("groupDao");
			PrintWriter out = response.getWriter();

			try {

				int number = Integer.parseInt(request.getParameter("number"));
				String department = request.getParameter("department");

				groupDao.insertGroup(number, department);

				List<Group> group = groupDao.selectAllGroups();
				session.setAttribute("messageGroup", group);
				RequestDispatcher rd = request.getRequestDispatcher("/GroupsShow.jsp");
				rd.forward(request, response);

			} catch (Exception e) {

				out.println("Ошибка выполнения insertGroup");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода insertGroup в Servlet");
		}
	}

	public void selectAllStudentAndGroup(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			StudentDao studentDao = (StudentDao) session.getAttribute("studentDao");
			GroupDao groupDao = (GroupDao) session.getAttribute("groupDao");
			PrintWriter out = response.getWriter();

			try {

				List<Student> list = studentDao.selectAllStudentAndGroup();
				session.setAttribute("listStudent", list);
				List<Group> group = groupDao.selectAllGroups();
				session.setAttribute("messageGroup", group);

				RequestDispatcher rd = request.getRequestDispatcher("/StudentsShow.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения selectAllStudentAndGroup");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода selectAllStudentAndGroup в Servlet");
		}

	}

	public void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			StudentDao studentDao = (StudentDao) session.getAttribute("studentDao");
			PrintWriter out = response.getWriter();
			try {

				int id = Integer.parseInt(request.getParameter("id"));
				studentDao.deleteStudent(id);

				List<Student> list = studentDao.selectAllStudentAndGroup();
				session.setAttribute("listStudent", list);

				RequestDispatcher rd = request.getRequestDispatcher("/StudentsShow.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения deleteStudent");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода deleteStudent в Servlet");
		}

	}

	public void selectStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			StudentDao studentDao = (StudentDao) session.getAttribute("studentDao");
			PrintWriter out = response.getWriter();
			try {

				int id = Integer.parseInt(request.getParameter("id"));

				Student student = studentDao.selectStudent(id);
				session.setAttribute("student", student);

				List<Student> list = studentDao.selectAllStudentAndGroup();
				session.setAttribute("listStudent", list);

				RequestDispatcher rd = request.getRequestDispatcher("/Student.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения selectStudent");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода selectStudent в Servlet");
		}

	}

	public void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			StudentDao studentDao = (StudentDao) session.getAttribute("studentDao");
			PrintWriter out = response.getWriter();
			try {

				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				int groupId = Integer.parseInt(request.getParameter("groupId"));

				studentDao.updateStudent(id, name, surname, groupId);

				Student student = studentDao.selectStudent(id);
				session.setAttribute("student", student);

				RequestDispatcher rd = request.getRequestDispatcher("/Student.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения updateStudent");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода updateStudent в Servlet");
		}

	}

	public void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			StudentDao studentDao = (StudentDao) session.getAttribute("studentDao");
			PrintWriter out = response.getWriter();
			try {

				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				int groupId = Integer.parseInt(request.getParameter("groupId"));
				studentDao.insertStudent(name, surname, groupId);

				List<Student> list = studentDao.selectAllStudentAndGroup();
				session.setAttribute("listStudent", list);
				RequestDispatcher rd = request.getRequestDispatcher("/StudentsShow.jsp");
				rd.forward(request, response);

			} catch (Exception e) {
				out.println("Ошибка выполнения insertStudent");
			}

			out.close();

		} catch (Exception e) {
			System.out.println("Ошибка выполнения метода insertStudent в Servlet");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");

			String action = request.getParameter("action");

			if (action.equalsIgnoreCase("listMark")) {

				selectAllMarks(request, response);

			} else if (action.equalsIgnoreCase("deleteMark")) {

				deleteMark(request, response);

			} else if (action.equalsIgnoreCase("updateFormMark")) {

				selectMark(request, response);

			} else if (action.equalsIgnoreCase("insertMark")) {

				RequestDispatcher rd = request.getRequestDispatcher("/MarkInsert.jsp");
				rd.forward(request, response);

			} else if (action.equalsIgnoreCase("listGroup")) {

				selectAllGroups(request, response);

			} else if (action.equalsIgnoreCase("deleteGroup")) {

				deleteGroup(request, response);

			} else if (action.equalsIgnoreCase("updateFormGroup")) {

				selectGroup(request, response);

			} else if (action.equalsIgnoreCase("insertGroup")) {

				RequestDispatcher rd = request.getRequestDispatcher("/GroupInsert.jsp");
				rd.forward(request, response);

			} else if (action.equalsIgnoreCase("listStudent")) {

				selectAllStudentAndGroup(request, response);

			} else if (action.equalsIgnoreCase("deleteStudent")) {

				deleteStudent(request, response);

			} else if (action.equalsIgnoreCase("updateFormStudent")) {

				selectStudent(request, response);

			} else if (action.equalsIgnoreCase("insertStudent")) {

				RequestDispatcher rd = request.getRequestDispatcher("/StudentInsert.jsp");
				rd.forward(request, response);

			} else {

				RequestDispatcher rd = request.getRequestDispatcher("/");
				rd.forward(request, response);

			}
		} catch (Exception e) {

			System.out.println("Ошибка выполнения метода doGet Servlet ");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();
			String action = request.getParameter("action");

			if (action.equalsIgnoreCase("formMarkUpdate")) {

				String stringmark = request.getParameter("mark");
				String stringstudentId = request.getParameter("studentId");
				String flagMark = "true";

				if ((stringmark.isEmpty()) || stringstudentId.isEmpty()) {

					flagMark = "false";
				}

				if (flagMark.equals("true")) {

					updateMark(request, response);
				} else {
					out.println("Заполните, пожалуйста, все поля. <br>");
				}
			}

			if (action.equalsIgnoreCase("formMarkInsert")) {

				String stringmark = request.getParameter("mark");
				String stringstudentId = request.getParameter("studentId");
				String stringidMark = request.getParameter("idMark");
				String flagMark = "true";

				if ((stringmark.isEmpty()) || stringstudentId.isEmpty()) {

					flagMark = "false";

				}

				if ((stringidMark == null || stringidMark.trim().isEmpty()) & flagMark.equals("true")) {

					insertMark(request, response);

				} else {
					out.println("Заполните, пожалуйста, все поля. <br>");

				}

			}

			if (action.equalsIgnoreCase("formGroupUpdate")) {

				String flagGroup = "true";
				String stringnumber = request.getParameter("number");
				String department = request.getParameter("department");

				if ((stringnumber.isEmpty()) || department.isEmpty()) {
					flagGroup = "false";
				}

				if (flagGroup.equals("true")) {

					updateGroup(request, response);

				} else {
					out.println("Заполните, пожалуйста, все поля. <br>");
				}

			}

			if (action.equalsIgnoreCase("formGroupInsert")) {

				String flagGroup = "true";
				String stringid = request.getParameter("idGroup");
				String stringnumber = request.getParameter("number");
				String department = request.getParameter("department");

				if ((stringnumber.isEmpty()) || department.isEmpty()) {
					flagGroup = "false";
				}

				if ((stringid == null || stringid.trim().isEmpty()) & flagGroup.equals("true")) {

					insertGroup(request, response);

				} else {
					out.println("Заполните, пожалуйста, все поля. <br>");
				}

			}

			if (action.equalsIgnoreCase("formStudentUpdate")) {

				String flagStudent = "true";
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");

				if ((name.isEmpty()) || surname.isEmpty()) {
					flagStudent = "false";
				}

				if (flagStudent.equals("true")) {

					updateStudent(request, response);

				} else {
					out.println("Заполните, пожалуйста, все поля. <br>");
				}
			}

			if (action.equalsIgnoreCase("formStudentInsert")) {
				String flagStudent = "true";
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				String stringid = request.getParameter("id");

				if ((name.isEmpty()) || surname.isEmpty()) {
					flagStudent = "false";
				}

				if ((stringid == null || stringid.trim().isEmpty()) & flagStudent.equals("true")) {

					insertStudent(request, response);
					
				} else {
					out.println("Заполните, пожалуйста, все поля. <br>");
				}
			}

			out.close();

		} catch (Exception e) {

			System.out.println("Ошибка выполнения метода doPost Servlet ");
		}

	}
}
