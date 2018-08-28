<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<body>

<%@include file="_include/header.jsp"%>
<h1><s:text name="home.welcome"/></h1>


Création<br>
<s:a action="member_new">
    <s:text name="nav.newMember"/>
</s:a><br>
<s:a action="topo_new">
    <s:text name="nav.listTopo"/>
</s:a><br>
<s:a action="zone_new">
    <s:text name="nav.newZone"/>
</s:a><br><br><br>


Listes<br>
<s:a action="member_list">
    <s:text name="nav.listMember"/>
</s:a><br>
<s:a action="zone_list">
    <s:text name="nav.listZone"/>
</s:a><br>
<s:a action="topo_list">
    <s:text name="nav.listTopo"/>
</s:a><br><br><br>

Détails<br>

<s:a action="member_details">
    <s:text name="nav.detailMember"/>
</s:a><br>
<s:a action="zone_details">
    <s:text name="nav.detailZone"/>
</s:a><br>

<s:a action="topo_details">
    <s:text name="nav.detailTopo"/>
</s:a><br>

</body>
</html>


