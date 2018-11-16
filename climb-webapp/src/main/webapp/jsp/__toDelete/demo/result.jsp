<%@ taglib prefix="s" uri="/struts-tags" %>

    <html>

    <%@include file="../../_include/header.jsp" %>

    <body>
    <h1>Struts 2 <%--<s:combobox> --%>example</h1>

        <h2>
        Favor fruit : <s:property value="member.login"/>
        </h2>

        <h2>
        Selected month : <s:property value="yourMonth"/>
        </h2>

        </body>
        </html>