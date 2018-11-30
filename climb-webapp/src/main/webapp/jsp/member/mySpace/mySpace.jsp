<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../../_include/header.jsp" %>


<s:property value="#session.user.role"/>
<s:if test="#session.user">
    <h1>My Space</h1>


<s:if test="#session.user.id == id">
        <%@include file="menuMySpace.jsp" %>
<div>
    <div id="MyProfile" style="display: block">
        <h2 style="display:inline">My Profile - </h2><h4 style="display:inline"><s:a href="#" rel="editProfile">Update</s:a>
        <%@include file="../profile.jsp" %>
    </div>
    <div id="editProfile" style="display: none">
        <%@include file="../form/profileForm.jsp" %>
        <s:a href="#" rel="MyProfile">Cancel</s:a>
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
    <s:else><h2>There is an issue with your session, please log off then reconnect</h2></s:else>

</s:if>
<s:else><h2>You need to connect for accessing this page!</h2></s:else>

<script >
    $('a').on('click', function(){
        var target = $(this).attr('rel');
        $("#"+target).show().siblings("div").hide();
    });
</script>
