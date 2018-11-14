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
    <div class="form-group">
        Keyword: <input type="text" class="form-control" name="str"  value = "${str}" requiredLabel="false">
    </div>
    <div class="form-group">Climbing Type:
        <label class="radio-inline">
            <s:radio list="climbingList" name="climbingType" label="climbing Type" default="climbingType"></s:radio>
        </label>
    </div>
       <%-- <label class="radio-inline">
            <s:textfield type="radio" name="climbingType" value="All"></s:textfield>
        </label>
        <label class="radio-inline">
            <input type="radio" name="climbingType" value="Boulder">Boulder
        </label>
        <label class="radio-inline">
            <input type="radio" name="climbingType" value="RopeClimbing">RopeClimbing
        </label>--%>

    <div class="form-group">
    <div class="checkbox">
        <label><input type="checkbox" name="hasTopo" <c:if test="${hasTopo.equals('on')}">checked="true"</c:if>>Has Topo</label>
    </div>
    </div>
    <div class="form-group">
    <s:submit value="Refresh"/>
    </div>
</s:form>
   <%-- <div class="form-group">
        <div data-role="rangeslider">
            <label for="level-min">Level:</label>
            <input type="range" name="price-min" id="level-min" value="2" min="0" max="10">
            <label for="level-max">Level:</label>
            <input type="range" name="level-max" id="level-max" value="8" min="0" max="10">
        </div>
    </div>--%>
<%--
<div id="slider"></div>
<script>
    var steps = [
        "very sad",
        "sad",
        "not so sad",
        "happy",
        "very happy"
    ];

    $(function() {
        $("#slider").slider({
            value: 1,
            min: 0,
            max: 4,
            step: 1,
            slide: function(event, ui) {
                $("#amount").val(steps[ui.value]);
            }
        });
        $("#amount").val(steps[$("#slider").slider("value")]);
    });
</script>

<p>
    <label for="amount">Donation amount ($50 increments):</label>
    <input type="text" id="amount" readonly style="border:0; color:#f6931f; font-weight:bold;">
</p>

<div id="slider"></div>--%>

<h2>Spot</h2>
<div id="content">
<s:iterator value="spotList">
    <ul>
        <li>Continent: <s:property value="country.continent" escapeHtml="false"/></li>
        <li>Country: <s:property value="country.name" escapeHtml="false"/></li>
        <li>City: <s:property value="city" escapeHtml="false"/></li>
        <li>Name: <s:property value="name" escapeHtml="false"/></li>
        <li>Description: <s:property value="description" escapeHtml="false"/></li>
        <li>GPS coordinates: <s:property value="latitude"/>,<s:property value="longitude"/></li>
        <li>Creator:
            <s:a action="member_detail">
                <s:param name="id" value="memberSpot.id"/>
                <s:property value="memberSpot.login"/>
            </s:a>
        </li>
        <li>
            <s:a action="spot_detail">Details
                <s:param name="id" value="id"/>
            </s:a>

        </li>
    </ul>
</s:iterator>
<h2>Topo</h2>
<s:iterator value="topoList">
    <li>Name: <s:property value="name" escapeHtml="false"/></li>
    <li>Edition: <s:property value="edition"/></li>
    <li>Author: <s:property value="author"/></li>
    <li>Published Year: <s:property value="publishedYear"/></li>
    <li>Description: <s:property value="description" escapeHtml="false"/></li>
    <li>
        <%--<s:a action="topo_detail" >
            <s:property value="nom"/>
            <s:param name="id" value="id"/>
        </s:a>--%>
        Créateur:
        <s:a action="member_detail">
            <s:param name="id" value="owner.id" />
            <s:property value="owner.login"/>
        </s:a>
    </li>
    <br><br>
</s:iterator>
</div>
<%--<script>
var word = "${str}" ;
</script>
<script src="js/colorSearch.js"></script>--%>
<%--
</body>
</html>
--%>
