<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1>Chose a country for <s:property value="%{continent}"/></h1>
<br><br>
<s:if test="#session.user">


<s:form action="choseCity">
    <s:select id="selectCountry" name="country" value="%{country}"
              headerKey="" headerValue="--Select Country--"
              list="countryList"
              onchange="this.form.submit()"
               /><br><br>

    <s:hidden name="continent" value="%{c.continent}"/>

</s:form>

</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>