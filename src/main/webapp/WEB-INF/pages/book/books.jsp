<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<br/>
<input value="CREATE BOOK" type="submit" style="width:150px;height:60px; background:dodgerblue border-box"
       onclick="location.href='${pageContext.request.contextPath}/books/create'"/>
<br/><br/><br/>
<table border="2" style="border: floralwhite dot-dash medium">
    <tbody>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script>
        function deleteBook (id) {
            $.ajax('${pageContext.request.contextPath}/api/books/' + id, {
                type: 'delete',
                complete: redirectToMainPage
            });
        }
        function redirectToMainPage() {
            location.href = "${pageContext.request.contextPath}/books";
        }
    </script>
    <tr>
        <th width="75" height="50" style="background: brown">ID</th>
        <th width="300" style="background: darkslategrey">Name</th>
        <th width="200" style="background: darkslategrey">Detail information</th>
        <th width="150" style="background: darkslategrey">Update</th>
        <th width="150" style="background: darkslategrey">Delete</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr style="height:35px">
            <td> ${book.id} </td>
            <td> ${book.name} </td>
            <td>
                <a href="${pageContext.request.contextPath}/books/details/${book.id}">details...</a>
            </td>
            <td>
                <button onclick="location.href='${pageContext.request.contextPath}/books/update/${book.id}'">
                    update</button>
            </td>
            <td>
                <button onclick="deleteBook(${book.id})">delete</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
