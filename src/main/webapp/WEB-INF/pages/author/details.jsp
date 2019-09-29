<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp" %>
<html>
<head>
    <title>AllBooksOfAuthor</title>
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
            <input class="btn btn-secondary bth-lg" type="button" value="Cancel"
                   onclick="location.href ='${pageContext.request.contextPath}/books'">
        </div>
    </div>

    <div class="col-8">

        <br/><br/>

        <form id="theForm">
            <div class="row">
                <div class="col">
                    <h1 class="text-primary"><b>INFO ABOUT A BOOK</b></h1>
                    <br/><br/>
                </div>
            </div>

            <div class="row pb-3">
                <div class="col-2">
                    <h3 class="font-weight-bold">ID:</h3>
                </div>
                <div class="col-8">
                    <h3>${author.id}</h3>
                </div>
                <br/>
            </div>

            <div class="row">
                <div class="col-2">
                    <h3 class="font-weight-bold">Name:</h3>
                </div>
                <div class="col-8">
                    <input type="text" name="name" value="${author.name}"/>
                </div>
            </div>

            <br/><br/>

            <div class="row">
                <div class="col-9">
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col" width="100">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Surname</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="author" items="${book.authors}">
                            <tr>
                                <th scope="row"> ${author.id} </th>
                                <td> ${author.name} </td>
                                <td> ${author.surname} </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </form>
    </div>

    <div class="col-2">
        <br/><br/>
        <blockquote>
            <p>Если вы читали только книги, которые все читают, вы будет думать только то, что все
                думают.</p>
            <footer>— <cite>Харуки Мураками</cite></footer>
        </blockquote>
    </div>
</div>
</div>
</body>
</html>
