<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>

Slork

<s:form action="member_update" method="POST">
     <%--id: <s:property value="${description}"/>--%>
    <s:hidden name="member.id" value="%{id}"/>
   <%-- <s:textarea name="member.login" label="Login" requiredLabel="true" value="%{login}"/>--%>
   <%-- <s:property value="login"/>--%>
    <%--<s:password name="member.password" label="Password" requiredLabel="true" value="tettetete"/>--%>
    <%--<s:password name="password_check" label="Confirm Password" requiredLabel="true" />--%>
    <s:textarea name="member.description" label="Description" requiredLabel="true" />
    <s:checkbox name="member.active" label="Active" />
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="member_delete">Delete
    <s:param name="member.id" value="%{id}"/>
</s:a>

</body>
</html>
