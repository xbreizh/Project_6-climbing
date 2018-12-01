<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../../_include/header.jsp" %>

<s:if test="#session.user">
<br>
Login: <s:property value="#session.user.login"/><br>
Role: <s:property value="#session.user.role"/><br><br>

    <s:form action="member_update" method="POST">
    <s:textfield name="member.id" value="%{session.user.id}"  requiredLabel="true"/>
    <s:hidden name="member.login" value="#session.user.login" />
    <s:textfield type="password" name="password" placeholder="Password"  value="******" requiredLabel="true"/>
    <s:textfield type="password" name="passwordCheck" placeholder="Repeat Password" value="******"  requiredLabel="true"/>
    <s:textfield type="email" name="member.email" value="%{session.user.email}"  placeholder="Email" requiredLabel="true"/>
    <s:textarea name="member.description" value="%{session.user.description}" placeholder="Description" requiredLabel="true"/>
    <s:submit class="btn btn-success" value="Update Profile"/>
</s:form>


</s:if>
<s:else>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
</div>