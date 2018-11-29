<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../_include/header.jsp" %>


<h1>My Space</h1>


<s:property value="#session.user.role"/>
<s:if test="#session.user">
<s:if test="#session.user.id == id">
        <%@include file="../topo/menuMySpace.jsp" %>
<div>
    <div id="MyProfile" style="display: block">
        <h2>My Profile</h2>
        <%@include file="../topo/profile.jsp" %>
    </div>
    <div id="MyBookings" style="display: none">
    <h2>My Bookings</h2>
    <%@include file="../topo/bookingTable.jsp" %>
    </div>
    <div id="MySpots" style="display: none">
    <h2><a ></a>My Spots</h2>
    <%@include file="../topo/spotTable.jsp" %>
    </div>
    <div id="MyTopos" style="display: none">
    <h2><a ></a>My Topos</h2>
    <%@include file="../topo/topoTable.jsp" %>
    </div>
    <div id="MyRoutes" style="display: none">
    <h2><a ></a>My Routes</h2>
    <%@include file="../topo/routeTable.jsp" %>
    </div>
</div>




</s:if>
    <s:else>There is an issue with your session, please log off then reconnect</s:else>

</s:if>


<script >
    $('a').on('click', function(){
        var target = $(this).attr('rel');
        $("#"+target).show().siblings("div").hide();
    });
</script>
