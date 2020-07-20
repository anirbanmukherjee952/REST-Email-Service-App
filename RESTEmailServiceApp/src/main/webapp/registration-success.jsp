<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Success</title>
	</head>
	<body>
		<h1>Registration successful!</h1>
		<h2>New Email Contact</h2>
		<!-- newEmailContact.getName() is invoked behind-the-scene -->
		Name: ${newEmailContact.name}
		<br><br>
		<!-- newEmailContact.getEmaiLAddress() is invoked behind-the-scene -->
		Email Address: ${newEmailContact.emailAddress}
		<br><br>
		<!-- newEmailContact.getDateOfBirth() is invoked behind-the-scene -->
		Date-of-Birth: ${newEmailContact.dateOfBirth}
		<br><br>
	</body>
</html>