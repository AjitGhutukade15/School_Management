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
import project.Teacher;

@WebServlet("/AddTeacher")
public class TeacherInsert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String number = req.getParameter("number");


		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		int id1 = Integer.parseInt(id);
		Teacher PF = em.find(Teacher.class, id1);
		
		double number1 = Double.parseDouble(number);
		

		if (PF == null) {
			Teacher P = new Teacher();
			P.setId(id1);
			P.setName(name);
			P.setEmail(email);
			P.setNumber(number1);

			et.begin();
			em.persist(P);
			et.commit();
			PrintWriter pw = resp.getWriter();
			pw.write("Teacher Added success");
			RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");

			rd.include(req, resp);
			resp.setContentType("text/html");

			System.out.println("Data Store");
		} else {
			System.out.println("Teacher data already present");
			PrintWriter pw = resp.getWriter();
			pw.write("Teacher data already present");
			RequestDispatcher rd = req.getRequestDispatcher("Teacher.html");

			rd.include(req, resp);
			resp.setContentType("text/html");
		}

	}
}
