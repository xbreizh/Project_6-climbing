<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>
<div id="container" class="container">
    <div class="row text-white">
        <div class="col-sm-6 col-md-offset-3 text-center">
            <h1 class="display-3">Member Creation</h1>
            <div class="info-form">


<s:form class=" justify-content-center" action="member_new" method="POST">
    <div class="form-group">
        <label class="sr-only">Login</label>
        <input name="member.login" type="text" class="form-control" placeholder="Login">
    </div>
    <div class="form-group">
        <label class="sr-only">Name</label>
        <input name="member.email" type="email" class="form-control" placeholder="Email">
    </div>
    <div class="form-group">
        <label class="sr-only">Name</label>
        <input name="emailCheck" type="email" class="form-control" placeholder="Repeat Email">
    </div>
    <div class="form-group">
        <label class="sr-only">Name</label>
        <input name="member.password" type="password" class="form-control" placeholder="Password">
    </div>
    <div class="form-group">
        <label class="sr-only">Name</label>
        <input name="passwordCheck" type="password" class="form-control" placeholder="Repeat Password">
    </div>
    <div class="form-group">
        <label class="sr-only">Name</label>
        <textarea name="member.description" class="form-control" rows="5" placeholder="Description"></textarea>
        <%--<input name="member.description" type="text" class="form-control" placeholder="Description">--%>
    </div>
    <%--<s:textfield type="text" name="member.login" placeholder="Login" requiredLabel="true"/>
    <s:textfield type="email" name="member.email" inputPrepend="@" placeholder="Email" requiredLabel="true"/>
    <s:textfield type="email" name="emailCheck" inputPrepend="@" placeholder="Repeat Email" requiredLabel="true"/>
    <s:password name="member.password" placeholder="Password" requiredLabel="true" />
    <s:password name="passwordCheck" placeholder="Repeat Password" requiredLabel="true" />
    <s:textarea name="member.description" placeholder="Description" requiredLabel="true" />--%>
    <button type="submit" class="btn btn-success">okay, go!</button>
</s:form>
            </div>
            <br>
<%--
            <r:a class="btn btn-success" action="member_new">Become Member</r:a>--%>
        </div>
    </div>
</div>
</body>
<%@include file="../../_include/footer.jsp" %>