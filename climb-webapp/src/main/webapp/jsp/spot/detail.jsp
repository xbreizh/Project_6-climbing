<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>
<h1>Détails Zone</h1><br><br>
<s:a action="index" >Back to Menu</s:a><br><br>
<s:a action="spot_list" >Back to List</s:a>


<ul>
    <li>Id: <s:property value="id"/></li>
    <li>Name: <s:property value="spot.name"/></li>
    <li>Nb ways: <s:property value="spot.nb_ways"/></li>
    <li>Creator:
        <s:a action="member_detail">
            <s:param name="id" value="spot.creatorSpot.id"/>
            <s:property value="spot.creatorSpot.login"/>
        </s:a>
    </li>
    <li>
        <s:a action="spot_edit">Edit
            <s:param name="id" value="id"/>
        </s:a>
    </li>
    <li>
        <s:a action="spot_delete">Delete
            <s:param name="id" value="id"/>
        </s:a>
    </li>
</ul>


</body>
</html>
