<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%--<html>

<%@include file="../_include/header.jsp" %>

<body>--%>


<%--<h2>Search by keyword </h2>
    Search:--%>
<s:form class="justify-content-center"  action="index" method="POST">

    <s:textfield class="form-control" label="Keyword" placeholder="Keyword" name="str"  value = "%{str}" requiredLabel="false"></s:textfield>


            <s:radio list="climbingList" name="climbingType" label="Climbing Type"> <s:if test="%{climbingType == null}">checked="ALL"</s:if></s:radio>
    <s:select list="{1,2,3}" value="levelMin" label="Level Min"></s:select>
    <s:select list="{1,2,3}" value="levelMax" label="Level Max"></s:select>

    <s:checkbox  name="hasTopo"  label="has Topo">
        <s:if test="%{hasTopo.equals('on')}">checked="true"</s:if>
    </s:checkbox>



    <s:submit value="Refresh"/>

</s:form>




