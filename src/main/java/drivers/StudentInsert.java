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
import project.Student;

@WebServlet("/AddStudent")
public class StudentInsert extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String number = req.getParameter("number");
		String fees = req.getParameter("fees");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		int id1 = Integer.parseInt(id);
		Student PF = em.find(Student.class, id1);
		double number1 = Double.parseDouble(number);
		double fees1 = Double.parseDouble(fees);
		System.out.println(PF);

		if (PF == null) {
			Student P = new Student();
			P.setId(id1);
			P.setName(name);
			P.setSemail(email);
			P.setSMoNo(number1);
			P.setFees(fees1);

			et.begin();
			em.persist(P);
			et.commit();
			PrintWriter pw = resp.getWriter();
			pw.write("Student Added success");
			RequestDispatcher rd = req.getRequestDispatcher("Student.html");

			rd.include(req, resp);
			resp.setContentType("text/html");

			System.out.println("Data Store");
		} else {
			System.out.println("Student data already present");
			PrintWriter pw = resp.getWriter();
			pw.write("Student data already present");
			RequestDispatcher rd = req.getRequestDispatcher("Student.html");

			rd.include(req, resp);
			resp.setContentType("text/html");
		}

	}
}
