<h3>My Stats</h3>

<table class="table table-striped table-hover">
    <thead>
    <tr>
        <td>Bookings</td>
        <td>Topos</td>
        <td>Spots</td>
        <td>Routes</td>
        <%-- <td>Comments</td>--%>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>
            <s:a href="#" rel="MyBookings">
                <s:property value="member.listBookings.size"/>
            </s:a>
        </td>
        <td>
            <s:a href="#" rel="MyTopos">
                <s:property value="member.topoListOwned.size"/>
            </s:a>
        </td>
        <td>
            <s:a href="#" rel="MySpots">
                <s:property value="member.spotList.size()"/>
            </s:a>
        </td>
        <td>
            <s:a href="#" rel="MyRoutes">
                <s:property value="member.routeList.size()"/>
            </s:a>
        </td>
        <%-- <td>
             <s:a href="#" rel="MyComments">
                 <s:property value="member.commentList.size()" />
             </s:a>
         </td>--%>
    </tr>
    </tbody>
</table>