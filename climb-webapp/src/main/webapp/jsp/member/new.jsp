<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../_include/header.jsp" %>
<meta charset="UTF-8">


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