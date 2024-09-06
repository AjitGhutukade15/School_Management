package drivers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import project.Teacher;

@WebServlet("/DeleteTeacher")
public class TeacherDelete extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id = req.getParameter("Teacher_id");

		try
		{
			int id1 = Integer.parseInt(id);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();

			Teacher teacher = em.find(Teacher.class, id1);
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			
			if (teacher != null)
			{
				et.begin();
				em.remove(teacher);
				et.commit();
				
				pw.write("<div style='color: green; font-size: 18px; text-align: center; padding: 10px;'>");
				pw.write("Teacher deleted successfully.");
				pw.write("</div>");
				
				RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");
				rd.include(req, resp);
			}
			else
			{
				pw.write("<div style='color: red; font-size: 18px; text-align: center; padding: 10px;'>");
				pw.write("Error: Teacher data not present. Please try again.");
				pw.write("</div>");
				
				RequestDispatcher rd = req.getRequestDispatcher("TeacherDelete.html");
				rd.include(req, resp);
			}
		}
		catch (NumberFormatException e)
		{
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			
			pw.write("<div style='color: orange; font-size: 18px; text-align: center; padding: 10px;'>");
			pw.write("Invalid input: Please enter a valid numeric ID.");
			pw.write("</div>");
			
			RequestDispatcher rd = req.getRequestDispatcher("TeacherDelete.html");
			rd.include(req, resp);
		}
	}
}
