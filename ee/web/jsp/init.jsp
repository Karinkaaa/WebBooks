<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InitJSP</title>
</head>
<body>

    <%!
        public void jspInit() {
            System.out.println("init in jsp");
        }
        public void jspDestroy() {
            System.out.println("destroy in jsp");
        }
    %>

</body>
</html>
