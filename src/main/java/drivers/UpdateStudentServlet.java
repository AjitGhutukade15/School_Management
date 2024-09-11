package drivers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import project.Student;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        
        try {
            // Retrieve form data
            String idStr = request.getParameter("id");
            String name = request.getParameter("name");
            String Semail = request.getParameter("email");
            String SMoNoStr = request.getParameter("number");
            String feesStr = request.getParameter("fees");

            // Convert ID, SMoNo, and fees to appropriate types
            int id = Integer.parseInt(idStr);
            double SMoNo = Double.parseDouble(SMoNoStr);
            double fees = Double.parseDouble(feesStr);
            
            // Set up entity manager
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("SchoolProject");
            EntityManager em = emf.createEntityManager();

            // Begin transaction
            em.getTransaction().begin();

            // Find the student by ID
            Student student = em.find(Student.class, id);
            if (student == null) {
                throw new Exception("Student not found with ID: " + id);
            }

            // Update student details
            student.setName(name);
            student.setSemail(Semail);
            student.setSMoNo(SMoNo);
            student.setFees(fees);

            // Commit transaction
            em.getTransaction().commit();

            // Close entity manager
            em.close();
            emf.close();

            // Success response
            response.getWriter().println("<html><head><style>"
                + "body { font-family: Arial, sans-serif; background-color: #f7f7f7; text-align: center; padding: 20px; }"
                + ".message-container { background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); display: inline-block; }"
                + "a { text-decoration: none; color: #04AA6D; font-size: 18px; padding: 10px 20px; border: 1px solid #04AA6D; border-radius: 10px; }"
                + "a:hover { background-color: #04AA6D; color: white; }"
                + "</style></head><body>"
                + "<div class='message-container'>"
                + "<h2>Student details updated successfully!</h2>"
                + "<a href='StudentUpdate.html'>Back to Main Menu</a>"
                + "</div></body></html>");

        } catch (Exception e) {
            // Handle errors and display error message
            response.getWriter().println("<html><head><style>"
                + "body { font-family: Arial, sans-serif; background-color: #f7f7f7; text-align: center; padding: 20px; }"
                + ".message-container { background-color: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); display: inline-block; }"
                + "a { text-decoration: none; color: #04AA6D; font-size: 18px; padding: 10px 20px; border: 1px solid #04AA6D; border-radius: 10px; }"
                + "a:hover { background-color: #04AA6D; color: white; }"
                + "</style></head><body>"
                + "<div class='message-container'>"
                + "<h2>Error: " + e.getMessage() + "</h2>"
                + "<a href='StudentUpdate.html'>Back to Main Menu</a>"
                + "</div></body></html>");
        }
    }
}
