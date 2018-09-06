<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="_include/head.jsp" %>

<body>

<%@include file="_include/header.jsp"%>
<h1><s:text name="home.welcome"/></h1>


Création<br>
<s:a action="member_new">
    <s:text name="nav.newMember"/>
</s:a><br>
<s:a action="spot_new">
    <s:text name="nav.newSpot"/>
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
<s:a action="spot_list">
    <s:text name="nav.listSpot"/>
</s:a><br><br><br>

Détails<br>

<s:a action="member_detail">
    <s:text name="nav.detailMember"/>
</s:a><br>
<s:a action="zone_detail">
    <s:text name="nav.detailZone"/>
</s:a><br>

<s:a action="spot_detail">
    <s:text name="nav.detailSpot"/>
</s:a><br>

</body>
</html>


