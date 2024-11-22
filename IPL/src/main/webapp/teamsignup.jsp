<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="special"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IPL_Auction_TeamSignup</title>
</head>
<body>
	<h1>this is team signup page</h1>

<special:form action="team_signup" method="post"
		modelAttribute="team">

   name : <special:input path="name" type="text" placeholder="enter name.." /><br>
   Username : <special:input path="username" type="text" placeholder="enter username.." /><br>
   password : <special:input path="password" placeholder="enter password.." /><br>
   logo : <special:input path="imagelink" type="text" placeholder="enter imagelink" />
		<br>
		<special:button type="submit">submit</special:button>
		<special:button type="reset">reset</special:button>

	</special:form>
</body>
</html>