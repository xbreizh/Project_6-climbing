<h2>Spot</h2>
<div id="content">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Continent </th>
            <th>Country </th>
            <th>City </th>
            <th>Name </th>
            <th>Description </th>
            <th>Creator
            </th>
        </tr>
        </thead>
        <tbody>
    <s:iterator value="spotList">

            <tr>
                <td><s:property value="country.name" escapeHtml="false"/></td>
                <td><s:property value="city" escapeHtml="false"/></td>
                <td><s:property value="name" escapeHtml="false"/></td>
                <td><s:property value="description" escapeHtml="false"/></td>
                <td><s:a action="member_detail">
                    <s:param name="id" value="memberSpot.id"/>
                    <s:property value="memberSpot.login"/>
                </s:a>
                </td>
                <td>
                    <s:a action="spot_detail">Details
                        <s:param name="id" value="id"/>
                    </s:a>

                </td>
            </tr>
    </s:iterator>
        </tbody>
        </table>
    <h2>Topo</h2>
    <s:if test="%{topoList.size()>0}">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Name </th>
            <th>Edition </th>
            <th>Author </th>
            <th>Published Year </th>
            <th>Description </th>
            <th>Creator
            </th>
        </tr>
        </thead>
        <tbody>
    <s:iterator value="topoList">
    <tr>
    <td><s:property value="name" escapeHtml="false"/></td>
    <td><s:property value="edition"/></td>
    <td><s:property value="author"/></td>
    <td><s:property value="publishedYear"/></td>
    <td><s:property value="description" escapeHtml="false"/></td>
    <td>
            Creator:
            <s:a action="member_detail">
                <s:param name="id" value="owner.id" />
                <s:property value="owner.login"/>
            </s:a>
        </td>
    </tr>
    </s:iterator>
        </tbody>
    </table>
    </s:if><s:else>
    No Spot Found!
</s:else>
</div>