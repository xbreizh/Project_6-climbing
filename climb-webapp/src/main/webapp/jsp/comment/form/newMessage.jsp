<%@ taglib prefix="s" uri="/struts-tags" %>
<h2>Comments</h2><h4></h4>


<s:form class="form-inline" action="createCommentSpot" method="POST">
    <s:hidden name="comment.spot.id" value="%{spot.id}"/>
    <s:hidden name="comment.memberComment.id" value="%{session.user.id}" label="Member:"/>
    <s:textarea name="comment.text" placeholder="New Comment" requiredLabel="true" onclick=""/>
    <s:submit class="btn btn-success" value="Comment"/>

</s:form>