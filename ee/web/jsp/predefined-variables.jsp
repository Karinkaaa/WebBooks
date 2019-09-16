<%--
  Created by IntelliJ IDEA.
  User: karinka
  Date: 09.09.2019
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%--<%@ page session="false" %>--%>
<%--<%@ page buffer="32b" autoFlush="true" %>--%>

<html>
<head>
    <title>PredefinedVariables</title>
</head>
<body>
    <%= "<p>request.getMethod() = " + request.getMethod() + "</p> "%>
<%--    <%= session.getAttribute("one") %>--%>
<%--    <%= response.setStatus(200) %>--%>
    <%= "config.getServletName() = " + config.getServletName() %>
</body>
</html>
