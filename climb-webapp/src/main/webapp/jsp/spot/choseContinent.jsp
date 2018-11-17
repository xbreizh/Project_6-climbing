<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1>Chose a continent</h1>
<br><br>
<s:if test="#session.user">

<s:a action="index" >Back to Menu</s:a><br><br>
<s:form action="choseCountry">
    <s:select id="selectContinent" name="continent" value="%{continent}"
              headerKey="" headerValue="--Select Continent--"
              list="continentList" onchange="this.form.submit()"/><br><br>


</s:form>


</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>