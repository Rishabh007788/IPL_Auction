<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>ViewAllplayers</title>

</head>

<body>

    <h1>Welcome to View All players</h1>

    <table border="1">
        <tr>
            <th>Player_name</th>
            <th>Role</th>
            <th>Country</th>
            <th>Base_Price</th>
            <th>Status</th>
            <th>Buy</th>
        </tr>
        <c:forEach var="player" items="${players}">
            <tr>
                <td>${player.getName()}</td>
                <td>${player.getRole()}</td>
                <td>${player.getCountry()}</td>
                <td>${player.getPrice()}</td>
                <td>${player.getStatus()}</td>
                <td><a href="buy_players?id=${player.getId()}"><button>buy player</button></a></td>
            </tr>
        </c:forEach>
    </table>
    <h1>${errormsg}</h1>

</body>

</html>
