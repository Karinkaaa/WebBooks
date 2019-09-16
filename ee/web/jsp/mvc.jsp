<%@ page import="jsp.Person" %><%--
  Created by IntelliJ IDEA.
  User: karinka
  Date: 09.09.2019
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MVC</title>
</head>
<body>

    <jsp:useBean id="person" class="jsp.Person" scope="request"/>
<%--    <jsp:useBean id="person" class="jsp.Person" scope="session"/>--%>
<%--    <jsp:useBean id="person" class="jsp.Person" scope="application"/>--%>

    <jsp:getProperty name="person" property="name"/>
    <jsp:getProperty name="person" property="age"/>

</body>
</html>
