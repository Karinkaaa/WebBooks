<%@ page import="java.util.Random" %>
<%@ page import="web.entities.Book" %>
<%@ page import="web.entities.Author" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: karinka
  Date: 06.09.2019
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String[] people = new String[] {"Tom", "Bob", "Sam"};
    String header = "Users list";
%>

<html>
<head>
    <title>Test JSP</title>
</head>
<body>

    <%-- JSP Expression --%>

    <p>2 + 2 = <%= 2 + 2 %></p>
    <p>5 > 2 = <%= 5 > 2 %></p>
    <p><%= new String("Karinka").toUpperCase() %></p>
    <p>Today <%= new java.util.Date() %></p>

    <%-- JSP Scriplet --%>

    <h3> <%= header %> </h3>
    <%
        for (String person : people) {
            System.out.println("<li>" + person + "</li>");
        }
    %>

    <%-- JSP Declaration --%>

    <%!
        int square(int n) {
            return n * n;
        }
    %>

    <p><%= square(6) %></p>

    <%-- Comments... --%>

    <%
        List<Author> authors = new ArrayList<>();
        authors.add(new Author(1, "Karinka", "Harina"));
        authors.add(new Author(1, "Victor", "Kostraba"));
        Book book = new Book(1, "Buuus", authors);
    %>

    <%= book %>

</body>
</html>
