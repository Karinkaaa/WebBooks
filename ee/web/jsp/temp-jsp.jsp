<%--
  Created by IntelliJ IDEA.
  User: karinka
  Date: 09.09.2019
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page isELIgnored="true" %>--%>
<html>
<head>
    <title>TempJSP</title>
</head>
<body>

    ${person.name}
    ${person["age"]}
    ${requestScope.person.name}
    ${sessionScope.person.name}
    
    ${applicationScope.person.age}
    ${list[1]}
    ${map["one"]}
    ${map.two}

    ${ 1 + 2 * 3 / 2}
    ${map.two == 55}
    ${map.two > 1}
    ${map.two != 1 ? "one" : "three"}

    <jsp:setProperty name="person" property="name" value="${'Mr'}.${'Max'}"/>
    ${person.name}

    \${1, 2, 3}

    ${cookie.JSESSIONID}

</body>
</html>
