<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>

<s:form action="zone_update" method="POST">
    <%--Id: <s:property value="zone.id"/><br>--%>

    <s:hidden name="zone.id" value="%{id}"/>
    <li>Id: <s:property value="id"/></li>
    <s:textfield name="zone.continent" label="Continent" requiredLabel="true"/>
    <s:textfield name="zone.country" label="Country" requiredLabel="true"/>
    <s:textfield name="zone.region" label="Region" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="zone_delete">Delete
    <s:param name="zone.id" value="%{id}"/>
</s:a>

</body>
</html>
