<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/head.jsp" %>

<body>

<s:form action="member_update" method="POST">
     id: <s:property value="description"/>
    <s:hidden name="member.id" value="%{id}"/>
    <s:textarea name="member.login" label="Login" requiredLabel="true" value="%{login}"/>
    <s:password name="member.password" label="Password" requiredLabel="true" value="tettetete"/>
    <%--<s:password name="password_check" label="Confirm Password" requiredLabel="true" />--%>
    <s:textarea name="member.description" label="Description" requiredLabel="true" value="test"/>
    <s:checkbox name="member.active" label="Active" value="member.active"/>
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="member_delete">Delete
    <s:param name="member.id" value="%{id}"/>
</s:a>

</body>
</html>
