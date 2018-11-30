<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../../_include/header.jsp" %>



            <h1 class="display-3">New Member</h1>


<s:form action="member_new" method="POST">
        <s:textfield name="member.login" placeholder="Login" requiredLabel="true"/>
    <s:textfield type="password" name="member.password" placeholder="Password" requiredLabel="true"/>
    <s:textfield type="password" name="passwordCheck" placeholder="Repeat Password" requiredLabel="true"/>
    <s:textfield type="email" name="member.email" placeholder="Email" requiredLabel="true"/>
    <s:textfield type="email" name="emailCheck" placeholder="Repeat Email" requiredLabel="true"/>
    <s:textarea name="member.description" placeholder="Description" requiredLabel="true"/>
    <s:submit class="btn btn-success" value="Create"/>

</s:form>
<%@include file="../../_include/footer.jsp" %>