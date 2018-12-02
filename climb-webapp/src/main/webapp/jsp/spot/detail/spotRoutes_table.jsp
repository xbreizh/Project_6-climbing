<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="spot.routeList.size() > 0">
    <img alt="mapRoute" src="http://vincent.boulas.free.fr/teamgrimptout/topos/ainsavoiehautesavoie/topo_malpas.gif">
    <h2>Routes</h2>


        <table class="table  table-hover">
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
    <s:iterator value="%{routeList}">
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
    </s:iterator>
            </tbody>
        </table>

</s:if>
<s:else>
    <h2> No route yet for this Spot </h2>
</s:else>
<s:if test="#session.user">
    <s:a action="createRoute">
        <s:param name="id" value="id"/>
        <button type="button" class="btn btn-warning">New Route</button>
    </s:a>
</s:if>
