<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>

<h1><s:property value="%{spot.name}"/>- EDIT(Spot)</h1>
<s:if test="#session.user">
<s:form action="spot_update" method="POST">
    <s:hidden name="spot.id" value="%{spot.id}"/>
    <s:textfield name="spot.city" label="City" value="%{spot.city}" requiredLabel="true"/>
    <s:textfield name="spot.memberSpot.id" value="%{spot.memberSpot.id}" label="Member:"/>
    <s:textfield name="spot.name" label="Name" value="%{spot.name}" requiredLabel="true"/>
    <s:textarea name="spot.latitude" label="Latitude" />
    <s:textarea name="spot.longitude" label="Longitude" value="%{spot.longitude}" /><a href="https://www.gps-coordinates.net/">Get coordinates</a>
    <s:textarea name="spot.description" label="Description" value="%{spot.description}" requiredLabel="true"/>
    <s:submit value="Update"/>
</s:form>
<br>
    <s:form action="spot_delete" method="POST">
    <s:hidden name="id" />
        <s:submit value="Delete"/>
    </s:form>
</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>
</body>
</html>
