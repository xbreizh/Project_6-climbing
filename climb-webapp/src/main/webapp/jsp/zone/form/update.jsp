<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>
<br><br>
<s:form action="zone_update" method="POST">

    <s:hidden name="zone.id" value="%{id}"/>
    Continent: <s:property value="zone.continent"/><br>
    Country: <s:property value="zone.country"/><br>
    <s:textfield name="zone.region" label="Region" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="zone_delete">Delete
    <s:param name="zone.id" value="%{id}"/>
</s:a>

</body>
</html>
