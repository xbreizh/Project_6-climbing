
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../_include/head.jsp"%>
</head>
<body>
<h1>Détails Utilisateur</h1>


<ul>
    <li>ID: <s:property value="utilisateur.id"/></li>
    <li>nom: <s:property value="utilisateur.nom"/></li>
    <li>prenom:  <s:property value="utilisateur.prenom"/></li>
</ul>

</body>
</html>
