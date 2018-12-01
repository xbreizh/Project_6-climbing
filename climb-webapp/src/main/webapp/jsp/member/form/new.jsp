<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../../_include/header.jsp" %>


<s:if test="!#session.user">

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
</s:if>
<s:else>

    <img alt="Access forbidden!"style=" max-width: 50%; height: auto;" src=" https://previews.123rf.com/images/corund/corund1511/corund151100022/48297160-access-denied-sign-clipping-path-included.jpg">

</s:else>
<%@include file="../../_include/footer.jsp" %>