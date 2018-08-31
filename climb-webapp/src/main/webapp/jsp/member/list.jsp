<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/head.jsp" %>

<body>
<h1>Liste Membres</h1>

<s:iterator value="listMember">
    <ul>
        <li>Id: <s:property value="id"/></li>
        <li>Login: <s:property value="login"/></li>
        <li>Description: <s:property value="description"/></li>
        <li>
            <s:a action="member_detail">Details
                <s:param name="id" value="id"/>
            </s:a>
        </li>
    </ul>
</s:iterator>


</body>
</html>
