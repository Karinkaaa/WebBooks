<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp" %>
<html>
<head>
    <title>ApplicationDemo</title>
    <style>
        body {
            background-image: url("https://img3.goodfon.ru/original/2628x1800/9/75/priroda-peyzazh-osen-doroga-3087.jpg");
            background-size: cover;
        }

        .book-background-im {
            background-image: url("https://ru.tokkoro.com/picsup/3388143-books-flowers-blur.jpg");
            background-size: cover;
        }

        .author-background-im {
            background-image: url("https://miro.medium.com/max/9184/0*zanP0hUuvKe2Shc4");
            background-size: cover;
        }

        .book-border-of-btn {
            border-color: olivedrab;
            width: 200px;
            height: 100px;
            box-shadow: 20px 20px 50px 30px darkgreen;
        }

        .author-border-of-btn {
            border-color: goldenrod;
            width: 200px;
            height: 100px;
            box-shadow: 20px 20px 50px 30px firebrick;
        }

        #left {
            text-align: left;
        }

        blockquote {
            margin: 0;
            background: darkolivegreen;
            color: aliceblue;
            padding: 30px 30px 30px 100px;
            position: relative;
            font-family: 'Lato', sans-serif;
        }

        blockquote:before {
            content: "\201C";
            font-family: serif;
            position: absolute;
            top: 20px;
            left: 16px;
            color: black;
            width: 40px;
            height: 40px;
            border-radius: 50%;
            background: white;
            font-size: 40px;
            font-weight: bold;
            text-align: center;
            line-height: 50px;
        }

        blockquote:after {
            content: "";
            width: 4px;
            background: white;
            position: absolute;
            left: 70px;
            top: 20px;
            bottom: 20px;
        }

        blockquote p {
            margin-top: 0;
            font-size: 20px;
            font-weight: 300;
        }

        blockquote cite {
            font-style: oblique;
            text-transform: uppercase;
        }
    </style>
</head>
<body>

<div class="container" style="width: 100%; height: 100%">

    <br/>
    <div class="row" style="height: 5%">
        <blockquote>
            <p>Литература — это самый приятный способ игнорировать жизнь.</p>
            <footer>— <cite>Фернандо Пессоа</cite></footer>
        </blockquote>
    </div>

    <div class="row align-items-center" style="height: 100%">

        <div class="col-6">
            <button id="left" class="book-background-im book-border-of-btn" style="width: 90%; height: 70%"
                    onclick="location.href='${pageContext.request.contextPath}/books'"></button>
        </div>

        <div class="col-6">
            <button class="author-background-im author-border-of-btn" style="width: 85%; height: 70%"
                    onclick="location.href='${pageContext.request.contextPath}/authors'"></button>
        </div>

    </div>
</div>
</body>
</html>
