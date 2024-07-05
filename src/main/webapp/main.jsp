<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="Entities.MovieDetails" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Navigation Menu</title>
    <style>
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            background-color: #f9f9f9;
        }
        h1 {
            text-align: center;
        }
        .movie-details {
            margin: 20px 0;
        }
        .movie-details p {
            margin: 10px 0;
        }
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        nav {
            background-color: #333;
            padding: 10px 0;
            text-align: center;
        }
        nav a {
            display: inline-block;
            padding: 10px 20px;
            margin: 0 5px;
            text-decoration: none;
            color: #fff;
            transition: background-color 0.3s, color 0.3s;
        }
        nav a:hover {
            background-color: #ff7200;
        }
        
    </style>
</head>
<body>
    <nav>
        <a href="main.jsp">Get Movie Details</a>
        <a href="Add_Movie.jsp">Add Movie</a>
          <a href="GetMovieDetails"> All Movies</a>
        <a href="AddPlaylist.jsp">Add Playlist</a>
        <a href="logout">Logout</a>
    </nav>
    <div class="container">
        <h1>Movie Details</h1>
        <div class="movie-details">
        <form action="ApiFetching" method="POST">
          <input type="input" name="movie" placeholder="Enter your movie Name"><Button type="submit">Get Now!!</Button>
        </form>
            <%
            Entities.MovieDetails movieDetails = (Entities.MovieDetails) request.getAttribute("details");
                                                    if (movieDetails != null) {
            %>
                <p><strong>Title:</strong> <%= movieDetails.getTitle() %></p>
                <p><strong>Year:</strong> <%= movieDetails.getYear() %></p>
                <p><strong>Director:</strong> <%= movieDetails.getDirector() %></p>
                <p><strong>Actors:</strong> <%= movieDetails.getActors() %></p>
                <p><strong>Genre:</strong> <%= movieDetails.getGenre() %></p>
                <p><strong>IMDB Rating:</strong> <%= movieDetails.getImdb() %></p>
            <%
                } else {
            %>
                <p>No movie details available.</p>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>
