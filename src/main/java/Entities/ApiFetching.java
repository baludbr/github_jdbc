package Entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class ApiFetching
 */
@WebServlet("/ApiFetching")
public class ApiFetching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiFetching() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieTitle = request.getParameter("movie"); // For testing, you can set it dynamically via request parameter
        if (movieTitle == null || movieTitle.isEmpty()) {
            response.getWriter().println("Please provide a movie title.");
            return;
        }

        try {
            // Make an HTTP GET request to the OMDB API
            String apiKey = "a26d47ae"; // Replace with your OMDB API key
            String apiUrl = "https://www.omdbapi.com/?t=" + movieTitle + "&apikey=" + apiKey;
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            connection.disconnect();

            // Parse JSON response
            JSONObject jsonResponse = new JSONObject(content.toString());

            // Extract details
            String title = jsonResponse.getString("Title");
            String year = jsonResponse.getString("Year");
            String director = jsonResponse.getString("Director");
            String genre = jsonResponse.getString("Genre");
            String actor = jsonResponse.getString("Actors");
            JSONArray jsonArray = new JSONArray(jsonResponse.getString("Ratings"));

            JSONObject jsonObject = jsonArray.getJSONObject(0);

            String imdbRating = jsonObject.getString("Value");
            System.out.println(imdbRating);
            // Create MovieDetails object and set details
            MovieDetails movieDetails = new MovieDetails();
            movieDetails.setTitle(title);
            movieDetails.setYear(year);
            movieDetails.setDirector(director);
            movieDetails.setGenre(genre);
            movieDetails.setActors(actor);
            movieDetails.setImdb(imdbRating);
            
            // Set attribute and forward to JSP
            request.setAttribute("details", movieDetails);
            RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
            dispatcher.forward(request, response);
	}
    catch(Exception e){
    System.out.println(e);
    
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
