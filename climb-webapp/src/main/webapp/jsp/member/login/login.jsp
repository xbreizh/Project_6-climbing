<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../../_include/head.jsp" %>

<body>
<s:actionerror/>
<s:actionmessage/>
<div class="container">

<div class="col-sm-6 col-md-offset-3 text-center">
    <h2>Connect!</h2>

<s:form action="login" method="POST">
    <s:textfield name="login" placeholder="Login" requiredLabel="true"/>
    <s:textfield type="password" name="password" placeholder="Password" requiredLabel="true"/>

    <s:submit class="btn btn-success" value="Hop in!"/>

</s:form>
    <s:a class="active" action="pwd_reset">Reset Password</s:a><br>
    <s:a action="member_new" onclick="init('member_new')">Become Member</s:a>
</div>


<script type="text/javascript">
    function init( toto) {
        opener.location = toto;
        this.close();
    }
</script>

</div>
</body>
</html>
