<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="spot.routeList.size() > 0">
    <img alt="mapRoute" src="http://vincent.boulas.free.fr/teamgrimptout/topos/ainsavoiehautesavoie/topo_malpas.gif">
    <h2>Routes</h2>


        <table class="table  table-hover">
            <thead>
            <tr>
                <th></th>
                <th>Name </th>
                <th>Height </th>
                <th>Grade</th>
                <th>Creator</th>
                <th>Comment(s)</th>
            </tr>
            </thead>
            <tbody>
    <s:iterator value="%{routeList}">
            <tr>
                <td>
                    <s:a action="route_detail" style="display:block;text-decoration:none;" >
                        <button type="button" class="btn btn-light">Details</button>
                        <s:param name="id" value="id"/>
                    </s:a>
                </td>
                <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="name" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                    </s:a>
                </td>
                <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="height" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                    </s:a>
                </td>
                <td><s:a action="route_detail" style="display:block;text-decoration:none;" >
                    <s:property value="grade" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="member_detail" style="display:block;text-decoration:none;" >
                    <s:property value="memberRoute.login" escapeHtml="false"/>
                    <s:param name="id" value="memberRoute.id"/>
                </s:a>
                </td>
                <td>
                    <a href="#" onclick="toggle_visibility('${id}');">
                        <button type="button" class="btn btn-primary">Comments</button>
                    </a>

                </td>
                <s:if test="session.user.role == 'superadmin' || session.user.id == route.memberRoute.id">
                    <td>
                        <s:form action="route_update" method="POST">
                            <s:textfield name="route" value="%{id}"  requiredLabel="true"/>
                            <s:submit class="btn btn-warning" value="Edit"/>
                        </s:form>
                    </td>
                    <td>
                        <s:form action="route_delete" method="POST">
                            <s:hidden name="route" value="%{id}"  requiredLabel="true"/>
                            <s:submit class="btn btn-danger" value="Delete"/>
                        </s:form>

                    </td>
                </s:if>
            </tr>
    <tr>
        <td  colspan="8">
            <div id="${id}" style="display: none">
                <s:form style="display: inline;" action="createCommentRoute" method="POST">
                    <s:hidden name="comment.route.id" value="%{id}"/>
                    <s:hidden name="comment.memberComment.id" value="%{session.user.id}" label="Member:"/>
                    <s:textarea name="comment.text" placeholder="New Comment"  requiredLabel="true" onclick=""/>
                    <s:submit class="btn btn-success" value="Comment"/>

                </s:form>
                <s:if test="%{commentList.size()>0}">
                    <s:a action="route_detail" style="display:block;text-decoration:none;" >
                        See <s:property value="%{commentList.size()}"/> comments
                        <s:param name="id" value="id"/>
                    </s:a>
                </s:if><s:else>
                Be the first to comment!
            </s:else>
            </div>
        </td>
    </tr>
    </s:iterator>
            </tbody>
        </table>

</s:if>
<s:else>
    <h2> No route yet for this Spot </h2>
</s:else>
<s:if test="#session.user">
    <s:a action="createRoute">
        <s:param name="id" value="id"/>
        <button type="button" class="btn btn-warning">New Route</button>
    </s:a>
</s:if>
<%--<table class="table  table-hover">
    <ul>

    <td><span onclick="Collapser(this)">month1</span>
        <tr>
            <td>article1</td>
            <td>article2</td>
            <td>etc...</td>
        </tr>
    </td>
    <td><span onclick="Collapser(this)">month2</span>
        <tr>
            <td>article1</td>
            <td>article2</td>
            <td>etc...</td>
        </tr>
    </td>
    </ul>
</table>--%>
<%--<script type="text/javascript">
    <!--
    function toggle_visibility(id) {
        var e = document.getElementById(id);
        if(e.style.display == 'none')
            e.style.display = 'block';
        else
            e.style.display = 'none';
    }
    //-->
</script>--%>
