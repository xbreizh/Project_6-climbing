<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="spot.topos.size() > 0">
    <img alt="mapRoute" src="https://misanimales.com/wp-content/uploads/2018/02/topo-caracteristicas.jpg">
    <h2>Topos</h2>


    <table class="table  table-hover">
        <thead>
        <tr>
            <th>Name </th>
            <th>Author </th>
            <th>edition</th>
            <th>Published year</th>
            <th>Description</th>
            <th>Owner</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{spot.topos}">
            <tr>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="name" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="author" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="edition" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="publishedYear" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="spot_detail" style="display:block;text-decoration:none;" >
                    <s:property value="description" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td>
                    <s:if test="#session.user.id == owner.id">
                        <s:a action="member_detail">
                            <s:param name="id" value="owner.id" />
                            <span style=" text-decoration:none; font-weight: bold;color: #ffae6e">You</span>
                        </s:a>
                    </s:if>
                    <s:else>
                        <s:a action="member_detail">
                            <s:param name="id" value="owner.id" />
                            <s:property value="owner.login"/>
                        </s:a>
                    </s:else>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

</s:if>
<s:else>
    <h2> That spot hasn't been added yet to any topo </h2>
    <s:a action="topo_list">
        <button type="button" class="btn btn-success">Add it!</button>
    </s:a>
</s:else>

