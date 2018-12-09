<%@ taglib prefix="s" uri="/struts-tags" %>

<div style="display: block; display: block" id="Spot-Comment">
    <br><br><br><br><br><br><br><br><br><br>
    <h3>Comments Spot (<s:property value="%{commentListSpot.size()}"/>)</h3><br><br>
    <s:if test="%{commentListSpot.size()>0}">
    <table class="table  table-hover">
        <thead>
        <tr>
            <th>Date</th>
            <th>Member</th>
            <th>Spot name</th>
            <th>Spot id</th>
            <th>Comment</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="commentListSpot">

            <tr>
                <td>
                    <s:property value="date" escapeHtml="false"/>
                </td>
                <td>
                    <s:if test="#session.user.id == memberComment.id">
                        <s:a action="member_detail">
                            <s:param name="id" value="memberComment.id"/>
                            <span style=" font-weight: bold;color: #ffae6e">You</span>
                        </s:a>
                    </s:if>
                    <s:else>
                        <s:a action="member_detail">
                            <s:param name="id" value="memberComment.id"/>
                            <s:property value="memberComment.login"/>
                        </s:a>
                    </s:else>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;">
                    <s:property value="spot.name" escapeHtml="false"/>
                    <s:param name="id" value="spot.id"/>
                </s:a>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;">
                    <s:property value="spot.id" escapeHtml="false"/>
                    <s:param name="id" value="spot.id"/>
                </s:a>
                </td>
                <td>
                    <s:property value="text" escapeHtml="false"/>
                </td>
                <td>
                    <s:a action="comment_delete" style="display:block;text-decoration:none;">
                        Remove
                        <s:param name="id" value="id"/>
                    </s:a>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    </s:if>
    <s:else>
    No Message on spots yet!
    </s:else>
