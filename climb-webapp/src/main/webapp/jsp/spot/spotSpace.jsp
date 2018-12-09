<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../_include/header.jsp" %>


<h2>Spots</h2><br>
<s:a action="createSpot">
    <button type="button" class="btn btn-info">New Spot</button>
</s:a>


<br><br>
<%@include file="spotTable.jsp" %>
<%@include file="../_include/footer.jsp" %>

