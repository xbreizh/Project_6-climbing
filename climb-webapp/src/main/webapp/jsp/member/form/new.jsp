<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>


<h2>Création d'un membre</h2>

<s:form action="member_new" method="POST">
    <s:textfield type="text" name="member.login" label="Login" requiredLabel="true"/>
    <s:textfield type="email" name="member.email" label="Email" requiredLabel="true"/>
    <s:textfield type="email" name="emailCheck" label="Repeat Email" requiredLabel="true"/>
    <s:password name="member.password" label="Password" requiredLabel="true" />
    <s:password name="passwordCheck" label="Repeat Password" requiredLabel="true" />
    <s:textarea name="member.description" label="Description" requiredLabel="true" value="member.description"/>
    <s:submit value="OK"/>
</s:form>
</body>
</html>