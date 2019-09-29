<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp" %>

<html>
<head>
    <title>Create book</title>
    <style>
        body {
            background-image: url("https://www.tokkoro.com/picsup/5007583-black-3d-abstract-cube-hd-4k-simple-background.jpg");
            background-size: cover;
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

        blockquote {
            background: linear-gradient(135deg, #F6EEDB 50%, #F4FEF9 50%);
            padding: 50px 30px;
            text-align: center;
            position: relative;
            color: #49152C;
            padding: 30px 50px;
            font-family: 'Lato', sans-serif;
        }

        blockquote p {
            font-size: 22px;
            margin-top: 30px;
        }

        blockquote p:before {
            content: "\201C";
            font-size: 100px;
            color: #EA6844;
            font-family: serif;
            position: absolute;
            top: 0;
            left: 50%;
            transform: translateX(-50%);
        }

        blockquote cite {
            font-style: normal;
        }
    </style>
</head>
<body>

<script>
    function sendForm() {
        $("#theForm").ajaxSubmit({
            type: 'post',
            url: "${pageContext.request.contextPath}/api/books",
            complete: redirectToMainPage
        });
    }

    function redirectToMainPage() {
        location.href = "${pageContext.request.contextPath}/books";
    }
</script>

<div class="row d-flex justify-content-end">

    <div class="col-3">
        <br/><br/><br/>
        <blockquote>
            <p>Нет друга, вернее книги...</p>
            <footer>— <cite>Эрнест Хемингуэй</cite></footer>
        </blockquote>

        <br/><br/><br/><br/><br/>
        <blockquote>
            <p>Читать — это как думать, молиться, говорить с другом, выражать свои мысли, выслушивать идеи других,
                наслаждаться музыкой, видеть прекрасный пейзаж и прогуливаться по пляжу...</p>
            <footer>— <cite>Роберто Боланьо</cite></footer>
        </blockquote>
    </div>

    <div class="col-3"></div>

    <div class="col-5">
        <form id="theForm">
            <br/><br/><br/><br/><br/>

            <div class="row">
                <h2 style="color: navy"><b><em>CREATING A BOOK</em></b></h2>
                <br/><br/><br/><br/>
            </div>

            <div class="row">
                <h2>
                    <pre>Name: </pre>
                </h2>
                <input type="text" name="name" style="height: 35px; width: 350px"/>
                <br/><br/><br/><br/>
            </div>

            <div class="row">
                <input class="btn btn-danger btn-lg btn-space" value="CANCEL" type="button"
                       onclick=redirectToMainPage()>
                <input class="btn btn-success btn-lg" value="SAVE" type="button" onclick=sendForm()>
            </div>
        </form>
    </div>
</div>
</form>
</body>
</html>