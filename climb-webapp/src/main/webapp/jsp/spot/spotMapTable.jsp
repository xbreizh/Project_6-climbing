<div style="display: block" id="menu-spot-result">
    <h2>Spots</h2>
    <s:if test="%{spotList.size()>0}">
        <table class="table  table-hover">
            <thead>
            <tr>
                <th>Country</th>
                <th>City</th>
                <th>Name</th>
                <th>Description</th>
                <th>Number Routes</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="spotList">
                <tr>
                    <td>
                        <a target="_blank"
                           href="https://en.wikipedia.org/wiki/<s:property value="country.name" escapeHtml="false"/>">
                            <s:property value="country.name" escapeHtml="false"/>
                        </a>
                    </td>
                    <td><a target="_blank"
                           href="https://en.wikipedia.org/wiki/<s:property value="city" escapeHtml="false"/>">
                        <s:property value="city" escapeHtml="false"/>
                    </a>
                    </td>
                    <td><s:a action="spot_detail" style="display:block;text-decoration:none;">
                        <s:property value="name" escapeHtml="false"/>
                        <s:param name="id" value="id"/>
                    </s:a>
                    </td>
                    <td><s:a action="spot_detail" style="display:block;text-decoration:none;">
                        <s:property value="description" escapeHtml="false"/>
                        <s:param name="id" value="id"/>
                    </s:a>
                    </td>
                    <td><s:a action="spot_detail" style="display:block;text-decoration:none;">
                        <s:property value="routeList.size()" escapeHtml="false"/>
                        <s:param name="id" value="id"/>
                    </s:a>
                    </td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </s:if>
    <s:else>
        No Spot found!
    </s:else>
</div>

