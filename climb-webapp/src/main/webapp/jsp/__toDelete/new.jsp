<%--
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>

&lt;%&ndash;
<h2>Creation d'un comment</h2>
<r:property value="#session.user.id"/>
<s:property value="%{route.id}"/>
<s:if test="#session.user">
    Route: <s:property value="spot.route.name"/><br>
    <s:form action="createComment" method="POST">
        <s:textfield name="route.id" value="%{route.id}"/>
        <s:textfield name="route.memberComment.id" value="%{session.user.id}" label="Member:"/>
        <s:textarea name="route.comment.text" value="Type Spot Name" requiredLabel="true"/>
        <s:submit value="Create"/>
    </s:form>

</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>&ndash;%&gt;
</body>
</html>
--%>
