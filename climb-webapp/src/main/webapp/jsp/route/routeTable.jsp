<%--<h2>Routes</h2>--%>
<s:if test="%{routeList.size()>0}">
    <table class="table  table-hover">
        <thead>
        <tr>
            <th></th>
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
                <td>
                    <s:form action="route_detail" method="POST">
                        <s:hidden name="route" value="%{id}"  requiredLabel="true"/>
                        <s:submit class="btn btn-light" value="Details"/>
                    </s:form>
                </td>
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
                <s:if test="session.user.role == 'superadmin' || session.user.id == route.memberRoute.id">
                    <td>
                        <s:form action="route_update" method="POST">
                            <s:hidden name="route" value="%{id}"  requiredLabel="true"/>
                            <s:submit class="btn btn-warning" value="Edit"/>
                        </s:form>
                    </td>
                    <td>
                        <s:form action="route_delete" method="POST">
                            <s:hidden name="route" value="%{id}"  requiredLabel="true"/>
                            <s:submit class="btn btn-danger" value="Delete"/>
                        </s:form>
                    </td>
                </s:if>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if><s:else>
    No Topo Found!
</s:else>