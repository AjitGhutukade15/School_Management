package drivers;
import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet("/updatet")
public class TeacherUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String number = req.getParameter("number");

        try {
            Teacher existingTeacher = em.find(Teacher.class, Integer.parseInt(id));

            if (existingTeacher != null) {
                existingTeacher.setName(name);
                existingTeacher.setEmail(email);
                existingTeacher.setNumber(Double.parseDouble(number));

                et.begin();
                em.merge(existingTeacher);
                et.commit();

                resp.setContentType("text/html");
                PrintWriter pw = resp.getWriter();
                pw.println("<html><head><title>Update Success</title>");
                pw.println("<style>body { font-family: Arial, sans-serif; text-align: center; padding: 20px; }");
                pw.println("h2 { color: green; } a { color: blue; text-decoration: none; } a:hover { color: darkblue; }</style>");
                pw.println("</head><body>");
                pw.println("<h2>Teacher details updated successfully!</h2>");
                pw.println("<a href='Teacher.html'>Back to Teacher Modification</a>");
                pw.println("</body></html>");
            } else {
                resp.setContentType("text/html");
                PrintWriter pw = resp.getWriter();
                pw.println("<html><head><title>Update Failed</title>");
                pw.println("<style>body { font-family: Arial, sans-serif; text-align: center; padding: 20px; }");
                pw.println("h2 { color: red; } a { color: blue; text-decoration: none; } a:hover { color: darkblue; }</style>");
                pw.println("</head><body>");
                pw.println("<h2>Teacher not found!</h2>");
                pw.println("<a href='Teacher.html'>Back to Teacher Modification</a>");
                pw.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();
            pw.println("<html><head><title>Invalid Input</title>");
            pw.println("<style>body { font-family: Arial, sans-serif; text-align: center; padding: 20px; }");
            pw.println("h2 { color: red; } a { color: blue; text-decoration: none; } a:hover { color: darkblue; }</style>");
            pw.println("</head><body>");
            pw.println("<h2>Invalid input. Please check your data and try again.</h2>");
            pw.println("<a href='Teacher.html'>Back to Teacher Modification</a>");
            pw.println("</body></html>");
        } finally {
            em.close();
            emf.close();
        }
    }
}
