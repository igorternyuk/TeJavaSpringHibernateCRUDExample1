<%-- 
    Document   : edit
    Created on : 17.12.2017, 11:57:56
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit user</title>
    </head>
    <body>
        <f:form action="update.htm" modelAttribute="user">
            <input type="hidden" name="id" value="${user.id}"/><br/>
            <input type="text" name="username" value="${user.username}" required="required" style="font-size: 20px" /><br/><br/>
            <input type="email" name="email" value="${user.email}" required="required" style="font-size: 20px" /><br/><br/>
            <input type="password" name="password" value="${user.password}" required="required" style="font-size: 20px" /><br/><br/>
            <input type="submit" value="Save changes"/>
        </f:form>
    </body>
</html>
