<%-- 
    Document   : index
    Created on : Nov 30, 2019, 2:59:21 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome to our application!</h1>
        <p>
            <a href="${pageContext.request.contextPath}/chat">Chat</a>
        </p>
        <p>
            <a href="products">Show Products</a>
        </p>
    </body>
</html>
