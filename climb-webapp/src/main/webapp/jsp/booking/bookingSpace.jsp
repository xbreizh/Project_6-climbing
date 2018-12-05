<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../_include/header.jsp" %>

<s:if test="#session.user.role == 'superadmin'">


<%@include file="bookingTable.jsp" %>

</s:if>
<s:else>
    <%@include file="../member/forbidden.jsp" %>
</s:else>