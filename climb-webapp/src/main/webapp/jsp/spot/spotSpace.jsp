<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<a href="createSpot.action">
    <button type="button" class="btn btn-warning">New Spot</button>
</a>
<br><br>
<%@include file="spotTable.jsp" %>
</body>
</html>
