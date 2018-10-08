<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>
<h1>Détails Spot</h1><br><br>
<s:a action="index" >Back to Menu</s:a><br><br>
<s:a action="spot_list" >
<s:param name="country" value="spot.country.name"/>
<%--<s:property value="spot.memberSpot.login"/>--%>
Back to List</s:a>


<ul>
    <li>Continent: <s:property value="spot.country.continent"/></li>
    <li>Country: <s:property value="spot.country.name"/></li>
    <li>Id: <s:property value="id"/></li>
    <li>Name: <s:property value="spot.name"/></li>
    <li>Creator:
        <s:a action="member_detail">
            <s:param name="id" value="spot.memberSpot.id"/>
            <s:property value="spot.memberSpot.login"/>
        </s:a>
    </li>
    <li>
        <s:a action="spot_edit">Edit
            <s:param name="id" value="id"/>
        </s:a>
    </li>
    <li>
        <s:a action="spot_delete">Delete
            <s:param name="id" value="id"/>
        </s:a>
    </li>
</ul>


</body>
</html>
