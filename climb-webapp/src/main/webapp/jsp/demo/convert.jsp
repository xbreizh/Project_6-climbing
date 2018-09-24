<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h2>Démo - Converter</h2>

<%--<s:form action="demo_convert">
    <s:textfield name="fraction" label="Fraction (format : #/#)" />

    <s:submit value="OK"/>
</s:form>--%>
<s:form action="demo_convert">
    <s:textfield name="id" label="Member" />

    <s:submit value="OK"/>
</s:form>

<ul>
    <li>Id: <s:property value="member.id"/></li>
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