<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="_include/head.jsp"%>
</head>
<body>
<h1>Page d'erreur!</h1>
    <s:actionerror/>
<s:bean name="java.util.Date" var="now"/>
<s:text name="error.metadata">
    <s:param value="now" />
</s:text>
</body>
</html>
