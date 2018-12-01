<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../../_include/head.jsp" %>

<body>
<s:actionerror/>
<s:actionmessage/>
<div class="container">

    <div class="col-sm-6 col-md-offset-3 text-center">
        <h2>Password Reset</h2>

<s:form action="pwd_reset" method="POST">
    <s:textfield name="login" placeholder="Login" requiredLabel="true"/>
    <s:textfield type="email" name="email" placeholder="Email" requiredLabel="true"/>
    <s:textfield type="password" name="password" placeholder="Password" requiredLabel="true"/>
    <s:textfield type="password" name="passwordCheck" placeholder="Repeat Password" requiredLabel="true"/>

    <s:submit class="btn btn-success" value="reset!"/>

</s:form>

    </div>
</div>
</body>
</html>
