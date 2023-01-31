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

import project.Teacher;

@WebServlet("/ViewAllTeacher")
public class TeacherViewAll extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
    EntityManager em = emf.createEntityManager();

    List<Teacher> Teacher = em.createQuery("SELECT s FROM Teacher s", Teacher.class).getResultList();

    request.setAttribute("Teacher", Teacher);
    request.getRequestDispatcher("TeacherViewAll.jsp").forward(request, response);

    em.close();
    emf.close();
  }
}
