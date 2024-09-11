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

import project.Teacher;

@WebServlet("/AddTeacher")
public class TeacherInsert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve form data
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String number = req.getParameter("number");

        // Set up EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        int id1 = Integer.parseInt(id);
        double number1 = Double.parseDouble(number);

        try {
            // Check if the teacher already exists
            Teacher existingTeacher = em.find(Teacher.class, id1);

            if (existingTeacher == null) {
                Teacher newTeacher = new Teacher();
                newTeacher.setId(id1);
                newTeacher.setName(name);
                newTeacher.setEmail(email);
                newTeacher.setNumber(number1);

                et.begin();
                em.persist(newTeacher);
                et.commit();

                // Success response
                resp.setContentType("text/html");
                PrintWriter pw = resp.getWriter();
                pw.println("<html><head><title>Teacher Addition Success</title>");
                pw.println("<style>body { font-family: Arial, sans-serif; text-align: center; padding: 20px; }");
                pw.println("h2 { color: green; } a { color: blue; text-decoration: none; } a:hover { color: darkblue; }</style>");
                pw.println("</head><body>");
                pw.println("<h2>Teacher Added Successfully!</h2>");
                pw.println("<a href='Teacher.html'>Back to Teacher Modification</a>");
                pw.println("</body></html>");
            } else {
                // Teacher already exists response
                resp.setContentType("text/html");
                PrintWriter pw = resp.getWriter();
                pw.println("<html><head><title>Teacher Addition Failed</title>");
                pw.println("<style>body { font-family: Arial, sans-serif; text-align: center; padding: 20px; }");
                pw.println("h2 { color: red; } a { color: blue; text-decoration: none; } a:hover { color: darkblue; }</style>");
                pw.println("</head><body>");
                pw.println("<h2>Teacher data already present!</h2>");
                pw.println("<a href='Teacher.html'>Back to Teacher Modification</a>");
                pw.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            // Handle invalid number format
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
            // Close EntityManager
            em.close();
            emf.close();
        }
    }
}
