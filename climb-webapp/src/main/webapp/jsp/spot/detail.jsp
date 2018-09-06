<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/head.jsp" %>

<body>
<h1>Détails Zone</h1>


<ul>
    <li>Id: <s:property value="id"/></li>
    <li>Name: <s:property value="spot.name"/></li>
    <li>Nb ways: <s:property value="spot.nb_ways"/></li>
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
