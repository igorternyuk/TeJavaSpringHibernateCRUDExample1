<%-- 
    Document   : create
    Created on : 17.12.2017, 13:19:26
    Author     : igor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new user</title>
    </head>
    <body>
        <f:form action="create.htm" modelAttribute="user">
            <input type="text" name="username" placeholder="username" required="required" style="font-size: 20px" /><br/><br/>
            <input type="email" name="email" placeholder="E-mail" required="required" style="font-size: 20px" /><br/><br/>
            <input type="password" name="password" placeholder="password" required="required" style="font-size: 20px" /><br/><br/>
            <input type="submit" value="Create" style="font-size: 20px"/>
        </f:form>
    </body>
</html>
