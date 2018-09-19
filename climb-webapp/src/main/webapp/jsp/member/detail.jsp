<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/head.jsp" %>

<body>
<h1>Détails Utilisateur</h1>
<s:a action="index" >Back to Menu</s:a><br><br>
<s:a action="member_list" >Back to List</s:a>

<ul>
    <li>Id: <s:property value="id"/></li>
    <li>Login: <s:property value="member.login"/></li>
    <li>Description: <s:property value="member.description"/></li>
    <li>Active: <s:property value="member.active"/></li>
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
