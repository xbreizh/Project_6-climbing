<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<a href="member_new.action">
    <button type="button" class="btn btn-warning">New Member</button>
</a>
<br><br>
<%@include file="../member/memberTable.jsp" %>
</body>
</html>
