<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<%@include file="../../_include/head.jsp" %>

<body>

<s:form action="spot_update">
    <%--Id: <s:property value="spot.id"/><br>--%>

    <s:hidden name="spot.id" value="%{id}"/>
    <li>Id: <s:property value="id"/></li>
    <s:textfield name="spot.name" label="Name" requiredLabel="true"/>
    <s:textfield name="spot.nb_ways" label="Number of Ways" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="spot_delete">Delete
    <s:param name="spot.id" value="%{id}"/>
</s:a>

</body>
</html>
