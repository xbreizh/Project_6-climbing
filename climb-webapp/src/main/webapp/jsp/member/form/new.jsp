<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>


<h2>Création d'un membre</h2>

<s:form action="member_new" method="POST">
    <s:textfield type="text" name="member.login" placeholder="Login" requiredLabel="true"/>
    <s:textfield type="email" name="member.email" inputPrepend="@" placeholder="Email" requiredLabel="true"/>
    <s:textfield type="email" name="emailCheck" inputPrepend="@" placeholder="Repeat Email" requiredLabel="true"/>
    <s:password name="member.password" placeholder="Password" requiredLabel="true" />
    <s:password name="passwordCheck" placeholder="Repeat Password" requiredLabel="true" />
    <s:textarea name="member.description" placeholder="Description" requiredLabel="true" />
    <s:submit cssClass="btn btn-primary"/>
</s:form>
</body>
</html>