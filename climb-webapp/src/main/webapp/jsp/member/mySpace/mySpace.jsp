<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../../_include/header.jsp" %>



<s:if test="#session.user">
    <h1>My Space</h1>
    <br><br>

<s:if test="#session.user.id == id">

        <%@include file="menuMySpace.jsp" %>

    <br><br>
<div>
    <div id="MyProfile" style="display: block">
        <h2 style="display:inline">My Profile - </h2><h3 style="display:inline"></h3>
        <s:form action="member_update" method="POST">
            <s:hidden name="member" value="%{id}"  requiredLabel="true"/>
            <s:submit class="btn btn-warning" value="Update"/>
        </s:form>
            <%@include file="myProfile.jsp" %>

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
<%--    <h2><a ></a>My Comments</h2>
    <%@include file="../../route/routeTable.jsp" %>--%>
</div>
</div>




</s:if>
    <s:else><h2>There is an issue with your session </h2>
        <s:a  class="navbar-brand" action="mySpace">
            <s:param name="id" value="#session.user.id"></s:param>
            <button type="button" class="btn btn-info">Refresh</button>
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