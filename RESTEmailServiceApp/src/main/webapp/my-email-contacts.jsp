<%@page import="com.demo.restemailerviceapp.controller.EmailContact"%>
<%@page import="java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Email Contacts</title>
	</head>
	<body>
		<h1>My Email Contacts:</h1>
		<ul>
		<c:forEach var="contact" items="${fetchedEmailContacts}">
			<li>ID:${contact.id} Name:${contact.name} Email-Address:${contact.emailAddress} Date-of-Birth:${contact.dateOfBirth}</li>
		</c:forEach>
		</ul>
	</body>
</html>