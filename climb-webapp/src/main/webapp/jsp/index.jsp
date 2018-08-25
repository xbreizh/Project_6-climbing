<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<body>

<%@include file="_include/header.jsp"%>
<h1><s:text name="home.welcome"/></h1>


<s:a action="member_list">
    <s:text name="nav.listMember"/>
</s:a>

test
</body>
</html>


