<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/head.jsp" %>

<body>
<h1>Détails Utilisateur</h1>


<ul>
    <li>Id: <s:property value="id"/></li>
    <li>Login: <s:property value="member.login"/></li>
    <li>Description: <s:property value="member.description"/></li>
    <li>
        <s:a action="member_edit">Edit
            <s:param name="id" value="id"/>
        </s:a>
    </li>
    <li>
        <s:a action="member_delete">Delete
            <s:param name="id" value="id"/>
        </s:a>
    </li>
</ul>


</body>
</html>
