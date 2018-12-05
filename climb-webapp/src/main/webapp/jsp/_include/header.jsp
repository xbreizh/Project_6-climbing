<%@ taglib prefix="r" uri="/struts-tags" %>

<%@include file="head.jsp"%>
<body>
<div class="container">

    <div class="menu1">
    <%@include file="navbar.jsp"%>
    </div>
    <s:if test="session.user.role == 'superadmin'">
        <s:actionerror/>
        <s:actionmessage/>
    </s:if>