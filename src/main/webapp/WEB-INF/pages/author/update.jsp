<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp" %>
<html>
<head>
    <title>UpdateAuthor</title>
    <style>
        body {
            background-image: url("https://i.pinimg.com/originals/77/60/06/77600644a4475d4a8beb5ea9c195a31c.png");
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
            margin: 0;
            background: #07021d;
            color: lightcoral;
            padding: 30px;
            position: relative;
            text-align: center;
            text-transform: uppercase;
            font-family: 'Lato', sans-serif;
        }
        blockquote:before {
            content: "\f10d";
            font-family: FontAwesome;
            position: absolute;
            z-index: 2;
            left: 50%;
            transform: translateX(-50%);
            top: 14px;
            color: yellowgreen;
            font-size: 20px;
            background: #FFF4E0;
            padding: 0 15px;
        }
        blockquote:after {
            content: "";
            position: absolute;
            left: 15px;
            top: 20px;
            right: 15px;
            height: 4px;
            border-top: 1px dotted #474C4F;
            border-bottom: 1px dotted #474C4F;
        }
        blockquote p {
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
    function sendForm(id) {
        $("#theForm").ajaxSubmit({
            type: 'post',
            url: '${pageContext.request.contextPath}/api/authors/' + id,
            complete: redirectToMainPage
        });
    }

    function redirectToMainPage() {
        location.href = "${pageContext.request.contextPath}/authors";
    }
</script>

<div class="row justify-content-md-center">
    <div class="col-6">
        <form id="theForm">
            <br/><br/><br/>

            <div class="row">
                <h1 style="color: firebrick"><b>UPDATING AN AUTHOR</b></h1>
                <br/><br/><br/><br/><br/>
            </div>

            <div class="row">
                <h3><b>
                    <pre>ID: </pre>
                </b></h3>
                <input readonly type="text" name="id" value="${author.id}" style="width: 75px; height: 40px"/>
                <br/><br/>
            </div>

            <div class="row">
                <h3><b>
                    <pre>Name: </pre>
                </b></h3>
                <input type="text" name="name" value="${author.name}" style="width: 300px; height: 40px"/>
                <br/><br/><br/><br/>
            </div>

            <div class="row">
                <h3><b>
                    <pre>Surname: </pre>
                </b></h3>
                <input type="text" name="surname" value="${author.surname}" style="width: 300px; height: 40px"/>
                <br/><br/><br/><br/>
            </div>

            <div class="row">
                <input class="btn btn-danger bth-lg btn-space" type="button" value="CANCEL"
                       onclick=redirectToMainPage()>
                <input class="btn btn-success bth-lg" type="button" value="UPDATE" onclick=sendForm(${author.id})>
            </div>
        </form>
    </div>

    <div class="col-4">
        <br/><br/><br/><br/>
        <blockquote>
            <p><br/>Как только вы научитесь читать, вы будете всегда свободны.</p>
            <footer>— <cite> Фредерик Дуглас</cite></footer>
        </blockquote>
    </div>
</div>
</body>
</html>