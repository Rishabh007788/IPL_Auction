<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>managementlogin</title>
	
</head>
<body>
<h1>${msg}</h1>

<form action="management_login" method="post">
username: <input type="text" name="name" placeholder="enter your name...">
password: <input type="text" name="password" placeholder="enter your password...">
<input type="submit"> <input type="reset">
</form>
</body>
</html>