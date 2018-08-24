<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@include file="_include/header.jsp"%>
<h1><s:text name="home.welcome"/></h1>


<s:a action="utilisateur_list">
    <s:text name="nav.listUtilisateur"/>
</s:a>
<footer>
<%@include file="_include/footer.jsp"%>
</footer>

</body>
</html>
