<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> veiw team</h1>
 <table border="1">
        <tr>
            <th>Player_name</th>
            <th>Role</th>
            <th>Country</th>
            <th>Base_Price</th>
            
            
        </tr>
        <c:forEach var="player" items="${players}">
            <tr>
                <td>${player.name}</td>
                <td>${player.getRole()}</td>
                <td>${player.getCountry()}</td>
                <td>${player.getPrice()}</td>
                
                
            </tr>
        </c:forEach>
    </table>
</body>
</html>