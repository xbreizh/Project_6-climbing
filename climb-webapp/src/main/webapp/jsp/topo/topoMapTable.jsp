<h2>Topos</h2>
<s:if test="%{topoList.size()>0}">
    <table class="table  table-hover" >
        <thead >
        <tr>
            <th>Name </th>
            <th>Description </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="topoList">
            <tr>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="name" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                        <s:property value="description" escapeHtml="false"/>
                        <s:param name="id" value="id"/>
                    </s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if>
<s:else>
    No Topo found!
</s:else>
