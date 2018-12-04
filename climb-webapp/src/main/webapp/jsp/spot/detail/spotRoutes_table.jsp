<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="spot.routeList.size() > 0">
    <img alt="mapRoute" src="http://vincent.boulas.free.fr/teamgrimptout/topos/ainsavoiehautesavoie/topo_malpas.gif">
    <h2>Routes</h2>


        <table class="table  table-hover">
            <thead>
            <tr>
                <th></th>
                <th>Name </th>
                <th>Height </th>
                <th>Grade</th>
                <th>Creator</th>
                <th>Comment(s)</th>
            </tr>
            </thead>
            <tbody>
    <s:iterator value="%{routeList}">
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
              <%--  <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="type" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>--%>
               <%-- <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="description" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>--%>
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
