package drivers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Principle;

@WebServlet("/ValidateLogin")
public class LoginValidate extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Principle p1 = em.find(Principle.class, email);

		System.out.println(p1);

		if (p1 != null)
		{
			if (p1.getPassward().equals(password)) {
				System.out.println("login success");
				PrintWriter pw = resp.getWriter();
				
				RequestDispatcher rd = req.getRequestDispatcher("LoginSuccess.html");

				rd.include(req, resp);
				resp.setContentType("text/html");
			} 
			else {
				System.out.println("TRy again");
				PrintWriter pw = resp.getWriter();
				pw.write("login failed try again");
				RequestDispatcher rd = req.getRequestDispatcher("Login.html");

				rd.include(req, resp);
				resp.setContentType("text/html");
			}

		} 
		else 
		{
			System.out.println("TRy again");
			PrintWriter pw = resp.getWriter();
			pw.write("login failed try again");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");

			rd.include(req, resp);
			resp.setContentType("text/html");
		}

	}

}
