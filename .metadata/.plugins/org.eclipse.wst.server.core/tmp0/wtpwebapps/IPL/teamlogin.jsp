<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
<h1>team login page</h1>
<h1>${msg}</h1>

<form action="team_ligin" method="post">
username: <input type="text" placeholder="enter user name.." name="username"><br> <br>
password: <input type="text" placeholder="enter user password.." name="password"><br> <br>
<input type="submit"> <input type="reset">
</form>
</body>
</html>