<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>
<s:a action="spot_detail">
    <s:param name="id" value="route.spot.id" />
   Back to Route list
</s:a>
<table class="table table-hover">
    <thead>
    <tr>
        <th>Name </th>
        <th>Spot</th>
        <th>Grade </th>
        <th>Height </th>
        <th>Description</th>
        <th>Creator</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <s:property value="route.name" escapeHtml="false"/>
        </td>
        <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
            <s:property value="route.spot.name" escapeHtml="false"/>
            <s:param name="id" value="route.spot.id"/>
        </s:a>
        </td>
        <td>
            <s:property value="route.grade" escapeHtml="false"/>
        </td>
        <td>
            <s:property value="route.height" escapeHtml="false"/>
        </td>
        <td>
            <s:property value="route.description" escapeHtml="false"/>
        </td>
        <td>
            <s:if test="#session.user.id == route.memberRoute.id">
                <s:a action="member_detail">
                    <s:param name="id" value="route.memberRoute.id" />
                    <span style=" font-weight: bold;color: #ffae6e; text-decoration: none" >You</span>
                </s:a>
            </s:if>
            <s:else>
                <s:a action="member_detail" style="text-decoration: none;">
                    <s:param name="id" value="route.memberRoute.id" />
                    <s:property value="route.memberRoute.login"/>
                </s:a>
            </s:else>
        </td>
        <s:if test="session.user.role == 'superadmin' || session.user.id == route.memberRoute.id">
            <td>
                <s:form action="route_update" method="POST">
                    <s:hidden name="route" value="%{route.id}"  requiredLabel="true"/>
                    <s:submit class="btn btn-warning" value="Edit"/>
                </s:form>
            </td>
            <td>
                <s:form action="route_delete" method="POST">
                    <s:hidden name="route" value="%{route.id}"  requiredLabel="true"/>
                    <s:submit class="btn btn-danger" value="Delete"/>
                </s:form>

            </td>
        </s:if>
    </tr>
    <tr>
        <s:if test="session.user">
        <td  colspan="8">

                <s:form style="display: inline;" action="createCommentRoute" method="POST">
                    <s:hidden name="comment.route.id" value="%{id}"/>
                    <s:hidden name="comment.memberComment.id" value="%{session.user.id}" label="Member:"/>
                    <s:textarea name="comment.text" placeholder="New Comment"  requiredLabel="true" onclick=""/>
                    <s:submit class="btn btn-success" value="Comment"/>

                </s:form>
        </td>
        </s:if>
    </tr>
    <tr>

        <td colspan="8">
            <a href="#" onclick="toggle_display('${id}');">
                See all comments
            </a><br>
            <div id="${id}" style="display: none">
                <%@include file="../comment/commentRouteTableDetail.jsp" %>
            </div>
        </td>

    </tr>
    </tbody>
</table>

<s:a action="spot_detail" style="display:block;text-decoration:none;" >
    Back to Spot
    <s:param name="id" value="route.spot.id"/>
</s:a>