<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="menu2">
<table   style="border:none">
    <tr>

        <th>
            <s:a href="#Details" rel="Details">
                <button type="button" class="btn btn-info">Details</button>
            </s:a>
        </th>
        <th>
            <s:a href="#Routes" rel="Routes">
                <button type="button" class="btn btn-info">Routes</button>
            </s:a>
        </th>
        <th>
            <s:a href="#Topos" rel="Topos">
                <button type="button" class="btn btn-info">Topos</button>
                <s:param name="id" value="id"/>
            </s:a>
        </th>
        <th>
            <s:a href="#Comments" rel="Comments">
                <button type="button" class="btn btn-info">Comment</button>
                <s:param name="id" value="id"/>
            </s:a>
        </th>

    </tr>
</table>
<s:a class="active" action="spot_list">
    - Back to Spot List
</s:a>
</div>