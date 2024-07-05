package Entities;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:mysql://localhost:3306/Project";
        String username = "root";
        String password = "Baludbr@14";
        response.setContentType("text/html;charset=UTF-8");

        // Get the PrintWriter to write the response
        PrintWriter out = response.getWriter();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            statement = connection.createStatement();
            String sql = "INSERT INTO users (email, password) VALUES (?, ?)";
            
            PreparedStatement  preparedStatement=connection.prepareStatement(sql);

            String userEmail=request.getParameter("email");
            String userPassword=request.getParameter("password");
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);

            // Executing the query
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
            	request.setAttribute("message","Registration Done Successfully");
            	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                 dispatcher.forward(request, response);
            } else {
                System.out.println("User registration failed.");
            }
            
            }
            catch (Exception e) {
            	out.println(e);
            }
        } 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
