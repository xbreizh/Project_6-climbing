<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<%@include file="../_include/head.jsp" %>

<body>

Liste de Spots
<br><br>


<s:a action="spot_new">Create</s:a><br><br>
<s:iterator value="listSpot">
    <ul>
        <li>Name: <s:property value="name"/></li>
        <li>Number of ways: <s:property value="nb_ways"/></li>
        <li>
            <s:a action="spot_detail">Details
                <s:param name="id" value="id"/>
            </s:a>
        </li>
    </ul>
</s:iterator>

</body>
</html>
