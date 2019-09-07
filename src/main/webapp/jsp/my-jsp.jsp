<%@ page import="java.util.Date" %>
<%@ page import="JSP.JSPHelper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyFirstJSP</title>
</head>
<body>
    Hello, Hueviy Dnepr!

    <%-- DECLARATION --%>

    <%! int i = 5; %>

    <%! private void doJob() {
            System.out.println("Do job...");
    }; %>


    <%-- EXPRESSION (returned String) --%>

    <%= "Hello, Bus!" %>

    <%= i + 1 + 2 %>    <%-- 8 --%>

    <%= new Date() %>   <%-- Fri Sep 06 15:01:16 EEST 2019 --%>

    <%= JSPHelper.minus(5, 3) %>     <%-- 2 --%>


    <%-- SCREPLETS --%>

    <%-- на классы накладываются ограничения, как на внутренний класс --%>
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
        student.setName("Victor");
        student.getName();
    %>

    <% if (Math.random() > 0.5) { %>
        <b>math random</b>
    <% } %>

</body>
</html>
