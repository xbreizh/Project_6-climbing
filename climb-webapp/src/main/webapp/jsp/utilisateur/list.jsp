
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../_include/head.jsp"%>
</head>
<body>
<h1>Liste Utilisateur</h1>

<s:iterator value="listUtilisateur">
    <ul>
        <li>id: <s:property value="id"/></li>
        <li>nom: <s:property value="nom"/></li>
        <li>prenom: <s:property value="prenom"/></li>
    </ul>
</s:iterator>




</body>
</html>
