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

@WebServlet("/DeleteStud")
public class StudentDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("student_id");

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        try {
            int id1 = Integer.parseInt(id);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
            EntityManager em = emf.createEntityManager();
            EntityTransaction et = em.getTransaction();

            Student student = em.find(Student.class, id1);
            if (student != null) {
                et.begin();
                em.remove(student);
                et.commit();

                pw.println("<html><body style='font-family: Arial, sans-serif; text-align: center;'>");
                pw.println("<h2 style='color: green;'>Student Deleted Successfully!</h2>");
                pw.println("<a href='Student.html' style='font-size: 18px; padding: 10px 20px; background-color: #04AA6D; color: white; text-decoration: none; border-radius: 5px;'>Back to Form</a>");
                pw.println("</body></html>");
            } else {
                pw.println("<html><body style='font-family: Arial, sans-serif; text-align: center;'>");
                pw.println("<h2 style='color: red;'>Student Data Not Found. Try Again!</h2>");
                pw.println("<a href='StudentDelete.html' style='font-size: 18px; padding: 10px 20px; background-color: #04AA6D; color: white; text-decoration: none; border-radius: 5px;'>Back to Form</a>");
                pw.println("</body></html>");
            }

            em.close();
            emf.close();
        } catch (NumberFormatException e) {
            pw.println("<html><body style='font-family: Arial, sans-serif; text-align: center;'>");
            pw.println("<h2 style='color: red;'>Invalid Input. Enter a Number.</h2>");
            pw.println("<a href='StudentDelete.html' style='font-size: 18px; padding: 10px 20px; background-color: #04AA6D; color: white; text-decoration: none; border-radius: 5px;'>Back to Form</a>");
            pw.println("</body></html>");
        }
    }
}
