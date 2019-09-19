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
    <div class="col-5">
        <form id="theForm">
            <br/><br/><br/><br/><br/>

            <div class="row">
                <h2 style="color: navy"><b><em>CREATING A BOOK</em></b></h2>
                <br/><br/><br/><br/>
            </div>

            <div class="row">
                <h2><pre>Name: </pre></h2>
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