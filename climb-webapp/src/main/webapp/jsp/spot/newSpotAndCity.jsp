<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1>New City and Spot for <s:property value="%{c.continent}"/></h1>
<br><br>
<s:if test="#session.user">
Country: <s:property value="%{c.name}"/>
<s:a action="choseCountry" ><br>
change<s:param name="id" value="%{c.id}"/>  </s:a><br><br>

<s:a action="choseCity" ><br>
Back<s:param name="id" value="%{c.id}"/>
</s:a><br><br>

<s:form class="form-group" action="createSpot" method="POST">
    <s:hidden name="spot.country"  value="%{c.id}"/>
    <s:hidden name="country" value="%{c.name}"/>
    <s:hidden name="continent" value="%{c.continent}"/>
    <s:textfield name="spot.city" requiredLabel="true" value="Type City Name"/>
    <s:textfield name="spot.memberSpot.id" value="%{session.user.id}" label="Member:"/>
    <s:textfield name="spot.name" value="Type Spot Name" requiredLabel="true"/>
    <s:textfield name="spot.latitude" label="Latitude" />
    <s:textfield name="spot.longitude" label="Longitude" /><a href="https://www.gps-coordinates.net/" target="_blank">Get coordinates</a>
    <s:textarea name="spot.description" value="Type Spot Description" requiredLabel="true"/>
    <s:submit class="btn btn-primary" value="Create"/>
</s:form>
</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>