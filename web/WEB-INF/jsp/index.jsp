<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC GRUD example1</title>
    </head>

    <body>
        <table style="border-collapse: collapse" cellpadding="7px" border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>E-mail</th>
                <th>Password</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${lst}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.username}</td>
                    <td>${u.email}</td>
                    <td>${u.password}</td>
                    <td>
                        <a href="edit.htm?id=${u.id}">Edit</a> |
                        <a href="remove.htm?id=${u.id}" onclick="return confirm('Do you really want to delete this item?')">Remove</a>
                    </td>
                </tr>
                
            </c:forEach>
        </table>
        <a href="redirectCreate.htm">Insert new user</a><br>
        <a href="redirectToListing.htm">Reload list</a><br>
        <f:form action="search.htm" method="post">
            <input type="text" name="regEx" style="font-size: 20px"/>
            <input type ="submit" name="btnSearch" value="Search..." style="font-size: 20px"/>
        </f:form>

    </body>
</html>
