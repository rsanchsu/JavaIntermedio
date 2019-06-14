<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenido a nuestra pagina web</h1>
	<!--  para pasar parametros   ojo no poner mvc/ pq estaria mal-->
     <form action="saludo">
     Nombre: <input type ="text" name="nombre"/>
     <input type="submit" value="Pulsa para saludar"/>
     </form>
</body>
</html>