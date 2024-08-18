
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Job;
import databaseConnect.Connect;

@WebServlet("/delete")
public class DeleteJobServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));

			Job dao = new Job(Connect.getConn());
			boolean f = dao.deleteJob(id);

			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("succMsg", "Job Deleted Sucessfully..");
				resp.sendRedirect("view_jobs.jsp");
			} else {
				session.setAttribute("succMsg", "Something went wrong on server!!");
				resp.sendRedirect("view_jobs.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
