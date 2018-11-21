<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="r" uri="/struts-tags" %>


<header>
    <link href="<s:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <title>Climb</title>

</header>
<body>
<div class="container">

<%--<%@include file="head.jsp"%>--%>
    <%@include file="navbar.jsp"%>

<s:actionerror/>
<s:actionmessage/>