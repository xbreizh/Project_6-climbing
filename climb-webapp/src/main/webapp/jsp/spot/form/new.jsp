<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>


<h2>Création d'un spot</h2>

<s:form action="spot_new" method="POST">
    <s:textfield name="spot.name" label="Name" requiredLabel="true"/>
    <s:textfield name="spot.nb_ways" label="NbWays" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>

</body>
</html>
