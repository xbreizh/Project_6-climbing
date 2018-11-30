<%--<h2>Routes</h2>--%>
<s:if test="%{routeList.size()>0}">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Name </th>
            <th>Spot </th>
            <th>Grade </th>
            <th>Height </th>
            <th>Description </th>
            <th>Creator</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="routeList">
            <tr>
                <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="name" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="spot.name"/>
                    <s:param name="id" value="spot.id"/>
                </s:a>
                </td>
                <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="grade"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="height"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="description" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                <td>
                <s:if test="#session.user.id == memberRoute.id">
                    <s:a action="member_detail">
                        <s:param name="id" value="memberRoute.id" />
                        <span style=" font-weight: bold;color: #ffae6e">You</span>
                    </s:a>
                </s:if>
                    <s:else>
                        <s:a action="member_detail">
                            <s:param name="id" value="memberRoute.id" />
                            <s:property value="memberRoute.login"/>
                        </s:a>
                    </s:else>

                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if><s:else>
    No Topo Found!
</s:else>