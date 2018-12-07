
<div style="display: none" id="menu-spot-result">
    <h2>Spots</h2>
<s:if test="%{spotList.size()>0}">
    <table class="table  table-hover" >
        <thead>
        <tr>
            <th>City</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="spotList">
            <tr>
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
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</s:if>
</div>

