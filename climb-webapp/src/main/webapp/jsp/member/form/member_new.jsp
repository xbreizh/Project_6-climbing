<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../../_include/header.jsp" %>


<s:if test="!#session.user ">

            <h1 class="display-3">Register</h1>


<s:form action="member_new" method="POST">
    <s:textfield label="Login" name="member.login" placeholder="Login" requiredLabel="true"/>
    <s:textfield label="Password" type="password" name="member.password" placeholder="Password" requiredLabel="true"/>
    <s:textfield label="Repeat Password" type="password" name="passwordCheck" placeholder="Repeat Password" requiredLabel="true"/>
    <s:textfield label="Email" type="email" name="member.email" placeholder="Email" requiredLabel="true"/>
    <s:textfield label="Repeat Email" type="email" name="emailCheck" placeholder="Repeat Email" requiredLabel="true"/>
    <s:textarea label="description" name="member.description" placeholder="Description" requiredLabel="true"/>
    <s:submit class="btn btn-success" value="Create"/>

</s:form>
</s:if>
<s:else>
    <s:if test="#session.user.role =='superadmin'">
    <h2>You must be logged out for creating a new access!!</h2>
    </s:if>
    <img alt="Access forbidden!"style=" max-width: 50%; height: auto;" src=" https://previews.123rf.com/images/corund/corund1511/corund151100022/48297160-access-denied-sign-clipping-path-included.jpg">

</s:else>
<%@include file="../../_include/footer.jsp" %>