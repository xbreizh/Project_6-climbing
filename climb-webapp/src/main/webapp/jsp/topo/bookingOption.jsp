<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="#session.user.id">
    <td style="border: none;">
    <s:if test="#session.user.id == owner.id">

            <s:a action="topo_update" style="display:block;text-decoration:none;" >
                <button type="button" class="btn btn-info">Edit</button>
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