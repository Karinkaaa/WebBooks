<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../common/lib.jsp" %>
<html>
<head>
    <title>Authors</title>
    <style>
        body {
            background-image: url("http://rulib.info/uploads/sred/big/oboik.ru_201106171240027461.jpg");
            background-size: cover;
        }

        .btn-size {
            border: 3px solid black;
            padding: 12px 24px;
            color: ghostwhite;
            font-size: 25px;
        }
    </style>
</head>

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

<body>
<div class="row">

    <div class="col-2">
        <br/>
        <div class="row justify-content-md-center">
            <input class="btn btn-dark bth-lg" type="button" value="Main Page"
                   onclick="location.href ='${pageContext.request.contextPath}/'">
        </div>
    </div>

    <div class="col-8">
        <br/>
        <input class="btn btn-info btn-lg btn-size" value="CREATE AUTHOR" type="submit"
               onclick="location.href='${pageContext.request.contextPath}/authors/create'"/><br/><br/>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col" width="80">ID</th>
                <th scope="col" width="300">Name</th>
                <th scope="col" width="300">Surname</th>
                <th scope="col" width="180">Update</th>
                <th scope="col" width="180">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="author" items="${authors}">
                <th scope="row"> ${author.id} </th>
                <td> ${author.name} </td>
                <td> ${author.surname} </td>
                <td align="center">
                    <button class="btn btn-warning"
                            onclick="location.href='${pageContext.request.contextPath}/authors/update/${author.id}'">
                        update
                    </button>
                </td>
                <td align="center">
                    <button class="btn btn-danger" onclick="deleteAuthor(${author.id})">delete</button>
                </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
