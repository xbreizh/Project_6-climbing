<%@ taglib prefix="s" uri="/struts-tags" %>
<s:property value="%{route.commentList.size()}" escapeHtml="false"/>
<s:if test="%{route.commentList.size()>0}">
    <table class="table  table-hover" >
        <tbody>
        <s:iterator value="route.commentList">

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
                            <s:param name="id" value="route.memberRoute.id" />
                            <s:property value="route.memberRoute.login"/>
                        </s:a>
                    </s:else>
                </td>
                    <s:if test="session.user.role == 'superadmin'">
                        <td>
                            <s:a action="route_detail" style="display:block;text-decoration:none;" >
                                <s:property value="route.name" escapeHtml="false"/>
                                <s:param name="id" value="id"/>
                            </s:a>
                        </td>
                        <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                            <s:property value="route.id" escapeHtml="false"/>
                            <s:param name="id" value="id"/>
                        </s:a>
                        </td>
                    </s:if>
                <td>
                    <s:property value="text" escapeHtml="false"/>
                </td>
                <s:if test="session.user.role == 'superadmin' || session.user.id == route.memberRoute.id">
                <td>
                    <s:form action="route_comment_delete" method="POST">
                        <s:hidden name="id" value="%{id}"  requiredLabel="true"/>
                        <s:submit class="btn btn-danger" value="Remove"/>
                    </s:form>
                </td>
                </s:if>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if>
<s:else>
    No Message on this route yet!
</s:else>
