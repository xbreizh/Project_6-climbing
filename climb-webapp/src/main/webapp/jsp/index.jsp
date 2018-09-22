<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="_include/head.jsp" %>

<body>

<%@include file="_include/header.jsp"%>
<h1><s:text name="home.welcome"/></h1>

<s:a action="pwd_reset">
    Password Reset
</s:a><br><br>
<s:a action="demo_ajax">
    Demo Ajax
</s:a><br><br>
<s:a action="demo_convert">
    Demo Convert
</s:a>



</body>
</html>


