<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../_include/header.jsp" %>

<s:if test="#session.user">
<a href="member_new.action">
    <button type="button" class="btn btn-warning">New Member</button>
</a>
<br><br>
<%@include file="../member/memberTable.jsp" %>

</s:if>
<s:else>
You must connect to access the page<br><br>
    <%@include file="../_include/connectButton.jsp" %>
</s:else>
