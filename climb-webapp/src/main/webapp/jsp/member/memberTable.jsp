<h2>Members</h2>
<s:if test="%{listMember.size()>0}">
    <table class="table table-bordered table-hover">
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

            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if><s:else>
    No Member Found!
</s:else>