<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Insert title here</title>

</head>

<body>

    <h1>Welcome to View All Teams</h1>

    <table border="1">

        <tr>

            <th>Team_name</th>

            <th>Wallet</th>

            <th>Status</th>

            <th>Change_Status</th>

            <th>Add_amount</th>

            <th>Team_players</th>

        </tr>

        <c:forEach var="team" items="${teams}">

            <tr>

                <td>${team.name}</td>

                <td>${team.wallet}</td>

                <td>${team.status}</td>

                <td><a href="change_status?id=${team.id}">Change_Status</a></td>

                <td><a href="addamount.jsp?id=${team.id}">Add_amount</a></td>

                <td>Team_players</td>

            </tr>

        </c:forEach>

    </table>
    <h1>${errormsg}</h1>

</body>

</html>
