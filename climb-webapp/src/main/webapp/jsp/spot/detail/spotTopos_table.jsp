<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="Topos" ></div>
<br><br><br><br><br><br><br><br><br><br>

<h2>Topos</h2>
<s:if test="spot.topos.size() > 0">

    <s:if test="#session.user">
        <s:a action="topo_new">
            <button type="button" class="btn btn-info">New Topo</button>
        </s:a>
    </s:if>
    <br><br>


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
                <s:if test="#session.user.id">
                    <s:if test="#session.user.id != owner.id">
                        <td >
                            <s:a action="topo_booking" style="display:block;text-decoration:none;" >
                                <button type="button" class="btn btn-success">Book it!</button>
                                <s:param name="id" value="id"/>
                            </s:a>
                        </td>
                    </s:if>

                    <s:if test="#session.user.id == owner.id || session.user.role == 'superadmin'">
                        <td>
                            <s:a action="topo_update" style="display:block;text-decoration:none;" >
                                <button type="button" class="btn btn-warning">Edit</button>
                                <s:param name="id" value="id"/>
                            </s:a>
                        </td>
                        <td>
                            <s:form action="topo_delete" method="POST">
                                <s:hidden name="id" value="%{id}" />
                                <s:submit class="btn btn-danger" value="Delete"/>
                            </s:form>
                        </td>
                    </s:if>


                </s:if>
                <s:else>
                    <td>
                        <a href="javascript: popupLogin()">
                            <button type="button" class="btn btn-warning">Connect to Book!</button>
                        </a>
                    </td>
                </s:else>
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

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>