
<s:if test="%{spotList.size()>0}">
    <table class="table  table-hover" >
        <thead>
        <tr>
            <th></th>
            <th>Country</th>
            <th>City</th>
            <th>Name</th>
            <th>Number Routes</th>
            <th>Description</th>
            <th>Creator </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="spotList">

            <tr>
                <td>
                    <s:a action="spot_detail" style="display:block;text-decoration:none;" >
                        <button type="button" class="btn btn-light">Details</button>
                        <s:param name="id" value="id"/>
                    </s:a>
                </td>


                <td><s:a action="spot_detail" style="display:block;text-decoration:none;">
                    <s:property value="country.name" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>

                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="city" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="name" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="routeList.size()" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="description" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td>
                    <s:if test="#session.user.id == memberSpot.id">
                        <s:a action="member_detail">
                            <s:param name="id" value="memberSpot.id" />
                            <span style=" font-weight: bold;color: #ffae6e">You</span>
                        </s:a>
                    </s:if>
                    <s:else>
                        <s:a action="member_detail">
                            <s:param name="id" value="memberSpot.id" />
                            <s:property value="memberSpot.login"/>
                        </s:a>
                    </s:else>
                </td>
                <s:if test="session.user.role == 'superadmin' || session.user.id == memberSpot.id">
                    <td>
                        <s:form action="spot_update" method="POST">
                            <s:textfield name="spot" value="%{id}"  requiredLabel="true"/>
                            <s:submit class="btn btn-warning" value="Edit"/>
                        </s:form>
                    </td>
                    <s:if test="session.user.role == 'superadmin'">
                    <td>
                        <s:form action="spot_delete" method="POST">
                            <s:textfield name="spot" value="%{id}"  requiredLabel="true"/>
                            <s:submit class="btn btn-danger" value="Delete"/>
                        </s:form>

                    </td>
                    </s:if>
                </s:if>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if><s:else>
    No Spot Found!
</s:else>