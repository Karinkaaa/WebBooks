<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP-and-Beans</title>
</head>
<body>

<%--    <jsp:useBean id="person" class="JSP.Person" scope="session"/>--%>
<%--    <jsp:setProperty name="person" property="name" value="Karina"/>--%>
<%--    <jsp:getProperty name="person" property="name"/>--%>


<%--    &lt;%&ndash; аналогично: Runnable thread = new MyThread() &ndash;%&gt;--%>
<%--    <jsp:useBean id="thread" class="JSP.MyThread" type="java.lang.Runnable"/>--%>


<%--    <%! String name = "Victor"; %>--%>
<%--    <jsp:setProperty name="person" property="name" value="<%=name%>"/>--%>
<%--    <jsp:getProperty name="person" property="name"/>--%>

<%--    <jsp:setProperty name="person" property="name" value='<%=request.getParameter("name")%>'/>--%>

<%--    <jsp:setProperty name="person" property="*"/>--%>
<%--    <jsp:getProperty name="person" property="name"/>--%>
<%--    <jsp:getProperty name="person" property="age"/>--%>


    <jsp:useBean id="person" class="JSP.Person" scope="session">
        <jsp:setProperty name="person" property="name" value="Karina"/>
    </jsp:useBean>

    <jsp:getProperty name="person" property="name"/>

</body>
</html>
