<h2>Spot</h2>
<div id="content">
    <s:iterator value="spotList">
        <ul>
            <li>Continent: <s:property value="country.continent" escapeHtml="false"/></li>
            <li>Country: <s:property value="country.name" escapeHtml="false"/></li>
            <li>City: <s:property value="city" escapeHtml="false"/></li>
            <li>Name: <s:property value="name" escapeHtml="false"/></li>
            <li>Description: <s:property value="description" escapeHtml="false"/></li>
           <%-- <li>GPS coordinates: <s:property value="latitude"/>,<s:property value="longitude"/></li>--%>
            <li>Creator:
                <s:a action="member_detail">
                    <s:param name="id" value="memberSpot.id"/>
                    <s:property value="memberSpot.login"/>
                </s:a>
            </li>
            <li>
                <s:a action="spot_detail">Details
                    <s:param name="id" value="id"/>
                </s:a>

            </li>
        </ul>
    </s:iterator>
    <h2>Topo</h2>
    <s:iterator value="topoList">
        <li>Name: <s:property value="name" escapeHtml="false"/></li>
        <li>Edition: <s:property value="edition"/></li>
        <li>Author: <s:property value="author"/></li>
        <li>Published Year: <s:property value="publishedYear"/></li>
        <li>Description: <s:property value="description" escapeHtml="false"/></li>
        <li>
            Créateur:
            <s:a action="member_detail">
                <s:param name="id" value="owner.id" />
                <s:property value="owner.login"/>
            </s:a>
        </li>
        <br><br>
    </s:iterator>
</div>