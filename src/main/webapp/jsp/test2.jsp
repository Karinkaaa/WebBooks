<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ page buffer="32b" %>

<%--<%@ include file="my-jsp.jsp"%>   на этапе компиляции (не желательно использовать) --%>

<html>
<body>
    <jsp:include page="my-jsp.jsp"/>    <%-- на этапе реквеста --%>
    <jsp:include page="/WEB-INF/test.jsp"/>   <%-- файлы из этой папки не видны браузеру --%>
</body>
<head>
    <title>Test_JSP</title>
</head>
</html>
