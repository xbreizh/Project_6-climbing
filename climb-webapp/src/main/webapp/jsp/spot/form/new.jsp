<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>


<h2>Création d'un spot</h2>
<s:form action="spot_new" method="POST">
    <s:select id="selectContinent" name="spot.country.continent"
              headerKey="-1" headerValue="--Select Continent--"
              list="continentList"
              onchange="this.form.submit()"/>
    <s:if test="%{!spot.country.continent.equals('') && !spot.country.continent.equals('-1')}">
        <s:select id="selectCountry" name="spot.country.name"
                  headerKey="-1" headerValue="--Select Country--"
                  list="countryList"
                  onchange="this.form.submit()"/>
    </s:if>
    <s:property value="%{country}"/><br>
    <s:if test="%{!spot.country.name.equals('') && !spot.country.name.equals('-1')&& !spot.country.continent.equals('-1')}">
        <s:select id="selectRegion" name="spot.region"
                  list="regionList"
                  onchange="this.form.submit()"/><br>
        <%--<s:textfield name="spot.zone.region" value="Create Region" requiredLabel="true" />--%>
        <s:textfield name="spot.name" label="Name" requiredLabel="true"/><%--
        <s:textfield name="spot.nb_ways" label="NbWays" requiredLabel="true"/>--%>
        <s:submit value="OK"/>
        <%-- <s:textfield name="zone.region" value="Spot Name" requiredLabel="true" />
         <s:textfield name="zone.region" value="Nuber of ways" requiredLabel="true" />--%>
    </s:if>
    <%-- Continent: <s:property value="%{zone.continent}"/><br>
     Country: <s:property value="%{zone.country}"/><br>
     Continent: <s:property value="%{continent}"/><br>
     Country: <s:property value="%{country}"/><br>
     Region: <s:property value="%{zone.region}"/><br>--%>
    Continent: <s:property value="%{spot.country.continent}"/><br>
    Country: <s:property value="%{spot.country.name}"/><br>
    Zone: <s:property value="%{spot.region}"/><br>
    Spot: <s:property value="%{spot.name}"/>
    <%-- <s:textfield name="zone.country" label="Country" requiredLabel="true"/>--%>

    <%--<s:submit value="Create"/>--%>
</s:form>
<%--<s:form action="spot_new" method="POST">
    <s:textfield name="spot.name" label="Name" requiredLabel="true"/>
    <s:textfield name="spot.nb_ways" label="NbWays" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>--%>

</body>
</html>
