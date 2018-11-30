<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/head.jsp" %>

<div class="col-sm-6 col-md-offset-3 text-center">
    <h2>Connect!</h2>

<s:form action="login" method="POST">
    <s:textfield name="login" placeholder="Login" requiredLabel="true"/>
    <s:textfield type="password" name="pwd" placeholder="Password" requiredLabel="true"/>
    <s:submit class="btn btn-success" value="Hop in!"/>

</s:form>
    <s:a action="pwd_reset" onclick="init('pwd_reset')">Reset Password</s:a><br>
    <s:a action="member_new" onclick="init('member_new')">Become Member</s:a>
</div>


<script type="text/javascript">
    function init( toto) {
        opener.location = toto;
        this.close();
    }
</script>

