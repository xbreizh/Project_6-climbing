<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>


<h2>Création d'un membre</h2>

<s:form action="member_new" method="POST">
    <s:textfield type="text" name="member.login" label="Login" requiredLabel="true"/>
    <s:password name="member.password" label="Password" requiredLabel="true" />
    <s:password name="password_check" label="Password" requiredLabel="true" />
    <s:textarea name="member.description" label="Description" requiredLabel="true" value="member.description"/>
    <s:submit value="OK"/>
</s:form>
</body>
</html>