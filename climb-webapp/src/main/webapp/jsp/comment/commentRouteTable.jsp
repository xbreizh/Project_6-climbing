<%@ taglib prefix="s" uri="/struts-tags" %>
<h3>Comments Route</h3><br><br>
<s:if test="%{commentListRoute.size()>0}">
    <table class="table  table-hover" >
        <thead>
        <tr>
            <th>Date </th>
            <th>Member </th>
            <th>Route name</th>
            <th>Route id</th>
            <th>Comment</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="commentListRoute">

            <tr>
                <td>
                    <s:property value="date" escapeHtml="false"/>
                </td>
                <td>
                    <s:if test="#session.user.id == memberRoute.id">
                        <s:a action="member_detail">
                            <s:param name="id" value="memberRoute.id" />
                            <span style=" font-weight: bold;color: #ffae6e">You</span>
                        </s:a>
                    </s:if>
                    <s:else>
                        <s:a action="member_detail">
                            <s:param name="id" value="memberRoute.id" />
                            <s:property value="memberRoute.login"/>
                        </s:a>
                    </s:else>
                </td>
                <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="route.name" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="route.id" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td>
                    <s:property value="text" escapeHtml="false"/>
                </td>
                <td>
                    <s:a action="comment_delete" style="display:block;text-decoration:none;" >
                        Remove
                        <s:param name="id" value="id"/>
                        <s:param name="spot.id" value="spot.id"/>
                    </s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if><s:else>
    No Message on routes yet!
</s:else>
