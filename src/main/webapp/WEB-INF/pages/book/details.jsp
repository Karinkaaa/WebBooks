<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script>
    function deleteAuthor(id) {
        $.ajax('${pageContext.request.contextPath}/api/books/' + id, {
            type: 'delete',
            complete: redirectToMainPage
        });
    }

    function redirectToMainPage() {
        location.href = "${pageContext.request.contextPath}/books";
    }
</script>

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
        <td> ${book.authors.id} </td>
        <td> ${book.authors.name} </td>
        <c:forEach var="author" items="${book.authors}">
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
