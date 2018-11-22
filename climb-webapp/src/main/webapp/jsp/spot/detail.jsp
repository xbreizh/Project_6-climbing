<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>
<h1>

<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th>Continent </th>
        <th>Country </th>
        <th>City </th>
        <th>Description</th>
        <th>Creator</th>
        <th>Comment(s)</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
            <s:property value="spot.country.continent" escapeHtml="false"/>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
        <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
            <s:property value="spot.country.name" escapeHtml="false"/>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
        <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
            <s:property value="spot.city" escapeHtml="false"/>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
        <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
            <s:property value="spot.description" escapeHtml="false"/>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
        <td><s:a action="member_detail" style="display:block;text-decoration:none;" >
            <s:property value="spot.memberSpot.login" escapeHtml="false"/>
            <s:param name="id" value="spot.memberSpotid"/>
        </s:a>
        </td>
        <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
            <s:a action="comment_list_route">
                <s:param name="id" value="id"/>
                Comment(s):
            </s:a>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
    </tr>
    </tbody>
</table>
    <br><br>
    <a href="#comments" class="btn btn-info" role="button">Comments</a>

    <br><br>

    <s:if test="spot.routeList.size() > 0">
        <img src="http://vincent.boulas.free.fr/teamgrimptout/topos/ainsavoiehautesavoie/topo_malpas.gif">
        <h2>Routes</h2>

        <s:iterator value="%{routeList}">
<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th>Name </th>
        <th>Height </th>
        <th>Grade</th>
        <th>Type</th>
        <th>Description</th>
        <th>Creator</th>
        <th>Comment(s)</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
            <s:property value="name" escapeHtml="false"/>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
        <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
            <s:property value="height" escapeHtml="false"/>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
        <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
            <s:property value="grade" escapeHtml="false"/>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
        <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
            <s:property value="type" escapeHtml="false"/>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
        <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
            <s:property value="description" escapeHtml="false"/>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
        <td><s:a action="member_detail" style="display:block;text-decoration:none;" >
            <s:property value="memberRoute.login" escapeHtml="false"/>
            <s:param name="id" value="memberRoute.id"/>
        </s:a>
        </td>
        <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
            <s:a action="comment_list_route">
                <s:param name="id" value="id"/>
                Comment(s):
            </s:a>
            <s:param name="id" value="id"/>
        </s:a>
        </td>
    </tr>
    </tbody>
</table>
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
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>



    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<a name="comments"></a>
<h2>Comments</h2>
<%--<s:if test="#session.user">--%>
<s:form action="createCommentSpot" method="POST">
    <s:hidden name="comment.spot.id" value="%{spot.id}"/>
    <s:hidden name="comment.memberComment.id" value="%{session.user.id}" label="Member:"/>
    <s:textarea name="comment.text" placeholder="New Comment"  requiredLabel="true" onclick=""/>
    <s:submit value="New Comment"/>

</s:form>


<%--</s:if>--%>

<s:iterator value="%{spot.commentList}">
<table class="table table-bordered table-hover">
    <thead>
    <th><s:property value="text"/>
    </th>
    <th><s:property value="date"/>
    </th>
    <th>
        <s:a action="member_detail" style="display:block;text-decoration:none;" >
            <s:property value="memberComment.login" escapeHtml="false"/>
            <s:param name="id" value="spot.memberSpotid"/>
        </s:a>
    </th>

        <th>
            <s:a action="comment_delete" style="display:block;text-decoration:none;" >
                Remove
                <s:param name="id" value="id"/>
            </s:a>

        </th>

    </thead>
</table>
</s:iterator>



<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>





