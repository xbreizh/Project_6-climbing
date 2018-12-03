
<s:if test="%{topoList.size()>0}">
    <table class="table  table-hover" >
        <thead >
        <tr>
            <th></th>
            <th>Name </th>
            <th>Edition </th>
            <th>Author </th>
            <th>Published Year </th>
            <th>Description </th>
            <th>Creator</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="topoList">
            <tr>
                <td>

                    <s:a action="topo_detail" style="display:block;text-decoration:none;" >
                        <button type="button" class="btn btn-warning">Details</button>
                        <s:param name="id" value="id"/>
                    </s:a>

                </td>

                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="name" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="author"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="edition"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="publishedYear"/>
                    <s:param name="id" value="id"/>
                </s:a>
                </td>
                <td><s:a action="topo_detail" style="display:block;text-decoration:none;" >
                    <s:property value="description" escapeHtml="false"/>
                    <s:param name="id" value="id"/>
                </s:a>
                <td>


                <s:if test="#session.user.id == owner.id">
                    <s:a action="member_detail">
                        <s:param name="id" value="owner.id" />
                        <span style=" font-weight: bold;color: #ffae6e">You</span>
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
                    <td style="border: none;">
                        <s:if test="#session.user.id == owner.id">

                            <s:a action="topo_update" style="display:block;text-decoration:none;" >
                                <button type="button" class="btn btn-warning">Edit</button>
                                <s:param name="id" value="id"/>
                            </s:a>

                        </s:if>
                        <s:else>

                            <s:a action="topo_booking" style="display:block;text-decoration:none;" >
                                <button type="button" class="btn btn-success">Book it!</button>
                                <s:param name="id" value="id"/>
                            </s:a>
                        </s:else>
                    </td>
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
</s:if><s:else>
    No Topo Found!
</s:else>

<script type="text/javascript">
    function popupLogin() {
        window.open('login','popup','width=300,height=300,top=-800,left=800');
    }
</script>