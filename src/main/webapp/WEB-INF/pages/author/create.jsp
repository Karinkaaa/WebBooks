<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/lib.jsp"%>
<html>
<head>
    <title>Create book</title>
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
<form id="theForm">
    <br/><b>Name: </b>
    <input type="text" name="name"  style="height: 30px; width: 250px"/>
    <br/><br/><b>Surname: </b>
    <input type="text" name="surname"  style="height: 30px; width: 250px"/><br/><br/><br/>
    <input type="button" value="CANCEL" style="color:tomato; height: 25px; width: 100px" onclick=redirectToMainPage()>
    <input type="button" value="SAVE"  style="color: chartreuse; height: 25px; width: 100px" onclick=sendForm()>
</form>
</body>
</html>