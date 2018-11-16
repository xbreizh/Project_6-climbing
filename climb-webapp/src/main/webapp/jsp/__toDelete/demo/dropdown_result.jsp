<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<%@include file="../../_include/header.jsp" %>
<body>

<h1>Test</h1>
Member: <s:property value="member.login"/>
Spot: <s:property value="spot.name"/>
<%--<c:choose>
    <c:when test="${param.portchoice == 'news'}">

        <h1>Welcome to the News Portal!</h1>

    </c:when>
    <c:when test="${param.portchoice == 'weather'}">

        <h1>You Get the Latest Weather!</h1>

    </c:when>
    <c:when test="${param.portchoice == 'entertainment'}">

        <h1>Entertainment News Just for You!</h1>

    </c:when>
    <c:otherwise>

        <h1>Application logic problem detected!</h1>

    </c:otherwise>
</c:choose>--%>

</body>
</html>