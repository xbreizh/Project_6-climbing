<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Xavier.Lamourec
  Date: 29/08/2018
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Member</title>
</head>
<body>
<s:form action="member_update">
    <s:textfield name="member.id" label="Id" requiredLabel="true"/>
    <s:textfield name="member.login" label="Login" requiredLabel="true"/>
    <s:password name="member.password" label="Password" requiredLabel="true"/>
    <s:textarea name="member.description" label="Description" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>


</body>
</html>
