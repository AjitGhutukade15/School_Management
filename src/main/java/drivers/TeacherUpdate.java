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

@WebServlet("/updatet")
public class TeacherUpdate extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject") ;
	     EntityManager em = emf.createEntityManager() ;
	     EntityTransaction et = em.getTransaction() ;
	     
	     String id = req.getParameter("id") ;
	     String name = req.getParameter("name") ;
	     String email=req.getParameter("email");
	     String number = req.getParameter("number") ;
	     
	     Teacher t = new Teacher() ;
	     t.setId(Integer.parseInt(id));
	     t.setName(name);
	     t.setEmail(email);
	     t.setNumber(Double.parseDouble(number));

	    
	     
	     et.begin();
	     em.merge(t) ;
	     et.commit();
	     
	     resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter() ;
			pw.write("updated successfully");
			
			RequestDispatcher rd = req.getRequestDispatcher("Teacher.html") ;
			rd.include(req, resp);
    }
}
