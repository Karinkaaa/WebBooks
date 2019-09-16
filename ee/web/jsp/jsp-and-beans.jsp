<%@ page import="jsp.Person" %>
<%@ page import="jsp.MyThread" %><%--
  Created by IntelliJ IDEA.
  User: karinka
  Date: 09.09.2019
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-and-Beans</title>
</head>
<body>

    <%-- Using jsp:type --%>

<%--    <jsp:useBean id="person" class="jsp.MyThread" type="java.lang.Runnable"/>--%>
<%--    <% Runnable runnable = new MyThread(); %>--%>


    <%-- Аналогичные записи --%>

<%--    <jsp:useBean id="person" class="jsp.Person" scope="request" />--%>
<%--    <% Person person2 = new Person(); %>--%>

<%--    <jsp:setProperty name="person" property="name" value="Karinka" />--%>
<%--    <% person2.setName("Victor"); %>--%>

<%--    <jsp:getProperty name="person" property="name"/>--%>
<%--    <%= person2.getName() %>--%>


    <%-- Set property using declaration --%>

<%--    <%! int age = 22; %>--%>
<%--    <jsp:setProperty name="person" property="age" value="<%=age%>" />--%>
<%--    <jsp:getProperty name="person" property="age"/>--%>


    <%-- Set property using request.getParameter() --%>

<%--    <jsp:setProperty name="person" property="name" value="<%=request.getParameter("name")%>" />--%>
<%--    <jsp:getProperty name="person" property="name"/>--%>


    <%-- Set all properties --%>

<%--    <jsp:setProperty name="person" property="*" />--%>
<%--    <jsp:getProperty name="person" property="name"/>--%>
<%--    <jsp:getProperty name="person" property="age"/>--%>


    <jsp:useBean id="person" class="jsp.Person" scope="session">
        <jsp:setProperty name="person" property="name" value="Mike"/>
    </jsp:useBean>

    <jsp:getProperty name="person" property="name"/>

</body>
</html>
