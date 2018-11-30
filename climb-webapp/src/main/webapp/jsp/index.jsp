<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="_include/header.jsp" %>

<body>
<div id="content">
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
        <%@include file="spot/spotTable.jsp" %>
        <%@include file="topo/topoTable.jsp" %>
    </div></div>
</div>
<div class="row">
    <div class="col-lg-12">
<%@include file="_include/footer.jsp" %>
    </div></div>
<s:property value="#session."/>