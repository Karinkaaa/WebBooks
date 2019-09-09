<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- аналогично req.setAttribute("Student", person); --%>
    <jsp:useBean id="person" class="JSP.Person" scope="request" />

    <%-- аналогично req.getSession().setAttribute("Student", person); --%>
    <jsp:useBean id="person" class="JSP.Person" scope="session" />


    <jsp:useBean id="person" class="JSP.Person" scope="request" />


</body>
</html>
