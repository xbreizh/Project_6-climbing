<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>


<s:form action="member_update" method="POST">
    <s:hidden name="member.id" value="%{id}"/>
    <s:textarea name="member.description" label="Description" requiredLabel="true" />
    <s:checkbox name="member.active" label="Active" />
    <s:submit value="OK"/>
</s:form>
<br>
<s:a action="member_delete">Delete
    <s:param name="member.id" value="%{id}"/>
</s:a>

</body>
</html>
