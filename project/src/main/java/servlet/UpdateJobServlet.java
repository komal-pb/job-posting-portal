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
import entity.Jobs;

@WebServlet("/update")
public class UpdateJobServlet extends HttpServlet  {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String title = req.getParameter("title");
			String location = req.getParameter("location");
			String category = req.getParameter("category");
			String status = req.getParameter("status");
			String desc = req.getParameter("desc");

			Jobs j = new Jobs();
			j.setId(id);
			j.setTitle(title);
			j.setDescription(desc);
			j.setLocation(location);
			j.setStatus(status);
			j.setCategory(category);

			HttpSession session = req.getSession();

			Job dao = new Job(Connect.getConn());
			boolean f = dao.updateJob(j);
			if (f) {
				session.setAttribute("succMsg", "Job Updated Sucessfully..");
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
