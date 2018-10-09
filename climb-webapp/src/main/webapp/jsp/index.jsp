<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="_include/header.jsp" %>

<body>

<h1><s:text name="home.welcome"/></h1>

<s:a action="pwd_reset">
    Password Reset
</s:a><br><br>
<%--<s:a action="demo_ajax">
    Demo Ajax
</s:a><br><br>--%>
<s:a action="choseContinent">
    New Spot
</s:a>



</body>
</html>


