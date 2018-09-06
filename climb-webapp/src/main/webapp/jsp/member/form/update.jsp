<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/head.jsp" %>

<body>

<s:form action="member_update" method="POST">
    <%--Id: <s:property value="member.id"/><br>--%>
    id: <s:property value="%{id}"/>
    <s:hidden name="member.id" value="%{id}"/>
    <s:password name="member.password" label="Password" requiredLabel="true"/>
    <s:textarea name="member.description" label="Description" requiredLabel="true"/>
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="member_delete">Delete
    <s:param name="member.id" value="%{id}"/>
</s:a>

</body>
</html>
