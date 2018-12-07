<%--
<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../_include/header.jsp" %>




<h2>Creation d'un comment</h2>
<r:property value="#session.user.id"/>
<s:property value="%{route.id}"/>
<s:if test="#session.user">
    Route: <s:property value="spot.route.name"/><br>
    <s:form action="createCommentRoute" method="POST">
        <s:hidden name="route.id" value="%{route.id}"/>
        <s:textfield name="comment.memberComment.id" value="%{session.user.id}" label="Member:"/>
        <s:textarea name="comment.text" value="Type Spot Name" requiredLabel="true"/>
        <s:submit value="Create"/>
    </s:form>

</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>


<%@include file="../_include/header.jsp" %>--%>
