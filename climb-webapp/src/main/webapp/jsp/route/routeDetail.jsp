<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Name </th>
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
                    <span style=" font-weight: bold;color: #ffae6e">You</span>
                </s:a>
            </s:if>
            <s:else>
                <s:a action="member_detail">
                    <s:param name="id" value="route.memberRoute.id" />
                    <s:property value="route.memberRoute.login"/>
                </s:a>
            </s:else>
        </td>
        <s:if test="session.user.role == 'superadmin' || session.user.id == route.memberRoute.id">
            <td>
                <s:form action="route_update" method="POST">
                    <s:textfield name="route" value="%{route.id}"  requiredLabel="true"/>
                    <s:submit class="btn btn-warning" value="Edit"/>
                </s:form>
            </td>
            <td>
                <s:form action="route_delete" method="POST">
                    <s:textfield name="route" value="%{route.id}"  requiredLabel="true"/>
                    <s:submit class="btn btn-danger" value="Delete"/>
                </s:form>

            </td>
        </s:if>
    </tr>
    </tbody>
</table>

<s:a action="spot_detail" style="display:block;text-decoration:none;" >
    Back to Spot
    <s:param name="id" value="route.spot.id"/>
</s:a>