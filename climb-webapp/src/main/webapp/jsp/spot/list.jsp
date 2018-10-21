<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1><s:property value="continent"/></h1>
<br><br>

<br><br>
<%--<s:a action="spot_new">Create</s:a><br><br>
<s:a action="index" >Back to Menu</s:a><br><br>
<s:form action="spot_list">
    <s:select id="selectContinent" name="continent" value="%{continent}"
              headerKey="" headerValue="--Select Continent--"
              list="continentList" onchange="this.form.submit()"/><br><br>
    <s:if test="%{!continent.equals('')}">
        <s:select id="selectCountry" name="country" value="%{country}"
                  headerKey="" headerValue="--Select Country--"
                  list="countryList" onchange="this.form.submit()"/><br><br>
    </s:if>
    Continent: <s:property value="%{continent}"/><br>
    Country: <s:property value="%{c.name}"/><br>
    Region: <s:property value="%{region}"/><br>
</s:form>
<s:form action="spot_new">
    <s:textfield name="c" value="%{c.id}" requiredLabel="true"/>
    <s:submit value="Create new Spot"/>
</s:form>--%>
Continent: <s:property value="continent"/><br>
Country: <s:property value="%{country}"/><br>
<s:form action="spot_list">
    <s:select id="selectCountry" name="country" value="%{country}"
              headerKey="" headerValue="--Select Country--"
              list="countryList"
              onchange="this.form.submit()"
    /><br><br>

    <s:hidden name="continent" value="%{continent}" />

</s:form>
<s:if test="%{c!=null}">
    <s:if test="spotList.size()>1">
<s:form action="spot_list">
    <s:select id="selectCity" name="city" value="%{city}"
              headerKey="" headerValue="--Select City--"
              list="cityList"
              onchange="this.form.submit()"
    /><br><br>

    <s:hidden name="continent" value="%{continent}" />
    <s:hidden name="country" value="%{country}" />
 <%--   <s:hidden name="city" value="%{city}" />--%>

</s:form>
    </s:if>
    <s:else>No spot created yet</s:else>
    <s:form action="choseCity">
       <%-- <s:select id="selectCountry" name="country" value="%{country}"
                  headerKey="" headerValue="--Select Country--"
                  list="countryList"
                  onchange="this.form.submit()"
        /><br><br>--%>

        <s:hidden name="continent" value="%{continent}" />
        <s:hidden name="country" value="%{country}" />
        <s:submit value="new Spot"/>

    </s:form>
    <s:form action="createSpotAndCity">
        <s:hidden name="id" value="%{c.id}"/>
        <s:submit value="New City"/>

    </s:form>
</s:if>
<s:iterator value="spotList">
    <ul>
        <%--<li>Continent: <s:property value="country.continent"/></li>--%>
            <s:a action="spot_detail"><s:property value="name"/>
                <s:param name="id" value="id"/>
            </s:a>
        <li>Country: <s:property value="country.name"/></li>
        <li>City: <s:property value="city"/></li>
        <%--<li>Name: <s:property value="name"/></li>--%>
        <li>Description: <s:property value="description"/></li>
        <li>GPS coordinates: <s:property value="latitude"/>,<s:property value="longitude"/></li>
        <li>Creator:
            <s:a action="member_detail">
                <s:param name="id" value="memberSpot.id"/>
                <s:property value="memberSpot.login"/>
            </s:a>
        </li>
    </ul>
</s:iterator>

</body>
</html>
