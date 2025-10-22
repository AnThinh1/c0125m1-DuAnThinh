<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Selected Condiments</title>
</head>
<body>
<h2>Your selected condiments:</h2>

<c:choose>
    <c:when test="${selectedCondiments != null}">
        <ul>
            <c:forEach var="item" items="${selectedCondiments}">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </c:when>
    <c:otherwise>
        <p>No condiment selected!</p>
    </c:otherwise>
</c:choose>

<a href="sandwich">Back</a>
</body>
</html>
