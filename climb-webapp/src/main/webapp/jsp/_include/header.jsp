<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="head.jsp"%>

        <%@include file="navbar.jsp"%>

        <s:if test="session.user.role == 'superadmin'">
            <s:actionerror/>
            <s:actionmessage/>
        </s:if>
<div class="container main-container">
