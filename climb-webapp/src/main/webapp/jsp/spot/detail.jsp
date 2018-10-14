<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>
<h1>Spot: <s:property value="spot.name"/></h1><br><br>
<s:a action="index" >Back to Menu</s:a><br><br>
<s:a action="spot_list" ><%--
<s:param name="country" value="spot.country.name"/>
&lt;%&ndash;<s:property value="spot.memberSpot.login"/>&ndash;%&gt;--%>
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
    <li>RouteList size: <s:property value="spot.routeList.size()"/></li>
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
    <s:a action="createRoute">
        <s:param name="id" value="id"/>
        Add Route:
    </s:a>
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
           <%-- <s:if test="commentList.size() ==0">--%>
            <s:a action="comment_list_route">
                <s:param name="id" value="id"/>
                Comment(s):
            </s:a>
            <%--</s:if>--%>
            <br>
            Description: <br><s:property value="description"/>
            <br>
        </s:iterator>
    </s:if>
    <s:else>
        <h2> No route yet for this Spot </h2>
    </s:else>
    <%--<s:form action="createComment" method="POST">
        <s:textarea type="text"  label="Comment" requiredLabel="true"/>
        <s:textfield name="comment.memberComment.id" label="Member" value="%{session.user.id}" requiredLabel="true" />
        <s:textfield name="route.id" value="%{route.id}" label="Route" requiredLabel="true" />
        <s:submit value="OK"/>
    </s:form>--%>
    <s:if test="#session.user">
    </s:if>


    <%--<li>
        <s:form action="createRoute" method="POST">
            <s:textfield name="id" value="%{spot.id}" label="Description" requiredLabel="true" />
            <s:submit value="Add Route"/>
        </s:form>
    </li>--%>
</ul>
</body>
</html>

