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

import project.Principle;

@WebServlet("/insert")
public class InsertPrinciple extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String number = req.getParameter("number");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Principle PF = em.find(Principle.class, email);
		int id1 = Integer.parseInt(id);
		int age1 = Integer.parseInt(age);
		double MOnum = Double.parseDouble(number);
		System.out.println(PF);
		if (PF == null) {
			Principle P = new Principle();
			P.setId(id1);
			P.setPname(name);
			P.setAge(age1);
			P.setEmail(email);
			P.setPassward(password);
			P.setMoNO(MOnum);

			et.begin();
			em.persist(P);
			et.commit();
			PrintWriter pw = resp.getWriter();
			pw.write("Account Created please login");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");

			rd.include(req, resp);
			resp.setContentType("text/html");

			System.out.println("Data Store");
		} else {
			System.out.println("data already present");
			PrintWriter pw = resp.getWriter();
			pw.write("data already present please login");
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");

			rd.include(req, resp);
			resp.setContentType("text/html");
		}

	}

}
