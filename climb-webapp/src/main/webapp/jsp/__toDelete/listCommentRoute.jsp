
list comments

<%--
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1><s:property value="%{route.name}"/>- Comments (Route)</h1>
<br><br>
<s:a action="spot_detail">
    <s:param name="id" value="route.spot.id"/>
    Back to Spot
</s:a>
<br><br>
<s:if test="#session.user">
    <s:form action="createCommentRoute" method="POST">
        <s:hidden name="comment.route.id" value="%{route.id}"/>
        <s:hidden name="comment.memberComment.id" value="%{session.user.id}" label="Member:"/>
        <s:textarea name="comment.text" value="Type your comment"  requiredLabel="true" onclick=""/>
        <s:submit value="Create"/>
    </s:form>


</s:if>
<s:else>
    New Comment!
    <s:a action="login">Connect</s:a>
</s:else>
<s:iterator value="commentListRoute">
    <ul>
        <li>Login: <s:a action="member_detail">
            <s:param name="id" value="memberComment.id"/>
            <s:property value="memberComment.login"/>
        </s:a></li>
        <li>Date: <s:property value="date"/></li>
        <li><s:property value="text"/></li>
    </ul>
</s:iterator>

</body>
</html>
--%>
