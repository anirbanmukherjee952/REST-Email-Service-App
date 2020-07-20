<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Success</title>
	</head>
	<body>
		<h1>Email Sent Successfully</h1>
		<h2>Email Details:</h2>
		<!-- sentEmail.getSender() is invoked behind-the-scene -->
		Sender: ${sentEmail.sender}
		<br><br>
		<!-- sentEmail.getReceiver() is invoked behind-the-scene -->
		Receiver: ${sentEmail.receiver}
		<br><br>
		<!-- sentEmail.getSubject() is invoked behind-the-scene -->
		Subject: ${sentEmail.subject}
		<br><br>
		<!-- sentEmail.getBody() is invoked behind-the-scene -->
		Body: ${sentEmail.body}
		<br><br>
	</body>
</html>