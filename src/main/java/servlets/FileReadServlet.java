package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/FileReadServlet")
public class FileReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		File file = new File("work/lesson11/src/webapp/text.txt");

		FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		try {
			byte[] buffer = new byte[1024];

			while (fileInputStream.read(buffer) != -1) {
				servletOutputStream.write(buffer);
			}
		} finally {
			try {
				servletOutputStream.close();
			} catch (Exception e) {

			}
			try {
				fileInputStream.close();
			} catch (Exception e) {

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Part part = request.getPart("file");
		InputStream fileInputStream = part.getInputStream();
		ServletOutputStream servletOutputStream = response.getOutputStream();
		try {
			byte[] buffer = new byte[1024];

			while (fileInputStream.read(buffer) != -1) {
				servletOutputStream.write(buffer);
			}
		} finally {
			try {
				servletOutputStream.close();
			} catch (Exception e) {

			}
			try {
				fileInputStream.close();
			} catch (Exception e) {

			}
		}

	}
}
