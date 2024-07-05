package Entities;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet #HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl = "jdbc:mysql://localhost:3306/Project";
        String username = "root";
        String password = "Baludbr@14";
        response.setContentType("text/html;charset=UTF-8");

        // Get the PrintWriter to write the response
        PrintWriter out = response.getWriter();
        Connection connection = null;

        try {
        	
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            if(connection!=null) {
            	System.out.println(connection);
            }
           
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement  preparedStatement=connection.prepareStatement(sql);

            String userEmail=request.getParameter("email");
            String userPassword=request.getParameter("password");
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            ResultSet r=preparedStatement.executeQuery();
            if(r.next())
            {
            	 int rr=r.getInt("id");
            	 System.out.println(rr);
            	 HttpSession session = request.getSession();
                 session.setAttribute("userId", rr);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
                 dispatcher.forward(request, response);
            }
            	request.setAttribute("message","Incorrect Credentials");
            	RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                 dispatcher.forward(request, response);
        }
        catch(Exception e) {
        	out.print(e);
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
