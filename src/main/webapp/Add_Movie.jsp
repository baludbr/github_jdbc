<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Movie</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            flex-direction: column;
        }
        .container {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin-top: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-top: 10px;
            color: #555;
        }
        input[type="text"] {
            width: 90%;
            padding: 10px;
            margin: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        nav {
            background-color: #333;
            padding: 10px 0;
            text-align: center;
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
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
     <% String message = (String) request.getAttribute("message");
        if(message!=null) {%>
        <p><%= message %></p>
    <% }%>
        <h1>Add a New Movie</h1>
        <form action="AddMovie" method="post">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required><br>

            <label for="genre">Genre:</label>
            <input type="text" id="genre" name="genre" required><br>

            <label for="year">Year:</label>
            <input type="text" id="year" name="year" required><br>

            <input type="submit" value="Add Movie">
        </form>
    </div>
</body>
</html>
