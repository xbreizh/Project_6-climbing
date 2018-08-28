
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../_include/head.jsp"%>
</head>
<body>
<h1>Liste Membres</h1>

<s:iterator value="listMember">
    <ul>
        <li>Id: <s:property value="id"/></li>
        <li>Login: <s:property value="login"/></li>
        <li>Description: <s:property value="description"/></li>
    </ul>
</s:iterator>




</body>
</html>
