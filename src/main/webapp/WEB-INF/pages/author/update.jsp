<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp" %>
<html>
<head>
    <title>UpdateAuthor</title>
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
<form id="theForm">
    <br/>
    <b>ID: </b>
    <input readonly type="text" name="id" value="${author.id}" style="width: 55px; height: 25px"/>
    <b>Name: </b>
    <input type="text" name="name" value="${author.name}" style="height: 25px"/>
    <b>Surname: </b>
    <input type="text" name="surname" value="${author.surname}" style="height: 25px"/>
    <br/><br/><br/>
    <input type="button" value="CANCEL" onclick=redirectToMainPage()>
    <input type="button" value="UPDATE" onclick=sendForm(${author.id})>
</form>
</body>
</html>