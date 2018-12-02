<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="spot.commentList.size() > 0">


        <table class="table table-hover">
    <thead>
    <s:iterator value="spot.commentList">
        <tr>
            <th>
                <s:property value="text"/>
            </th>
            <th>
                <s:property value="date"/>
            </th>
            <th>
                <s:a action="member_detail" style="display:block;text-decoration:none;" >
                    <s:property value="memberComment.login" escapeHtml="false"/>
                    <s:param name="id" value="spot.memberSpotid"/>
                </s:a>
            </th>
            <th>
                <s:a action="spot_comment_delete" style="display:block;text-decoration:none;" >
                    Remove
                    <s:param name="id" value="id"/>
                    <s:param name="spot.id" value="spot.id"/>
                </s:a>
            </th>
        </tr>
    </s:iterator>
    </thead>
    </table>
</s:if>
<s:else>
    <s:if test="#session.user">
    <h2> Be the first to comment! </h2>
    </s:if>
    <s:else>
        <h2> No Comment yet! </h2>
    </s:else>
</s:else>
<%--<a name="comments"></a>--%>
<h2>Comments</h2><h4><%--<a href="#top" >Top</a>--%></h4>

<%--<s:if test="#session.user">--%>
<s:form action="createCommentSpot" method="POST">
    <s:hidden name="comment.spot.id" value="%{spot.id}"/>
    <s:hidden name="comment.memberComment.id" value="%{session.user.id}" label="Member:"/>
    <s:textarea name="comment.text" placeholder="New Comment"  requiredLabel="true" onclick=""/>
    <s:submit value="New Comment"/>

</s:form>