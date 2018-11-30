<%@ taglib prefix="s" uri="/struts-tags" %>


<table class="table table-editable table-bordered table-hover">
    <thead>
    <tr>
        <td>Login</td>
        <td>Datejoin</td>
        <td>Email</td>
        <td>Role</td>
        <td>Description</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><s:property value="member.login" /></td>
        <td><s:date name="member.datejoin" format = "dd/MM/yyyy"/></td>
        <td><s:property value="member.email" /></td>
        <td><s:property value="member.role" /></td>
        <td><s:property value="member.description" /></td>
    </tr>
    </tbody>
</table>




