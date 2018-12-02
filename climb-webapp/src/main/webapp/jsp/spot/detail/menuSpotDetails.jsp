<%@ taglib prefix="s" uri="/struts-tags" %>
<table  style="border:none">
    <tr>

        <th>
            <s:a href="#" rel="Details">
                <button type="button" class="btn btn-info">Details</button>
            </s:a>
        </th>
        <th>
            <s:a href="#" rel="Routes">
                <button type="button" class="btn btn-info">Routes</button>
            </s:a>
        </th>
        <th>
            <s:a href="#" rel="Topos">
                <button type="button" class="btn btn-info">Topos</button>
                <s:param name="id" value="id"/>
            </s:a>
        </th>
        <th>
            <s:a href="#" rel="Comments">
                <button type="button" class="btn btn-info">Comment</button>
                <s:param name="id" value="id"/>
            </s:a>
        </th>

    </tr>
</table>