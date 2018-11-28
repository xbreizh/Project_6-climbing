<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../_include/header.jsp" %>

<h1>My Space</h1>

<s:property value="#session.user.role"/>
<s:if test="#session.user">
<s:if test="#session.user.id == id">

    <%@include file="../topo/spotTable.jsp" %>
    <%@include file="../topo/topoTable.jsp" %>
    <%@include file="../topo/routeTable.jsp" %>
    <%@include file="../topo/bookingTable.jsp" %>





</s:if>
    <s:else>There is an issue with your session, please log off then reconnect</s:else>

</s:if>