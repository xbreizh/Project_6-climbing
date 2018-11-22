<%--
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>
<h1>Liste Membres</h1>
<s:if test="#session.user">
<s:a action="index" >Back to Menu</s:a>
<s:iterator value="listMember">
    <ul>
        <li>Id: <s:property value="id"/></li>
        <li>Login: <s:property value="login"/></li>
        <li>Description: <s:property value="description"/></li>
        <li>Active: <s:property value="active"/></li>
        <li>
            <s:a action="member_detail">Details
                <s:param name="id" value="id"/>
            </s:a>
        </li>
        <li>
            <s:a action="member_delete">Delete
                <s:param name="id" value="id"/>
            </s:a>
        </li>
    </ul>
</s:iterator>
</s:if>
<s:else>
    Connect to add a topo<br><br>
    <%@include file="../_include/connectButton.jsp" %>
</s:else>

</body>
</html>
--%>
