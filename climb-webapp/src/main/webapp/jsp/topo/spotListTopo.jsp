<h2>Spots</h2>
<s:form style="display:inline!important;" action="topo_addSpot" method="POST">
    <s:select list="%{spotList}" name="spotId" listKey="id" headerKey="-1" headerValue="-- Spot --" />
    <s:hidden name="id" placeholder="topo Id" requiredLabel="true"/><br>
    <s:submit class="btn btn-success" value="Add"/>
</s:form>
<br><br>
<table class="table table-hover">
    <thead class="noborders">
    <tr>
        <th>Country </th>
        <th>City </th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody class="table table-bordered table-hover">
    <s:iterator value="topo.spots">
        <tr>
            <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
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
            <td class="noborders">
                <s:form action="topo_removeSpot" method="POST">
                    <s:hidden name="id" placeholder="topo Id" requiredLabel="true"/>
                    <s:hidden name="topo.id" placeholder="topo Id" requiredLabel="true"/>
                    <s:submit  class="btn btn-danger" value="remove"/>
                </s:form>

            </td>
        </tr>

    </s:iterator>
    </tbody>
</table>

