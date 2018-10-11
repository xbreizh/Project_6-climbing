<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>
<h1>Liste Routes</h1>

<li>Test: <s:property value="routeList.size()"/></li>
<s:a action="index" >Back to Menu</s:a>
<s:iterator value="routeList">
    <ul>
        <li>Spot: <s:property value="spot.Name"/></li>
        <li>Id: <s:property value="id"/></li>
        <li>Name: <s:property value="name"/></li>
        <li>Height: <s:property value="height"/></li>
        <li>Grade: <s:property value="grade"/></li>
        <li>Type: <s:property value="type"/></li>
        <li>Created by: <s:property value="member.login"/></li>
        <li>
            <s:a action="route_detail">Details
                <s:param name="id" value="id"/>
            </s:a>
        </li>
        <li>
            <s:a action="route_delete">Delete
                <s:param name="id" value="id"/>
            </s:a>
        </li>
    </ul>
</s:iterator>


</body>
</html>
