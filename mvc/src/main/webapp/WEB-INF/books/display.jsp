<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Selected Book: <c:out value="${selected_book.title}"/></h1>

<a href="/books">Home</a>

<p>Description: <c:out value="${selected_book.description}"/></p>
<p>Language: <c:out value="${selected_book.language}"/></p>
<p>Number of pages: <c:out value="${selected_book.numberOfPages}"/></p>
<a href="/books/${selected_book.id}/edit">Edit Book</a>

<form action="/delete/${selected_book.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>

</body>
</html>