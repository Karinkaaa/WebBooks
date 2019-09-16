<%@ page import="java.util.Date" %>
<%@ page import="jsp.JSPHelper" %>
<%--
  Created by IntelliJ IDEA.
  User: karinka
  Date: 09.09.2019
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyFirstJSP</title>
</head>
<body>
    <%-- comments --%>
    hello world

    <%-- Declarations --%>
    <%! int i = 5; %>
    <%! private void doJob() {
        System.out.println("Method doJob()");
    } %>

    <%-- Expressions --%>
    <%= "<p>Hallo, Deutschland!</p>" %>
    <%= i + 1 + 2 %>
    <%= "<p>" + new Date() + "</p>" %>
    <%= JSPHelper.minus(5, 3) %>

    <%-- Scriplets --%>
    <%
        class Student {
            String name;
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
        }
    %>

    <%
        Student student = new Student();
        student.setName("Bus");
    %>
    <%= "<p>" + student.getName() + "</p>" %>

    <% if (Math.random() > 0.1) { %>
        <b> Math.random > 0,5 </b>
    <% } %>

</body>
</html>
