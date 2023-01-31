package drivers;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.Student;

@WebServlet("/ViewAllStudents")
public class StudentsViewAll extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
    EntityManager em = emf.createEntityManager();

    List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();

    request.setAttribute("students", students);
    request.getRequestDispatcher("StudentsViewAll.jsp").forward(request, response);

    em.close();
    emf.close();
  }
}
