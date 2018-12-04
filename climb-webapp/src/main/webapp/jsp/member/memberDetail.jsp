<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<s:if test="#session.user">

<table class="table table-hover">
    <thead>
    <tr>
    <s:if test="#session.user.role =='superadmin'">
        <th>Id </th>
    </s:if>
        <th>Role </th>
        <th>Login</th>
        <th>Email </th>
        <th>Active</th>
    </tr>
    </thead>
    <tbody>
        <tr>
        <s:if test="#session.user.role =='superadmin'">
            <td>
                <s:property value="member.id"/>

            </td>
        </s:if>
            <td>
                <s:property value="member.role" />

            </td>
            <td>
                <s:property value="member.login" />

            </td>
            <td>
                <s:property value="member.email" />

            </td>
            <td>
                <s:property value="member.active" />

            </td>
            <s:if test="#session.user.role =='superadmin' && session.user.id != member.id">
                <td>
                    <s:if test="member.active == true">
                        <s:a action="member_disable" style="display:block;text-decoration:none;" >
                            <button type="button" class="btn btn-danger">Disable</button>
                            <s:param name="id" value="id"/>
                        </s:a>
                    </s:if>
                    <s:else>
                        <s:a action="member_enable" style="display:block;text-decoration:none;" >
                            <button type="button" class="btn btn-success">Enable</button>
                            <s:param name="id" value="id"/>
                        </s:a>
                    </s:else>
                </td>
            </s:if>
        </tr>
    </tbody>
</table>
<h3>Description: </h3><s:property value="member.description" />

</s:if>
<s:else>
    <%@include file="../_include/connectButton.jsp" %>
</s:else>