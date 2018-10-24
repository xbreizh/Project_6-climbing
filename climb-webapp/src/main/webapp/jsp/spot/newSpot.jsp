<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1>New Spot for <s:property value="%{c.continent}"/></h1>
<br><br>
<s:if test="#session.user">
<%--Continent: <s:property value="%{c.continent}"/>
<s:a action="choseContinent" ><br>
change</s:a><br><br>--%>
<s:form action="createSpot">
    <s:select class="form-control" id="selectCountry" name="country" value="%{country}"
              headerKey="" headerValue="--Select Country--"
              list="countryList"
              onchange="this.form.submit()"
    /><br><br>

    <s:hidden name="continent" value="%{c.continent}"/>

</s:form>
Country: <s:property value="%{c.name}"/>
<s:a action="choseCountry" ><br>
change<s:param name="id" value="%{c.id}"/>  </s:a><br><br>
City: <s:property value="%{city}"/>
<s:a action="choseCity" ><br>
change<s:param name="id" value="%{c.id}"/>  </s:a><br><br>

<s:form action="createSpot" method="POST">
    <s:hidden name="spot.country" value="%{c.id}"/>
    <s:hidden name="continent" value="%{c.continent}"/>
    <s:hidden name="spot.city" value="%{city}"/>
    <s:textfield name="spot.memberSpot.id" value="%{session.user.id}" label="Member:"/>
    <s:textfield name="spot.name" value="Type Spot Name" requiredLabel="true"/>
    <s:textarea name="spot.latitude" label="Latitude" />
    <s:textarea name="spot.longitude" label="Longitude" /><a href="https://www.gps-coordinates.net/" target="_blank">Get coordinates</a>
    <s:textarea name="spot.description" value="Type Spot Description" requiredLabel="true"/>
    <s:submit value="Create"/>
</s:form>

</s:if>
<s:else>
Vous devez vous connecter pour cette action!
<s:a action="login">Connexion</s:a>
</s:else>
