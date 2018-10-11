<%@ taglib prefix="s" uri="/struts-tags" %>
<s:a action="index">
    <s:text name="home.welcome"/>
</s:a>
<table>
    <tr>
        <th>Creation</th>
        <th>Lists</th>
        <th>Detail</th>
    </tr>
    <tr>
        <td>
            <s:a action="member_new">
                <s:text name="nav.newMember"/>
            </s:a>
        </td>
        <td>
            <s:a action="member_list">
                <s:text name="nav.listMember"/>
            </s:a>
        </td>
        <td>
            <s:a action="member_detail">
                <s:text name="nav.detailMember"/>
            </s:a>
        </td>
    </tr>
    <tr>
        <td>
            <s:a action="choseContinent">
                <s:text name="nav.newSpot"/>
            </s:a>
        </td>
        <td>
            <s:a action="spot_list">
                <s:text name="nav.listSpot"/>
            </s:a>
        </td>
        <td>
            <s:a action="spot_detail">
                <s:text name="nav.detailSpot"/>
            </s:a>
        </td>
    </tr>
    <tr>

       <%-- <td>
            <s:a action="route_list">
                <s:text name="nav.listRoute"/>
            </s:a>
        </td>--%>
        <%--<td>
            <s:a action="zone_detail">
                <s:text name="nav.detailZone"/>
            </s:a>
        </td>--%>
    </tr>
</table>
