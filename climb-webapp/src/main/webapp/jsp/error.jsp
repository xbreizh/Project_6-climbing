<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="_include/header.jsp" %>


<h1>Page d'erreur!</h1>
    <s:actionerror/>
<s:bean name="java.util.Date" var="now"/>
<s:text name="error.metadata">
    <s:param value="now" />
</s:text>

<img src="http://66.media.tumblr.com/c07c4c7e4bfe716006120c2a301439e4/tumblr_nb5aygeEaR1try9yoo1_500.gif">
<%@include file="_include/footer.jsp" %>
