<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../_include/header.jsp"%>
<meta charset="UTF-8">



<h2>Création d'un projet</h2>

    <s:form action="projet_new">
        <s:textfield name="projet.nom" label="Nom" requiredLabel="true"/>
        <s:select name="projet.responsable.id" label="Responsable"
                  list="listUtilisateur" listKey="id" listValue="prenom"
                  emptyOption="true"
                  requiredLabel="true"/>
        <s:checkbox name="projet.cloture" label="Cloture"/>
        <s:submit value="OK"/>
    </s:form>
</body>
</html>
