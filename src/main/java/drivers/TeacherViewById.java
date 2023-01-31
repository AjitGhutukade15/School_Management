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

import project.Teacher;

@WebServlet("/ViewOneTeacher")
public class TeacherViewById extends HttpServlet {


protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String id = request.getParameter("teacher_id");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    try {
        int id1 = Integer.parseInt(id);
        Teacher teacher = em.find(Teacher.class, id1);

        if (teacher != null) {
            int teacherId = teacher.getId();
            String name = teacher.getName();
            String email = teacher.getEmail();
            double Number = teacher.getNumber();
            request.setAttribute("id1", teacherId);
            request.setAttribute("name1", name);
            request.setAttribute("email", email);
            request.setAttribute("Number", Number);
            request.getRequestDispatcher("TeacherViewOne.jsp").forward(request, response);
        } else {
            response.getWriter().println("<center>No teacher data found.</center>");
            request.getRequestDispatcher("viewTeacher.html").include(request, response);
            response.setContentType("text/html");
        }
    } catch (NumberFormatException e) {
        response.getWriter().println("<center>Invalid teacher id. Please enter a valid teacher id.</center>");
        request.getRequestDispatcher("viewTeacher.html").include(request, response);
        response.setContentType("text/html");
    } finally {
        em.close();
        emf.close();
    }
}
}