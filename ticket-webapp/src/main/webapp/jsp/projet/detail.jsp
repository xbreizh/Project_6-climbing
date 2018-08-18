<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <%@include file="../_include/head.jsp"%>
</head>
<body>
<h1>Détails du projet</h1>



<ul>
    <li>ID: <s:property value="projet.id"/></li>
    <li>nom: <s:property value="projet.nom"/></li>
    <li>date de création: <s:date name="projet.dateCreation"/></li>
    <li>responsable:
        <s:a action="utilisateur_detail">
            <s:param name="id" value="projet.responsable.id"/>
            <s:property value="projet.responsable.nom"/>
            <s:property value="projet.responsable.prenom"/>
        </s:a>
    </li>
    <li>responsable id: <s:property value="projet.responsable.id"/> </li>

    <li>cloture: <s:property value="projet.cloture"/></li>

</ul>

<s:a action="projet_list">Retour a la liste des projets</s:a>
</body>
</html>
