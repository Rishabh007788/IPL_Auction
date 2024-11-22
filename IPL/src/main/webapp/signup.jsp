<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to signup page</h1>

<form action="signup" method="post">
	<label>Choose Role : </label><br>
	<label for="mng">Management : </label>
	<input type="radio" value="management" id="mng" name="role"><br>
	<label for="team">Team : </label>
	<input type="radio" value="team" id="team" name="role"><br>
	<label for="pl">Player : </label>
	<input type="radio" value="player" id="pl" name="role"><br>
	<input type="submit">
	
</form>
</body>
</html>