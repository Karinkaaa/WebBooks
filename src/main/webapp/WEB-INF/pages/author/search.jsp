<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table">

    <thead class="thead-dark">
    <tr>
        <th scope="col"></th>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Surname</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td>
                <div class="custom-control custom-radio">
                    <input class="custom-control-input" type="radio" id="radioButton${author.id}" name="authorId" value="${author.id}">
                    <label class="custom-control-label" for="radioButton${author.id}"></label>
                </div>
            </td>
            <td> ${author.id} </td>
            <td> ${author.name} </td>
            <td> ${author.surname} </td>
        </tr>
    </c:forEach>
    </tbody>
</table>