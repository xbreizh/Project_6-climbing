<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="_include/header.jsp" %>

<body>
<%--<div class="row">
<div class="col-lg-12">
<h1><s:text name="home.welcome"/></h1>

<s:a action="pwd_reset">
    Password Reset
</s:a><br><br>
<s:a action="topo_new">
    Topo Creation
</s:a><br><br>
<s:a  action="testHtml">
    testHtml
</s:a><br><br>
<s:a action="searchByKeyword">
    SEARCH
</s:a><br><br>
</div></div>--%>
<div class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-10">
<%@include file="spot/map_index.jsp" %>
    </div>
    <div class="col-lg-1"></div>
</div>
<div class="row">
    <div class="col-lg-1"></div>

    <div class="col-lg-10">
<%@include file="search/searchForm.jsp" %>
    </div>
    <div class="col-lg-1"></div>
</div>
<div class="row">
    <div class="col-lg-12">
<%@include file="search/index_search_result.jsp" %>
    </div></div>
<div class="row">
    <div class="col-lg-12">
<%@include file="_include/footer.jsp" %>
    </div></div>
<s:property value="#session."/>