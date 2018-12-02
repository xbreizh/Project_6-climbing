<%@ taglib prefix="r" uri="/struts-tags" %>

<%@include file="head.jsp"%>
<body>
<div class="container">


    <%@include file="navbar.jsp"%>

    <s:if test="session.user.role == 'superadmin'">
        <s:actionerror/>
        <s:actionmessage/>
    </s:if>