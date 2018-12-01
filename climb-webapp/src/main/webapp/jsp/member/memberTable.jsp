<h2>Members</h2>
<s:if test="%{listMember.size()>0}">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id </th>
            <th>Role </th>
            <th>Login</th>
            <th>Email </th>
            <th>Active</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="listMember">

            <tr>

                <td><s:a action="member_detail" style="display:block;text-decoration:none;">
                    <s:property value="id" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="member_detail" style="display:block;text-decoration:none;">
                    <s:property value="role" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="member_detail" style="display:block;text-decoration:none;">
                    <s:property value="login" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="member_detail" style="display:block;text-decoration:none;">
                    <s:property value="email" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="member_detail" style="display:block;text-decoration:none;">
                    <s:property value="active" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td>
                    <s:form action="member_update" method="POST">
                        <s:hidden name="member" value="%{id}"  requiredLabel="true"/>
                        <s:submit class="btn btn-warning" value="Edit"/>
                    </s:form>
                </td>
                <td>
                <s:a action="member_delete" style="display:block;text-decoration:none;" >
                    <button type="button" class="btn btn-danger">Delete</button>
                </s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if><s:else>
    No Member Found!
</s:else>