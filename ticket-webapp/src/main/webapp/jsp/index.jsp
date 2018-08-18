<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <%@include file="_include/head.jsp"%>
</head>
<body>
<h1><s:text name="home.welcome"/></h1>

<s:a action="projet_list">
   <s:text name="nav.listProjet"/>
</s:a>
<br>
<s:a action="utilisateur_list">
    <s:text name="nav.listUtilisateur"/>
</s:a>
<footer>
<%@include file="_include/footer.jsp"%>
</footer>

</body>
</html>
