<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp" %>
<html>
<head>
    <title>Details</title>
    <style>
        body {
            background-image: url("https://99px.ru/sstorage/53/2012/02/tmb_34210_9178.jpg");
            background-size: cover;
        }

        blockquote {
            margin: 0;
            background: black;
            padding: 40px;
            color: #3F484D;
            position: relative;
            font-family: 'Lato', sans-serif;
            text-align: center;
        }

        blockquote:before, blockquote:after {
            font-size: 45px;
            color: #3CA1D9;
            position: absolute;
            height: 2px;
            left: 40px;
            right: 40px;
            line-height: .5;
            background: linear-gradient(to right, #3CA1D9 45%, transparent 45%, transparent), linear-gradient(to right, transparent, transparent 55%, #3CA1D9 55%);
            font-family: serif;
        }

        blockquote:before {
            content: "\201C";
            top: 30px;
        }

        blockquote:after {
            content: "\201D";
            bottom: 30px;
        }

        blockquote p {
            font-size: 20px;
        }

        blockquote footer {
            margin-bottom: 1em;
        }

        blockquote cite {
            font-style: normal;
        }
    </style>
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
<br/>
<div class="row d-flex justify-content-center">

    <div class="col-2">
        <br/>
        <div class="row justify-content-md-center">
            <input class="btn btn-dark bth-lg" type="button" value="Cancel"
                   onclick="location.href ='${pageContext.request.contextPath}/books'">
        </div>

        <br/><br/>
        <blockquote>
            <p>Если вы читали только книги, которые все читают, вы будет думать только то, что все думают.</p>
            <footer>— <cite>Харуки Мураками</cite></footer>
        </blockquote>
    </div>

    <div class="col-8">
        <input value="ADD AUTHOR" type="submit" style="width:150px;height:60px; background:dodgerblue border-box"
               onclick="location.href='${pageContext.request.contextPath}/authors'"/>
        <br/>
        <br/><b>ID: </b>
        <input readonly type="text" name="id" value="${book.id}"/>
        <b>Name: </b>
        <input readonly type="text" name="name" value="${book.name}"/>
        <br/><br/>

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
                <td> ${author.surname} </td>
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
    </div>

    <div class="col-2"></div>
</div>
</body>
</html>
