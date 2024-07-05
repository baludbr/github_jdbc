package Entities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddMovie
 */
@WebServlet("/AddMovie")
public class AddMovie extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddMovie() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        String yearStr = request.getParameter("year");
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                // Database connection details
                String jdbcUrl = "jdbc:mysql://localhost:3306/Project";
                String username = "root";
                String password = "Baludbr@14";
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                
                // SQL query to insert movie details
                String sql = "INSERT INTO movies (title, genre, year, user_id) VALUES (?, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, genre);
                preparedStatement.setInt(3, Integer.parseInt(yearStr));
                preparedStatement.setInt(4, userId);
                
                // Execute the insertion
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Movie added successfully");
                    // Optionally, you can set a success message and forward to a confirmation page
                    request.setAttribute("message", "Movie added successfully");
                    request.getRequestDispatcher("Add_Movie.jsp").forward(request, response);
                } else {
                    System.out.println("Failed to add movie");
                    // Optionally, set an error message and forward to an error page
                    request.setAttribute("message", "Failed to add movie");
                    request.getRequestDispatcher("Add_Movie.jsp").forward(request, response);
                }
            } catch (Exception e) {
                System.out.println(e);
                // Handle any exceptions and optionally forward to an error page
                request.setAttribute("message", "An error occurred: " + e.getMessage());
                request.getRequestDispatcher("Add_Movie.jsp").forward(request, response);
            } finally {
                // Close resources
                try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) { }
                try { if (connection != null) connection.close(); } catch (Exception e) { }
            }
        } else {
            System.out.println("User ID is null. User might not be logged in.");
            // Optionally, set an error message and forward to the login page
            request.setAttribute("message", "Please log in to add a movie.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
