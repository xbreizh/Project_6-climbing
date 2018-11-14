<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="_include/head.jsp" %>
    <div class="row text-white">
        <div class="col-sm-6 col-md-offset-3 text-center">
            <h1 class="display-3">Member Creation</h1>
            <div class="info-form">

            <s:form class="justify-content-center" action="login">
                <div class="form-group">
                    <label class="sr-only">Login</label>
                    <input name="login" type="text" class="form-control" placeholder="Login">
                </div>
                <div class="form-group">
                    <label class="sr-only">Name</label>
                    <input name="pwd" type="password" class="form-control" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-success">okay, go!</button>
   <%-- <s:textfield name="login" placeholder="Login" requiredLabel="true" />
    <s:password name="pwd" placeholder="Password" requiredLabel="true" />

    <s:submit class="btn btn-primary" value="Connexion"  />--%>

            </s:form>

<%--<br>--%>

<%--    <p>
        <a href="javascript: init()"><button>Close</button></a>

    </p>--%>

</div>
<%--
<script type="text/javascript">
    function init( action) {
        /*opener.location.reload();*/
        opener.location=action;
        this.close();
        //close();
    }
</script>




<s:a action="member_new" onclick="init('member_new')">Become Member</s:a><br>
<s:a action="pwd_reset" onclick="init('pwd_reset')">Reset Password</s:a>--%>
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
    </div>


<%@include file="_include/footer.jsp" %>