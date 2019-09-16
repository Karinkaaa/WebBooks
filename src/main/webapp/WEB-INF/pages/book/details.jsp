<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp"%>
<html>
<head>
    <title>Details</title>
</head>
<body>
<script>
    function deleteAuthor(id) {
        $.ajax('${pageContext.request.contextPath}/api/authors/' + id, {
            type: 'delete',
            complete: redirectToMainPage
        });
    }

    function redirectToMainPage() {
        location.href = "${pageContext.request.contextPath}/authors";
    }
</script>
<input value="ADD AUTHOR" type="submit" style="width:150px;height:60px; background:dodgerblue border-box"
       onclick="location.href='${pageContext.request.contextPath}/authors/create'"/>
<br/><br/><br/>
<br/><b>ID: </b>
<input readonly type="text" name="id" value="${book.id}"/>
<b>Name: </b>
<input readonly type="text" name="name" value="${book.name}"/>

<table border="2" style="border: floralwhite dot-dash medium">

    <tr>
        <th width="75" height="50" style="background: brown">ID</th>
        <th width="300" style="background: darkslategrey">Name</th>
        <th width="200" style="background: darkslategrey">Surname</th>
        <th width="150" style="background: darkslategrey">Update</th>
        <th width="150" style="background: darkslategrey">Delete</th>
    </tr>
    <tr style="height:35px">
        <c:forEach var="author" items="${book.authors}">
        <td> ${author.id} </td>
        <td> ${author.name} </td>
        <td>
            <a href="${pageContext.request.contextPath}/authors/update/${author.id}">update</a>
        </td>
        <td>
            <button onclick="deleteAuthor(${author.id})">delete</button>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
