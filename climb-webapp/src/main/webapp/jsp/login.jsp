<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="_include/head.jsp"%>
<s:form action="login">
    <s:textfield name="login" label="Identifiant" requiredLabel="true" />
    <s:password name="pwd" label="Mot de passe" requiredLabel="true" />

    <s:submit value="Connexion"  />

</s:form>
<%--<br>--%>




<s:a action="member_new">Become Member</s:a><br>
<s:a action="pwd_reset">Reset Password</s:a>
<%--
<script type="text/javascript">
    function refreshAndClose() {
        window.opener.location.reload(true);
        window.close();
    }
</script>
--%>

<%--
<input type='button' id='btn' value='Close' />--%>
</div>
</body>
</html>