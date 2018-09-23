<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="_include/header.jsp" %>

<body>
<h1>Page d'erreur!</h1>
    <s:actionerror/>
<s:bean name="java.util.Date" var="now"/>
<s:text name="error.metadata">
    <s:param value="now" />
</s:text>
</body>
</html>
