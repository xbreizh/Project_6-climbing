<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>
<h2><s:property value="%{spot.name}"/> - New Route:</h2>
<li>Id: <s:property value="id"/></li>
<s:form action="createRoute" method="POST">
    <s:textfield type="text" name="route.name" label="Name" requiredLabel="true"/>
    <s:select list="heighList" name="route.height" label="Height" requiredLabel="true"/>
    <s:select list="gradeList" type="text" name="route.grade" label="Grade" requiredLabel="true"/>
    <s:select list="typeList" name="route.type" label="Type" requiredLabel="true" />
    <s:textarea type="text" name="route.description" label="Description" requiredLabel="true"/>
    <s:textfield name="route.memberRoute.id" label="Member" value="%{session.user.id}" requiredLabel="true" />
    <s:textfield name="route.spot.id" value="%{spot.id}" label="Spot" requiredLabel="true" />
    <s:hidden name="id" value="%{id}" />
    <s:submit value="OK"/>
</s:form>

<s:a action="spot_detail">
    <s:param name="id" value="%{spot.id}"/>
    Back to List:
</s:a>
</body>
</html>