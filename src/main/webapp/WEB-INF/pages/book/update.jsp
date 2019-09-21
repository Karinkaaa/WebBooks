<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp" %>
<html>
<head>
    <title>UpdateBook</title>
    <style>
        body {
            background-image: url("https://i.pinimg.com/originals/27/01/e0/2701e0b5ef47acb7aa989bc237e35cc5.jpg");
            background-size: contain;
        }

        .btn-space {
            margin-right: 50px;
        }

        .btn {
            border: 3px solid black;
            padding: 12px 24px;
            color: ghostwhite;
            font-size: 25px;
        }
    </style>
</head>
<body>

<script>
    function sendForm(id) {
        $("#theForm").ajaxSubmit({
            type: 'post',
            url: '${pageContext.request.contextPath}/api/books/' + id,
            complete: redirectToMainPage
        });
    }

    function redirectToMainPage() {
        location.href = "${pageContext.request.contextPath}/books";
    }

    function search() {
        $("#search").ajaxSubmit({
            url: '${pageContext.request.contextPath}/authors/filter',
            complete: function (response) {
                console.log(response)
                $("#table").html(response.responseText);
            }
        });
    }

    function addAuthor() {
        debugger
        var authorId = $("input[name='authorId']:checked").val();
        $.ajax('${pageContext.request.contextPath}/api/books/${book.id}/' + authorId, {
            type: 'post',
            complete: function () {
                location.href = location.href;
            }
        });
    }
</script>

<div class="row justify-content-md-center">

    <div class="col-5">
        <form id="theForm">
            <br/><br/><br/>

            <div class="row">
                <h1 style="color: firebrick"><b>UPDATING A BOOK</b></h1>
                <br/><br/><br/><br/><br/>
            </div>

            <div class="row pb-3">
                <div class="col-4">
                    <h3 class="font-weight-bold">ID:</h3>
                </div>
                <div class="col-8">
                    <h3>${book.id}</h3>
                </div>
                <br/>
            </div>

            <div class="row">
                <div class="col-4">
                    <h3 class="font-weight-bold">Name:</h3>
                </div>
                <div class="col-8">
                    <input type="text" name="name" value="${book.name}"/>
                </div>
            </div>

            <div class="row">
                <input class="btn btn-danger bth-lg btn-space" type="button" value="CANCEL"
                       onclick=redirectToMainPage()>
                <input class="btn btn-success bth-lg" type="button" value="UPDATE" onclick=sendForm(${book.id})>
            </div>
        </form>


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

    <div class="col-5">
        <form id="search">
            <input hidden type="text" name="bookId" value="${book.id}"/>
            <input type="text" name="name" oninput="search()" style="height: 35px; width: 350px"/>
        </form>

        <form id="add-author">
            <div id="table"> <%-- тут динамически ставим таблицу авторов --%> </div>
            <input class="btn btn-info" type="button" value="Add author" onclick=addAuthor()>
        </form>
    </div>
</div>
</body>
</html>