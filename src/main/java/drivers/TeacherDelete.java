package drivers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Entity;
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

import project.Student;
import project.Teacher;
@WebServlet("/DeleteTeacher")
public class TeacherDelete extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id=req.getParameter("Teacher_id");
		
		try
		{
			int id1=Integer.parseInt(id);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			Teacher S=em.find(Teacher.class, id1);
			if(S!=null)
			{
				et.begin();
				em.remove(S);
				et.commit();
				PrintWriter pw = resp.getWriter();
				pw.write("Teacher delete success");
				RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");

				rd.include(req, resp);
				resp.setContentType("text/html");
			}
			else
			{
				PrintWriter pw = resp.getWriter();
				pw.write("Teacher data is not present try again");
				RequestDispatcher rd = req.getRequestDispatcher("TeacherDelete.html");

				rd.include(req, resp);
				resp.setContentType("text/html");
			}
		}
		catch(NumberFormatException e)
		{
			PrintWriter pw = resp.getWriter();
			pw.write("Invalid input, enter a number");
			RequestDispatcher rd = req.getRequestDispatcher("TeacherDelete.html");

			rd.include(req, resp);
			resp.setContentType("text/html");
		}
	}

}
