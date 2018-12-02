<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<%@include file="menuSpotDetails.jsp" %>
<br><br>

<div>
    <div id="Details" style="display: block">
        <%@include file="spotDetails_table.jsp" %>
    </div>

    <div id="Routes" style="display: none">
        <%@include file="spotRoutes_table.jsp" %>
    </div>

    <div id="Topos" style="display: none">
        <%@include file="spotTopos_table.jsp" %>
    </div>

    <div id="Comments" style="display: none">
        <%@include file="spotComments_table.jsp" %>
    </div>
</div>


<script>
    $('a').on('click', function(){
        var target = $(this).attr('rel');
        $("#"+target).show().siblings("div").hide();
    });
</script>
</div>





