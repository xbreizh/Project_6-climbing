<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../../_include/header.jsp" %>

<h2>Update profile</h2>
<s:if test="#session.user">
    <br>
    Login: <s:property value="%{member.login}"/><br>
    Role: <s:property value="%{member.role}"/><br><br>

    <s:form action="member_update" method="POST">
        <s:hidden name="member.id" value="%{member.id}" requiredLabel="true"/>
        <s:hidden name="member.login" value="%{member.login}"/>
        <s:textfield label="Password" type="password" name="password" placeholder="Password" value="******"
                     requiredLabel="true"/>
        <s:textfield label="Repeat Password" type="password" name="passwordCheck" placeholder="Repeat Password"
                     value="******" requiredLabel="true"/>
        <s:textfield label="Email" type="email" name="member.email" value="%{member.email}" placeholder="Email"
                     requiredLabel="true"/>
        <s:textarea label="Description" name="member.description" value="%{member.description}"
                    placeholder="Description" requiredLabel="true"/>
        <s:hidden name="submit" value="true" requiredLabel="true"/>
        <s:hidden name="idSession" value="%{session.user.id}" placeholder="Session id" requiredLabel="true"/>
        <s:submit class="btn btn-success" value="Update Profile"/>
    </s:form>


</s:if>
<s:else>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
</div>