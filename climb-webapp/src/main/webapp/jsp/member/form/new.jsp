<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/head.jsp" %>

<body>


<h2>Création d'un membre</h2>

<s:form action="member_new">
    <s:textfield name="member.id" label="Id" requiredLabel="true"/>
    <s:textfield name="member.login" label="Login" requiredLabel="true"/>
    <s:password name="member.password" label="Password" requiredLabel="true"/>
    <s:textarea name="member.description" label="Description" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>
</body>
</html>