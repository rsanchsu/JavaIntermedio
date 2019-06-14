<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenido ${atributoNombre}</h1>
	<h1>Bienvenido Session ${nombreSession}</h1>
	<h1><%=request.getAttribute("atributoNombre") %></h1>
	<!-- para verlo  y ejecutarlo en el navegador ponemos http://localhost:8080/06_SpringWeb/index.html -->
	
</body>
</html>