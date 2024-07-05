package Entities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetMovieDetails
 */
@WebServlet("/GetMovieDetails")
public class GetMovieDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetMovieDetails() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            List<Movie> movies = new ArrayList<>();
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
             
                String jdbcUrl = "jdbc:mysql://localhost:3306/Project";
                String username = "root";
                String password = "Baludbr@14";
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                
             
                String sql = "SELECT id, title, genre, year FROM movies WHERE user_id = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, userId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int movieId = resultSet.getInt("id");
                    String title = resultSet.getString("title");
                    String genre = resultSet.getString("genre");
                    int year = resultSet.getInt("year");
                    Movie movie = new Movie(movieId, title, genre, year);
                    movies.add(movie);
                }
                request.setAttribute("movies", movies);

                request.getRequestDispatcher("movies.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                // Handle any exceptions and optionally forward to an error page
                request.setAttribute("message", "An error occurred: " + e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } finally {
               
                try { if (resultSet != null) resultSet.close(); } catch (Exception e) { }
                try { if (preparedStatement != null) preparedStatement.close(); } catch (Exception e) { }
                try { if (connection != null) connection.close(); } catch (Exception e) { }
            }
        } else {
            System.out.println("User ID is null. User might not be logged in.");
            request.setAttribute("message", "Please log in to view your movies.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
