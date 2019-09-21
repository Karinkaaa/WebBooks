<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp" %>
<html>
<head>
    <title>Create book</title>
    <style>
        body {
            background-image: url("https://wallpaper-gallery.net/images/black-blue-abstract-wallpaper/black-blue-abstract-wallpaper-13.jpg");
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

        blockquote {
            margin: 0;
            background: #000000;
            color: #333334;
            padding: 20px 30px;
            position: relative;
            border-left: 35px solid #DFDEDE;
            font-family: 'Lato', sans-serif;
        }

        blockquote:before {
            content: "\201C";
            font-family: serif;
            position: absolute;
            left: -29px;
            top: 5px;
            color: #BCBCBC;
            font-size: 50px;
            text-shadow: 1px 2px 0 white;
        }

        blockquote p {
            margin: 0 0 16px;
            font-size: 20px;
            letter-spacing: .05em;
            line-height: 1.4;
        }

        blockquote cite {
            font-style: normal;
            font-weight: 300;
        }
    </style>
</head>
<body>

<script>
    function sendForm() {
        $("#theForm").ajaxSubmit({
            type: 'post',
            url: "${pageContext.request.contextPath}/api/authors",
            complete: redirectToMainPage
        });
    }

    function redirectToMainPage() {
        location.href = "${pageContext.request.contextPath}/authors";
    }
</script>

<div class="row d-flex justify-content-end">

    <br/>
    <div class="col-5">
        <blockquote>
            <p>Читатель проживает тысячу жизней до того, как умрет.</p>
            <p>Тот, кто никогда не читает, — только одну.</p>
            <footer>— <cite>Джордж Мартин</cite></footer>
        </blockquote>
    </div>

    <div class="col-3"></div>

    <div class="col-4">
        <form id="theForm">
            <br/><br/><br/>

            <div class="row">
                <h1 style="color: #FB6652"><b><em>CREATING AN AUTHOR</em></b></h1>
                <br/><br/><br/><br/><br/>
            </div>

            <div class="row">
                <h2>
                    <pre>Name: </pre>
                </h2>
                <input type="text" name="name" style="height: 35px; width: 350px"/>
                <br/><br/><br/><br/>
            </div>

            <div class="row">
                <h2>
                    <pre>Surname: </pre>
                </h2>
                <input type="text" name="surname" style="height: 35px; width: 350px"/>
                <br/><br/><br/><br/><br/>
            </div>

            <div class="row">
                <div class="col-2"></div>
                <div class="col-8">
                    <input class="btn btn-danger btn-lg btn-space" value="CANCEL" type="button"
                           onclick=redirectToMainPage()>
                    <input class="btn btn-success btn-lg" value="SAVE" type="button" onclick=sendForm()>
                </div>
            </div>
        </form>
    </div>
</div>
</form>
</body>
</html>