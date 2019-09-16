<%--
  Created by IntelliJ IDEA.
  User: karinka
  Date: 09.09.2019
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IncludeOtherJSP</title>
</head>
<body>
    <%-- Препроцессорная команда --%>
<%--    <%@ include file="temp.jsp"%>--%>
<%--    <%= i %>--%>

    <%-- Выполняется на этапе реквеста --%>
    <jsp:include page="temp.jsp" />
    <jsp:include page="/hello" />
    <jsp:include page="/WEB-INF/secure-inf.jsp" />

</body>
</html>
