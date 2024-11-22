<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- ctrl+shift+/ -->
<%@ taglib prefix="special" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>this is management signup page</h1>

<special:form action="management_signup" method="post" modelAttribute="management">

name : <special:input path="name" type="text" placeholder="enter name.."/>
password : <special:input path="password"  placeholder="enter password.."/>
<special:input path="" type="submit"/><br>
<special:button type="submit">submit</special:button><br>
<special:input path="" type="reset"/><br>
<special:button type="reset">reset</special:button>

</special:form>
</body>
</html>