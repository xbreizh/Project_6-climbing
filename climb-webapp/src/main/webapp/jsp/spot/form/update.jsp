<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>

<s:form action="spot_update" method="POST">
    <%--Id: <s:property value="spot.id"/><br>--%>

    <%--<s:hidden name="spot.id" value="%{id}"/>--%>
    <s:textfield name="spot.id" label="ID" requiredLabel="true"/>
    <s:textfield name="spot.city" label="Region" requiredLabel="true"/>
    <s:textfield name="spot.name" label="Name" requiredLabel="true"/>
    <s:textfield name="spot.description" label="Description" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="spot_delete">Delete
    <s:param name="spot.id" value="%{id}"/>
</s:a>

</body>
</html>
