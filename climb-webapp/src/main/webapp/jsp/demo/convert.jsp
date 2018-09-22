<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/head.jsp" %>


<body>
<%@ include file="../_include/header.jsp" %>

<h2>Démo - Converter</h2>

<s:form action="demo_convert">
    <s:textfield name="fraction" label="Fraction (format : #/#)" />

    <s:submit value="OK"/>
</s:form>
</body>
</html>