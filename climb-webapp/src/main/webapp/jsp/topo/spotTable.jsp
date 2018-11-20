<h2>Spot</h2>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Country </th>
            <th>City </th>
            <th>Name </th>
            <th>Description </th>
            <th>Creator </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="spotList">

            <tr>

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
                    <s:property value="description" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="member_detail">
                    <s:param name="id" value="memberSpot.id"/>
                    <s:property value="memberSpot.login"/>
                </s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>