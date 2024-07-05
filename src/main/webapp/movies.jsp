<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Entities.Movie" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Movies</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
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
        h1 {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<nav>
    <a href="main.jsp">Get Movie Details</a>
    <a href="Add_Movie.jsp">Add Movie</a>
    <a href="GetMovieDetails.jsp">All Movies</a>
    <a href="AddPlaylist.jsp">Add Playlist</a>
    <a href="logout">Logout</a>
</nav>
<h1>My Movies</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Year</th>
        </tr>
    </thead>
    <tbody>
        <% for (Entities.Movie movie : (List<Entities.Movie>) request.getAttribute("movies")) { %>
            <tr>
                <td><%= movie.getId() %></td>
                <td><%= movie.getTitle() %></td>
                <td><%= movie.getGenre() %></td>
                <td><%= movie.getYear() %></td>
            </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>
