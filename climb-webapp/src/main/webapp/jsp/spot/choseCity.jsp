<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1>Chose a City for <s:property value="%{c.name}"/>(<s:property value="%{c.continent}"/>)</h1>
<br><br>
<s:if test="#session.user">

<%--Continent: <s:property value="%{c.continent}"/><br><br>--%>
<%--<s:a action="choseContinent" ><br>
    change</s:a><br><br>--%>
Country: <s:property value="%{c.name}"/>
<s:a action="choseCountry" ><br>
    change<s:param name="id" value="%{c.id}"/>  </s:a><br><br>

<s:if test="cityList.size()>0">
    <s:form action="createSpot">
        <s:select id="selectCity" name="city" value="%{city}"
                  headerKey="" headerValue="--Select City--"
                  list="cityList"
                  onchange="this.form.submit()" /><br><br>
        <s:hidden name="id" value="%{c.id}"/>

    </s:form>
</s:if>
<s:form action="createSpotAndCity">
    <s:hidden name="id" value="%{c.id}"/>
    <s:submit value="New City"/>

</s:form>

</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>