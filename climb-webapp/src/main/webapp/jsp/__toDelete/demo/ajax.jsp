<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>
<%--<h2>Démo - AJAX</h2>--%>

<%--<s:form action="resultAction" namespace="/">

    <h2>
        <s:combobox label="Pick a Member"
                    headerKey="-1" headerValue="--- Select ---"
                    list="listMember"
                    name="member"  />
    </h2>

    <h2>
        <s:combobox label="Select a month"
                    headerKey="-1" headerValue="--- Select ---"
                    list="#{'1':'Jan', '2':'Feb', '3':'Mar', '4':'Apr'}"
                    name="yourMonth" />
    </h2>

    <s:submit value="submit" name="submit" />

</s:form>
<h2>
    Login : <s:property value="member."/>
</h2>

<h2>
    Description : <s:property value="member.login"/>
</h2>--%>

</body>
</html>