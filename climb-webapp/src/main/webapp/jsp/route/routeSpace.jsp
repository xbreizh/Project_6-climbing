<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../_include/header.jsp" %>


<h2>Routes</h2><br>
<s:a action="createRoute">
    <button type="button" class="btn btn-info">New Spot</button>
</s:a>


<br><br>

<%@include file="routeTable.jsp" %>

