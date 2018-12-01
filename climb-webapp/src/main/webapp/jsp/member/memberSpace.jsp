<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../_include/header.jsp" %>

<s:if test="#session.user.role =='superadmin'">


<br><br>
<%@include file="../member/memberTable.jsp" %>

</s:if>
<s:else>

    <img alt="Access forbidden!" style=" max-width: 50%; height: auto;" src=" https://previews.123rf.com/images/corund/corund1511/corund151100022/48297160-access-denied-sign-clipping-path-included.jpg">

</s:else>
</div>
