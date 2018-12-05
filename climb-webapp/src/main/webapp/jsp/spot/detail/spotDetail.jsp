<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<%@include file="menuSpotDetails.jsp" %>
<br><br>

<div>

        <%@include file="spotDetails_table.jsp" %>
    <br><br><br><br><br>   <br><br><br><br><br>


        <%@include file="spotRoutes_table.jsp" %>
    <br><br><br><br><br>   <br><br><br><br><br>


        <%@include file="spotTopos_table.jsp" %>
    </div><br><br><br><br><br>   <br><br><br><br><br>


        <%@include file="spotComments_table.jsp" %>
   <br><br><br><br><br>   <br><br><br><br><br>   <br><br><br><br><br>   <br><br><br><br><br>   <br><br><br><br><br>
<br><br><br><br><br>   <br><br><br><br><br>   <br><br><br><br><br>
</div>


<%--<script>
    $('a').on('click', function(){
        var target = $(this).attr('rel');
        $("#"+target).show().siblings("div").hide();
    });
</script>--%>
</div>





