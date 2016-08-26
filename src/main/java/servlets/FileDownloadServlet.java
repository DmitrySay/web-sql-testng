package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String filename = ("work/lesson11/src/webapp/2.txt");

		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		File file = new File(filename);

		FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStream = response.getOutputStream();

		try {
			byte[] buffer = new byte[1024];

			int read = 0;
			while ((read = fileInputStream.read(buffer, 0, 1024)) != -1) {
				servletOutputStream.write(buffer, 0, read);

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
