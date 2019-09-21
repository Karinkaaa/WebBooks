<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../common/lib.jsp" %>

<html>
<style>
    @-webkit-keyframes scroll {
        0% {
            -webkit-transform: translate(0, 0);
            transform: translate(0, 0);
        }
        100% {
            -webkit-transform: translate(-100%, 0);
            transform: translate(-100%, 0)
        }
    }

    @keyframes scroll {
        0% {
            transform: translate(0, 0);
        }
        100% {
            transform: translate(-100%, 0)
        }
    }

    .marquee {
        max-width: 100%;
        white-space: nowrap;
        overflow: hidden;
    }

    .marquee * {
        display: inline-block;
        padding-left: 100%;
        -webkit-animation: scroll 21s infinite linear;
        animation: scroll 21s infinite linear;
    }

    .marquee *:hover {
        -webkit-animation-play-state: paused;
        animation-play-state: paused;
    }

    body {
        background-image: url("http://www.topoboi.com/large/201307/5689.jpg");
        background-size: cover;
    }

    blockquote {
        margin: 0;
        background: black;
        color: #5F5F5F;
        padding: 30px 30px 30px 80px;
        position: relative;
        font-family: 'Lato', sans-serif;
    }
    blockquote:before {
        content: "\1F676";
        position: absolute;
        z-index: 2;
        left: 30px;
        top: 15px;
        width: 60px;
        height: 60px;
        border-radius: 50%;
        text-align: center;
        line-height: 80px;
        color: #F2EAD7;
        font-size: 50px;
        background: rgba(188,231,250, .7);
    }
    blockquote:after {
        content: "";
        position: absolute;
        left: 34px;
        top: 19px;
        width: 60px;
        height: 60px;
        border-radius: 50%;
        background: rgba(242,124,176, .7);
    }
    blockquote p {
        font-size: 24px;
        letter-spacing: .05em;
        line-height: 1.4;
        margin: 0 0 16px;
        position: relative;
        z-index: 3;
    }
    blockquote cite {
        font-style: normal;
        font-weight: 300;
    }
</style>

<head>
    <title>Books</title>
</head>

<script>
    function deleteBook(id) {
        $.ajax('${pageContext.request.contextPath}/api/books/' + id, {
            type: 'delete',
            complete: redirectToMainPage
        });
    }

    function redirectToMainPage() {
        location.href = "${pageContext.request.contextPath}/books";
    }
</script>

<div class="col-xs-12 marquee"><h6><em>Библиотека "Бус" г.Днепр ул.Комсомольская, 70</em></h6></div>
<br/>
<div class="row">

    <div class="col-2">
        <div class="col">
            <div class="row justify-content-md-left">
                <input class="btn btn-dark bth-lg" type="button" value="Main Page"
                       onclick="location.href ='${pageContext.request.contextPath}/'">
            </div>
            <br/><br/>
        </div>

        <blockquote>
            <p>Книга – устройство, способное разжечь воображение.</p>
            <footer>— <cite>Алан Беннетт</cite></footer>
        </blockquote>
    </div>

    <div class="col-8">
        <input class="btn btn-primary btn-lg" value="CREATE BOOK" type="submit"
               onclick="location.href='${pageContext.request.contextPath}/books/create'"/><br/><br/>
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr>
                <th scope="col" width="100">ID</th>
                <th scope="col">Name</th>
                <th scope="col" width="180">Detail information</th>
                <th scope="col" width="180">Update</th>
                <th scope="col" width="180">Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <th scope="row"> ${book.id} </th>
                    <td> ${book.name} </td>
                    <td align="center">
                        <button class="btn btn-info"
                                onclick="location.href='${pageContext.request.contextPath}/books/details/${book.id}'">
                            details
                        </button>
                    </td>
                    <td align="center">
                        <button class="btn btn-warning"
                                onclick="location.href='${pageContext.request.contextPath}/books/update/${book.id}'">
                            update
                        </button>
                    </td>
                    <td align="center">
                        <button class="btn btn-danger" onclick="deleteBook(${book.id})">delete</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
