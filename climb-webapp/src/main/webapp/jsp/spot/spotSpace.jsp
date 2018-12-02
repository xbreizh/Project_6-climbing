<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>
<h2>Spot</h2>
    <s:a action="createSpot">
        <button type="button" class="btn btn-info">New Spot</button>
    </s:a>


<br><br>
<%@include file="spotTable.jsp" %>
</body>
</html>
