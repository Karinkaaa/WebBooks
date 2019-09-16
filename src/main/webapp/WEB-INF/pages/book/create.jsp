<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create book</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
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
<form id="theForm">
    <br/><b>Name: </b>
    <input type="text" name="name"  style="height: 30px; width: 250px"/><br/><br/>
    <input type="button" value="CANCEL" style="color:tomato; height: 25px; width: 100px" onclick=redirectToMainPage()>
    <input type="button" value="SAVE"  style="color: chartreuse; height: 25px; width: 100px" onclick=sendForm()>
</form>
</body>
</html>