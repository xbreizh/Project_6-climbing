<%@ taglib prefix="s" uri="/struts-tags" %>



    <s:form action="member_update" method="POST">
    <s:hidden name="member.id" value="%{session.user.id}"  requiredLabel="true"/>
    <s:textfield name="member.login" placeholder="Login" requiredLabel="true"/>
    <s:textfield type="password" name="password" placeholder="Password"  value="******" requiredLabel="true"/>
    <s:textfield type="password" name="passwordCheck" placeholder="Repeat Password" value="******"  requiredLabel="true"/>
    <s:textfield type="email" name="member.email" placeholder="Email" requiredLabel="true"/>
    <s:textfield type="email" value="%{member.email}" placeholder="Confirm Email" requiredLabel="true"/>
    <s:textarea name="member.description" placeholder="Description" requiredLabel="true"/>
    <s:submit value="Update Profile"/>
</s:form>

