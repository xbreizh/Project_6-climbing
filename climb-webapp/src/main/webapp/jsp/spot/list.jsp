<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1>Liste de Spots</h1>
<br><br>


<s:a action="spot_new">Create</s:a><br><br>
<s:a action="index" >Back to Menu</s:a>
<s:iterator value="listSpot">
    <ul>
        <li>Name: <s:property value="name"/></li>
        <li>Number of ways: <s:property value="nb_ways"/></li>
        <li>Creator:
            <s:a action="member_detail">
                <s:param name="id" value="creatorSpot.id"/>
                <s:property value="creatorSpot.login"/>
            </s:a>
        </li>
        <li>
            <s:a action="spot_detail">Details
                <s:param name="id" value="id"/>
            </s:a>
        </li>
    </ul>
</s:iterator>

</body>
</html>
