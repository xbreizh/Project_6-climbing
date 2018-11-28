<h2>Topo</h2>
<s:if test="%{topoList.size()>0}">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Available </th>
            <th>Name </th>
            <th>Edition </th>
            <th>Author </th>
            <th>Published Year </th>
            <th>Description </th>
            <th>Creator</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="topoList">
            <tr>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:if test="available == true">
                        <i class="glyphicon glyphicon-ok" style="font-size:50px;color:green"></i>
                    </s:if><s:else>
                    <i class="glyphicon glyphicon-ban-circle" style="font-size:50px;color:red"></i>
                </s:else>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="name" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="author"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="edition"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="publishedYear"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="description" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                <td>
                <s:if test="#session.user.id == owner.id">
                    <s:a action="member_detail">
                        <s:param name="id" value="owner.id" />
                        <span style=" font-weight: bold;color: #ffae6e">You</span>
                    </s:a>
                </s:if>
                    <s:else>
                        <s:a action="member_detail">
                            <s:param name="id" value="owner.id" />
                            <s:property value="owner.login"/>
                        </s:a>
                    </s:else>

                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if><s:else>
    No Topo Found!
</s:else>