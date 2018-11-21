<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>
<h1>Spot: <s:property value="spot.name"/></h1><br><br>
<s:a action="index" >Back to Menu</s:a><br><br>
<s:a action="spot_list" >
Spot List</s:a>

<br><br>
<s:a action="comment_list_spot">
    <s:param name="id" value="id"/>
    Comment(s):
</s:a><br>
<ul>
    <li>Id: <s:property value="id"/></li>
    <li>Continent: <s:property value="spot.country.continent"/></li>
    <li>Country: <s:property value="spot.country.name"/></li>
    <li>City: <s:property value="spot.city"/></li>
    <li>Description: <s:property value="spot.description"/></li>
    <%@include file="map.jsp" %>
    <li>Creator:
        <s:a action="member_detail">
            <s:param name="id" value="spot.memberSpot.id"/>
            <s:property value="spot.memberSpot.login"/>
        </s:a>
    </li>
    <li><s:a action="spot_edit">
        <s:param name="id" value="id"/>
        Edit
    </s:a></li><br>

    <s:if test="spot.routeList.size() > 0">
        <img src="http://vincent.boulas.free.fr/teamgrimptout/topos/ainsavoiehautesavoie/topo_malpas.gif">
        <h2>Routes</h2>
        routeList size: <s:property value="%{routeList.size()}"/><br>
        <s:iterator value="%{routeList}">
            <strong><s:property value="name"/></strong>
            Height: <s:property value="height"/>
            Grade: <s:property value="grade"/>
            Type: <s:property value="type"/>
            Creator:
            <s:a action="member_detail">
                <s:param name="id" value="memberRoute.id"/>
                <s:property value="memberRoute.login"/>
            </s:a>
            <s:a action="comment_list_route">
                <s:param name="id" value="id"/>
                Comment(s):
            </s:a>
            <s:a action="route_edit">
                <s:param name="id" value="id"/>
                Edit
            </s:a>
            <br>
            Description: <br><s:property value="description"/>
            <br>
        </s:iterator>
    </s:if>
    <s:else>
        <h2> No route yet for this Spot </h2>
    </s:else>
    <s:if test="#session.user">
    </s:if>
    <s:a action="createRoute">
        <s:param name="id" value="id"/>
        <button type="button" class="btn btn-warning">New Route</button>
    </s:a>
   <%-- <a href="createRoute.action?"+<s:%{id}>
        <button type="button" class="btn btn-warning">New Route</button>

    </a>--%>

</ul>
</body>
</html>

