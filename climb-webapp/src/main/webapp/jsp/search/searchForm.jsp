<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>


<h2>Search by keyword </h2>
    Search:
    <s:form action="spotSearch_list" method="POST">
        <s:textfield name="str" requiredLabel="true"/>
        <s:submit value="Search"/>
    </s:form>

<h2>Spot</h2>
<div id="content">
    Keyword: <s:property value="%{str}"/><br>
    This is a color of red and blue and green and red and blue orange.
<s:iterator value="spotList">
    <ul>
        <li>Continent: <s:property value="country.continent"/></li>
        <li>Country: <s:property value="country.name"/></li>
        <li>City: <s:property value="city"/></li>
        <li>Name: <s:property value="name" escapeHtml="false"/></li>
        <li>Description: <s:property value="description"/></li>
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
    <li>Description: <s:property value="description"/></li>
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
</body>
</html>
