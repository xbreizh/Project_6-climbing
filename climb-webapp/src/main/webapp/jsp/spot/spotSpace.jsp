<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<button type="button" class="btn btn-warning"><s:a action="createSpot">New Topo</s:a></button>
<br><br>
<%@include file="../topo/spotTable.jsp" %>
</body>
</html>
