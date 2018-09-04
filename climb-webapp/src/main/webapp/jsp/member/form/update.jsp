<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Member</title>
</head>
<body>

<s:form action="member_update">
    <%--Id: <s:property value="member.id"/><br>--%>
    Login: <s:property value="member.login"/>
    <s:hidden name="member.id" value="%{id}"/>
    <s:password name="member.password" label="Password" requiredLabel="true"/>
    <s:textarea name="member.description" label="Description" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="member_delete">Delete
    <s:param name="member.id" value="%{id}"/>
</s:a>

</body>
</html>
