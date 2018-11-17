<%--
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>


<h2>Creation d'un spot</h2>
<r:property value="#session.user.id"/>
<s:if test="#session.user">
    Country: <s:property value="c.name"/><br>
    <s:form action="spot_new" method="POST">
        <s:hidden name="spot.country" value="%{c.id}"/>
        <s:textfield name="spot.city" requiredLabel="true" value="Type City Name"/>
        <s:textfield name="spot.memberSpot.id" value="%{session.user.id}" label="Member:"/>
        <s:textfield name="spot.name" value="Type Spot Name" requiredLabel="true"/>
        <s:textarea name="spot.latitude" label="Latitude" />
        <s:textarea name="spot.longitude" label="Longitude" /><a href="https://www.gps-coordinates.net/">Get coordinates</a>
        <s:textarea name="spot.description" value="Type Spot Description" requiredLabel="true"/>
        <s:submit value="Create"/>
    </s:form>

</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>
</body>
</html>
--%>
