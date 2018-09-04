<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update zone</title>
</head>
<body>

<s:form action="zone_update">
    <%--Id: <s:property value="zone.id"/><br>--%>

    <s:hidden name="zone.id" value="%{id}"/>
    <li>Id: <s:property value="id"/></li>
    <s:textfield name="zone.name" label="Name" requiredLabel="true"/>
    <s:textfield name="zone.country" label="Country" requiredLabel="true"/>
    <s:textfield name="zone.region" label="Region" requiredLabel="true"/>
    <s:textfield name="zone.type" label="Type" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="zone_delete">Delete
    <s:param name="zone.id" value="%{id}"/>
</s:a>

</body>
</html>
