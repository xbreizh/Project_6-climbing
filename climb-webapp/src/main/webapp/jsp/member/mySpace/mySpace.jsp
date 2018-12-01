<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../../_include/header.jsp" %>



<s:if test="#session.user">
    <h1>My Space</h1>


<s:if test="#session.user.id == id">
        <%@include file="menuMySpace.jsp" %>
<div>
    <div id="MyProfile" style="display: block">
        <h2 style="display:inline">My Profile - </h2><h3 style="display:inline"></h3>
        <s:a class="active" action="member_update">Update</s:a>
            <%@include file="../profile.jsp" %>

    </div>
    <div id="MyBookings" style="display: none">
    <h2>My Bookings</h2>
    <%@include file="../../booking/bookingTable.jsp" %>
    </div>
    <div id="MySpots" style="display: none">
    <h2><a ></a>My Spots</h2>
    <%@include file="../../spot/spotTable.jsp" %>
    </div>
    <div id="MyTopos" style="display: none">
    <h2><a ></a>My Topos</h2>
    <%@include file="../../topo/topoTable.jsp" %>
    </div>
    <div id="MyRoutes" style="display: none">
    <h2><a ></a>My Routes</h2>
    <%@include file="../../route/routeTable.jsp" %>
    </div>
</div>




</s:if>
    <s:else><h2>There is an issue with your session, Get back to the index, then reconnect</h2>
        <s:a  class="navbar-brand" action="index">
            <s:text name="home.welcome"/>
        </s:a>

    </s:else>

</s:if>
<s:else><%@include file="../../_include/connectButton.jsp" %></s:else>

<script >
    $('a').on('click', function(){
        var target = $(this).attr('rel');
        $("#"+target).show().siblings("div").hide();
    });
</script>
</div>