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
        Student student = em.find(Student.class, id1);
        double number1 = Double.parseDouble(number);
        double fees1 = Double.parseDouble(fees);

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        if (student == null) {
            Student newStudent = new Student();
            newStudent.setId(id1);
            newStudent.setName(name);
            newStudent.setSemail(email);
            newStudent.setSMoNo(number1);
            newStudent.setFees(fees1);

            et.begin();
            em.persist(newStudent);
            et.commit();

            pw.println("<html><body style='font-family: Arial, sans-serif; text-align: center;'>");
            pw.println("<h2 style='color: green;'>Student Added Successfully!</h2>");
            pw.println("<a href='Student.html' style='font-size: 18px; padding: 10px 20px; background-color: #04AA6D; color: white; text-decoration: none; border-radius: 5px;'>Back to Form</a>");
            pw.println("</body></html>");
        } else {
            pw.println("<html><body style='font-family: Arial, sans-serif; text-align: center;'>");
            pw.println("<h2 style='color: red;'>Student Data Already Present!</h2>");
            pw.println("<a href='Student.html' style='font-size: 18px; padding: 10px 20px; background-color: #04AA6D; color: white; text-decoration: none; border-radius: 5px;'>Back to Form</a>");
            pw.println("</body></html>");
        }

        em.close();
        emf.close();
    }
}
