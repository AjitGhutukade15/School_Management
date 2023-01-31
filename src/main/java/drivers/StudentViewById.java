package drivers;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Student;

@WebServlet("/ViewOneStudent")
public class StudentViewById extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("student_id");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            int id1 = Integer.parseInt(id);
            Student student = em.find(Student.class, id1);

            if (student != null) {
                int studentId = student.getId();
                String name = student.getName();
                String email = student.getSemail();
                
                double fees = student.getFees();
                request.setAttribute("id1", studentId);
                request.setAttribute("name1", name);
                request.setAttribute("email", email);
                
                request.setAttribute("Fees", fees);
                request.getRequestDispatcher("StudentViewOne.jsp").forward(request, response);
            } else {
                response.getWriter().println("<center>No student data found.</center>");
                request.getRequestDispatcher("StudentView.html").include(request, response);
                response.setContentType("text/html");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("<center>Invalid student id. Please enter a valid student id.</center>");
            request.getRequestDispatcher("StudentView.html").include(request, response);
            response.setContentType("text/html");
        } finally {
            em.close();
            emf.close();
        }
    }
}
