<%--
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
    <a href="https://www.gps-coordinates.net/" target="_blank">Get coordinates</a>
<s:form class="form-group" action="createSpot" method="POST">
    <s:hidden name="spot.country"  value="%{c.id}"/>
    <s:hidden name="country" value="%{c.name}"/>
    <s:hidden name="continent" value="%{c.continent}"/>
    <s:hidden name="spot.memberSpot.id" value="%{session.user.id}" label="Member:"/>
    <s:select list="%{countryList}" name="spot.country.id" listKey="key" headerKey="-1" headerValue="Select Country" />
    <s:textfield name="spot.city" requiredLabel="true" placeholder="Type City Name"/>
    <s:textfield name="spot.name" hidden="Type Spot Name" requiredLabel="true"/>
    <s:select list="climbingList" name="spot.type" label="Type" requiredLabel="true" headerKey="-1" headerValue="Select Climbing Type"/>
    <s:textfield name="spot.latitude" placeholder="Latitude" />
    <s:textfield name="spot.longitude" placeholder="Longitude" />
    <s:textarea name="spot.description" placeholder="Type Spot Description" requiredLabel="true"/>
    <s:submit class="btn btn-primary" value="Create"/>
</s:form>
</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>--%>
