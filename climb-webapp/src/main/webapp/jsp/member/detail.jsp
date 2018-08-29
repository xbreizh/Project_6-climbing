<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../_include/head.jsp"%>
</head>
<body>
<h1>Détails Utilisateur</h1>


<lu>
    <li>Id: <s:property value="id"/></li>
    <li>Login: <s:property value="login"/></li>
    <li>Description: <s:property value="description"/></li>
    <li>
        <s:a action="member_update">
        <s:property value="nom"/>
        <s:param name="id" value="id"/>
        <s:param name="login" value="login"/>
        <s:param name="description" value="description"/>
        Details
    </li>
    </s:a>
</lu>


</body>
</html>
