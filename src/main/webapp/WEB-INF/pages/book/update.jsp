<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script>
    function sendForm(id) {
        $("#theForm").ajaxSubmit({
            type: 'post',
            url: '${pageContext.request.contextPath}/api/books/' + id,
            complete: redirectToMainPage
        });
    }

    function redirectToMainPage() {
        location.href = "${pageContext.request.contextPath}/books";
    }
</script>
<form id="theForm">
    <br/>
    <b>ID: </b>
    <input readonly type="text" name="id" value="${book.id}" style="width: 55px; height: 25px"/>
    <b>Name: </b>
    <input type="text" name="name" value="${book.name}" style="height: 25px"/>
    <br/><br/><br/>
    <input type="button" value="CANCEL" onclick=redirectToMainPage()>
    <input type="button" value="UPDATE" onclick=sendForm(${book.id})>
</form>
</body>
</html>