<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
	</head>
	<body>
		<h1>Welcome to REST Email Service!</h1>
		<hr>
		<h2>Register Your Email Contact</h2>
		<form action="insertEmailContact" method="post">
			Name: <input type="text" name="name" placeholder="Enter name">
			<br><br>
			Email: <input type="email" name="emailAddress" placeholder="Enter email address">
			<br><br>
			Date-of-Birth: <input type="date" name="dateOfBirth">
			<br><br>
			<input type="submit" value="Register Contact">
		</form>
		<hr>
		<h2>Send New Email</h2>
		<form action="sendEmail" method="post">
			Sender's Email Address: <input type="email" name="sender">
			<br><br>
			Receiver's Email Address: <input type="email" name="receiver">
			<br><br>
			Subject: <input type="text" name="subject">
			<br><br>
			Body: <textarea name="body" rows=10 cols=20></textarea>
			<br><br>
			<input type="submit" value="Send Email">
		</form>
	</body>
</html>











