<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../../_include/header.jsp" %>

<s:form action="pwd_reset" method="POST">
    <s:textfield name="member.login" placeholder="Login" requiredLabel="true"/>
    <s:textfield type="email" name="member.email" placeholder="Email" requiredLabel="true"/>
    <s:textfield type="password" name="member.password" placeholder="Password" requiredLabel="true"/>
    <s:textfield type="password" name="passwordCheck" placeholder="Repeat Password" requiredLabel="true"/>

    <s:submit class="btn btn-success" value="okay, go!"/>

</s:form>


