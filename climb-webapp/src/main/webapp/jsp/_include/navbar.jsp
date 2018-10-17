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
            <s:a action="searchByKeyword">
                SEARCH
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

        <td>
            <s:a action="topo_new">
                <s:text name="nav.newTopo"/>
            </s:a>
        </td>
        <td>
            <s:a action="topo_list">
                <s:text name="nav.listTopo"/>
            </s:a>
        </td>
    </tr>
</table>
