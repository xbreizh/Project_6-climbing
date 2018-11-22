<%--
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1><s:property value="%{spot.name}"/>- Comments(Spot)</h1>
<br><br>
<s:a action="spot_detail">
    <s:param name="id" value="spot.id"/>
    Back to Spot
</s:a>
<br><br>
<s:if test="#session.user">
    <s:form action="createCommentSpot" method="POST">
        <s:textarea name="comment.spot.id" value="%{spot.id}"/>
        <s:textarea name="comment.memberComment.id" value="%{session.user.id}" label="Member:"/>
        <s:textarea name="comment.text" value="Type your comment" label="Date" requiredLabel="true" onclick=""/>
        <s:textarea name="comment.date" value="%{new Date()}"/>
        <s:submit value="Create"/>
    </s:form>


</s:if>
<s:else>
    New Comment!
    <s:a action="login">Connect</s:a>
</s:else>
<s:iterator value="commentListSpot">
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
