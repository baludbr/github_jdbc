<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blood Bank Donation</title>
    <link rel="stylesheet" href="styles.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Roboto', sans-serif;
    line-height: 1.6;
    background-color: #f4f4f4;
    color: #333;
}

.container {
    width: 80%;
    max-width: 1200px;
    margin: auto;
    overflow: hidden;
    padding: 0 20px;
}

.header {
    background: linear-gradient(rgba(231, 76, 60, 0.7), rgba(231, 76, 60, 0.7)), url('./blood.jpg') no-repeat center center/cover;
    color: #fff;
    text-align: center;
    padding: 60px 0;
}

.header h1 {
    margin-bottom: 20px;
    font-size: 2.5em;
    font-weight: 700;
}

.header p {
    font-size: 1.2em;
    margin-bottom: 20px;
}

.cta-button {
    background: #c0392b;
    color: #fff;
    padding: 15px 30px;
    border: none;
    cursor: pointer;
    font-size: 1.2em;
    text-decoration: none;
    border-radius: 2px;
}

.cta-button:hover {
    background: #a93226;
}

.hero {
    text-align: center;
    margin: 20px 0;
}

.hero-image {
    width: 100%;
    max-width: 740px;
    height: auto;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    max-height: 400px; 
    object-fit: cover; 
}

.benefits {
    background: #fff;
    padding: 40px 0;
    text-align: center;
}

.benefits h2 {
    margin-bottom: 20px;
    font-size: 2em;
}

.benefit-items {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}

.benefit-item {
    flex: 1 1 45%;
    max-width: 45%;
    margin: 20px;
    padding: 20px;
    background: #e74c3c;
    color: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.benefit-item h3 {
    margin-bottom: 10px;
    font-size: 1.5em;
}

.social-proof {
    background: #f4f4f4;
    padding: 40px 0;
    text-align: center;
}

.social-proof h2 {
    margin-bottom: 20px;
    font-size: 2em;
}

.testimonials {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
}

.testimonial {
    flex: 1 1 45%;
    max-width: 45%;
    margin: 20px;
    padding: 20px;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.form-section {
    background: #fff;
    padding: 40px 0;
    text-align: center;
}

.form-section h2 {
    margin-bottom: 20px;
    font-size: 2em;
}

form {
    display: inline-block;
    text-align: left;
    max-width: 500px;
    width: 100%;
}

form label {
    display: block;
    margin: 10px 0 5px;
    font-weight: 700;
}

form input {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

form button {
    background: #e74c3c;
    color: #fff;
    padding: 15px 30px;
    border: none;
    cursor: pointer;
    font-size: 1.2em;
    border-radius: 5px;
}

form button:hover {
    background: #c0392b;
}

.footer {
    background: #333;
    color: #fff;
    text-align: center;
    margin-top: 20px;
}

.footer a {
    color: #fff;
    text-decoration: none;
    margin: 0 10px;
}

.footer a:hover {
    text-decoration: underline;
}
</style>
</head>
<body>
    <header class="header">
        <div class="container">
            <h1>Donate Blood, Save Lives</h1>
            <p>Your donation can save up to three lives. Join us in making a difference today.</p>
            <a href="#signup" class="cta-button">Donate Now</a>
        </div>
    </header>
    
    <section class="hero">
        <div class="container">
            <img src="https://mmhrc.in/file/wp-content/uploads/2022/03/blood-donation.jpg" alt="Blood donation" class="hero-image">
        </div>
    </section>
    
    <section class="benefits">
        <div class="container">
            <h2>Why Donate Blood?</h2>
            <div class="benefit-items">
                <div class="benefit-item">
                    <h3>Save Lives</h3>
                    <p>Every donation can save up to three lives.</p>
                </div>
                <div class="benefit-item">
                    <h3>Improve Health</h3>
                    <p>Regular blood donation helps in maintaining good health.</p>
                </div>
                <div class="benefit-item">
                    <h3>Free Check-up</h3>
                    <p>Get a free health check-up with every donation.</p>
                </div>
                <div class="benefit-item">
                    <h3>Join Community</h3>
                    <p>Become a part of our community of heroes.</p>
                </div>
            </div>
        </div>
    </section>
    
    <section class="social-proof">
        <div class="container">
            <h2>What Our Donors Are Saying</h2>
            <div class="testimonials">
                <div class="testimonial">
                    <p>"Donating blood is the best way to give back to the community." - Sarah M.</p>
                </div>
                <div class="testimonial">
                    <p>"It's a simple process and you get to save lives." - Michael L.</p>
                </div>
            </div>
        </div>
    </section>
    
    <section class="form-section" id="signup">
        <div class="container">
            <h2>Sign Up to Donate</h2>
            <form action="#" method="POST">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
                <label for="phone">Phone:</label>
                <input type="tel" id="phone" name="phone" required>
                <button type="submit">Sign Up</button><br/>
                <br/>
                <center>
                 <p>Already Have an Account?</p>
                <a href="#">Login Here</a></center>
               
            </form>
        </div>
    </section>
    
    <footer class="footer">
        <div class="container">
            <p>&copy; 2024 Blood Bank. All rights reserved.</p>
            <p><a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a></p>
        </div>
    </footer>
</body>
</html>
