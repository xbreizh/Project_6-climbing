<table class="table table-hover">
    <thead>
    <tr>
        <th>Continent </th>
        <th>Country </th>
        <th>City </th>
        <th>Description</th>
        <th>Creator</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <s:property value="spot.country.continent" escapeHtml="false"/>
        </td>
        <td>
            <s:property value="spot.country.name" escapeHtml="false"/>
        </td>
        <td>
            <s:property value="spot.city" escapeHtml="false"/>
        </td>
        <td>
            <s:property value="spot.description" escapeHtml="false"/>
        </td>
        <td>
            <s:if test="#session.user.id == spot.memberSpot.id">
                <s:a action="member_detail">
                    <s:param name="id" value="spot.memberSpot.id" />
                    <span style=" font-weight: bold;color: #ffae6e">You</span>
                </s:a>
            </s:if>
            <s:else>
                <s:a action="member_detail">
                    <s:param name="id" value="spot.memberSpot.id" />
                    <s:property value="spot.memberSpot.login"/>
                </s:a>
            </s:else>
        </td>
        <s:if test="session.user.role == 'superadmin' || session.user.id == spot.memberSpot.id">
            <td>
                <s:form action="spot_update" method="POST">
                    <s:textfield name="spot" value="%{id}"  requiredLabel="true"/>
                    <s:submit class="btn btn-warning" value="Edit"/>
                </s:form>
            </td>
            <td>
                <s:form action="spot_delete" method="POST">
                    <s:hidden name="spot" value="%{id}"  requiredLabel="true"/>
                    <s:submit class="btn btn-danger" value="Delete"/>
                </s:form>

            </td>
        </s:if>
    </tr>
    </tbody>
</table>
<s:if test="spot.routeList.size() < 1">
    A spot with no route won't appear on the main map!<br><br>
    <s:a action="createRoute">
        <s:param name="id" value="id"/>
        <button type="button" class="btn btn-warning">New Route</button>
    </s:a>
</s:if>