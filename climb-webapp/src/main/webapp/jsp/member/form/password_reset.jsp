<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>


<h2>Password Reset</h2>

<s:form action="pwd_reset" method="POST">
    <s:textfield type="text" name="login" label="Login" requiredLabel="true"/>
    <s:textfield type="text" name="email" label="Email" requiredLabel="true"/>
    <s:password name="password" label="Password" requiredLabel="true" />
    <s:password name="passwordCheck" label="Password" requiredLabel="true" />
    <s:submit value="Reset"/>
</s:form>
<br>
<r:a action="member_new">Become Member</r:a>
</body>
</html>