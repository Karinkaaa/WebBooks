<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp" %>
<html>
<head>
    <title>UpdateBook</title>
    <style>
        body {
            background-image: url("http://getwallpapers.com/wallpaper/full/0/c/4/1391983-top-dark-background-images-3840x2160-htc.jpg");
            background-size: cover;
        }

        .btn-space {
            margin-right: 50px;
        }

        .btn {
            border: 3px solid black;
            padding: 8px 20px;
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
    <div class="col-7">
        <br/><br/>

        <form id="theForm">
            <div class="row">
                <div class="col">
                    <h1 class="text-primary"><b>UPDATING A BOOK</b></h1>
                    <br/><br/>
                </div>
            </div>

            <div class="row pb-3">
                <div class="col-2">
                    <h3 class="font-weight-bold">ID:</h3>
                </div>
                <div class="col-8">
                    <h3>${book.id}</h3>
                </div>
                <br/>
            </div>

            <div class="row">
                <div class="col-2">
                    <h3 class="font-weight-bold">Name:</h3>
                </div>
                <div class="col-8">
                    <input type="text" name="name" value="${book.name}"/>
                </div>
            </div>

            <br/><br/>

            <div class="row">
                <div class="col-2">
                    <input class="btn btn-danger bth-lg btn-space" type="button" value="CANCEL"
                           onclick=redirectToMainPage()>
                </div>
                <div class="col-2">
                    <input class="btn btn-success bth-lg" type="button" value="UPDATE" onclick=sendForm(${book.id})>
                </div>
            </div>
        </form>

        <br/><br/>

        <div class="row">
            <div class="col">
                <h3 class="text-info"><b>Authors:</b></h3>
                <br/><br/>
            </div>
        </div>

        <div class="row">
            <div class="col-10">
                <table class="table">
                    <thead>
                    <tr class="table-info">
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Surname</th>
                        <th scope="col">Update</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>

                    <tr>
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
        </div>
    </div>

    <div class="col-4">
        <br/><br/><br/>

        <form id="search">
            <div class="row">
                <div class="col">
                    <input hidden type="text" name="bookId" value="${book.id}"/>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <h3 class="font-weight-bold">Enter the name of author:</h3>
                </div>
            </div>

            <div class="row">
                <div class="col">
                    <input type="text" name="name" oninput="search()" style="height: 45px; width: 500px"/>
                </div>
            </div>
        </form>

        <br/><br/>

        <form id="add-author">
            <div id="table"> <%-- тут динамически ставим таблицу авторов --%> </div>
            <input class="btn btn-info" type="button" value="Add author" onclick=addAuthor()>
        </form>
    </div>
</div>
</body>
</html>