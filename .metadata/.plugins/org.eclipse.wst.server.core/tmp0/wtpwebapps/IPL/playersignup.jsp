<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="special"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>this is player signup page</h1>

<special:form action="player_signup" method="post"
		modelAttribute="player">

   name : <special:input path="name" type="text" placeholder="enter name.." /><br>
   Username : <special:input path="username" type="text" placeholder="enter username.." /><br>
   password : <special:input path="password" type="password" placeholder="enter password.." /><br>
   Role:
   <special:select path="role">
   		<special:option value="">select role</special:option>
   		<special:option value="RightBatsman">RightBatsman</special:option>
   		<special:option value="leftBatsman">leftBatsman</special:option>
   		<special:option value="allrounder">allrounder</special:option>
   		<special:option value="spinBowler">spinBowler</special:option>
   		<special:option value="fastBowler">fastBowler</special:option>
   </special:select><br>
   country : <special:input path="country" type="text" placeholder="enter country name.." /><br>
   base-price : <special:input path="price" type="text" placeholder="enter price.." /><br>
   
		<special:button type="submit">submit</special:button>
		<special:button type="reset">reset</special:button>
		

	</special:form>
</body>
</html>

