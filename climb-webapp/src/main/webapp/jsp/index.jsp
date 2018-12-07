<%@ taglib prefix="s" uri="/struts-tags" %>

    <%@include file="_include/head.jsp" %>

    <%@include file="_include/navbar.jsp" %>
<div class="container-fluid">
    <div class="row ">

            <div class="col-lg-12 col-md-12 col-sm-12 sidebar-nav-fixed affix" id="skra">

                <div class="mapContainer">
                    <%@include file="/jsp/map/map_index.jsp" %>
                    <%@include file="/jsp/map/index_map_legend.jsp" %>
                </div>
                <div class="row">
                    <div class="col-2">
                        <button type="button" class="block" onclick="resizeElement()">Show / Hide Result</button>
                    </div>
                    <div class="col-2">
                         <%@include file="search/searchForm.jsp" %>
                    </div>
                </div>



            </div>
            <div class="hidden col-lg-6 col-md-12 col-sm-12 pull-right jumbotron" id="index_result">

                        <%@include file="spot/spotMapTable.jsp" %>
                        <%@include file="topo/topoMapTable.jsp" %>

                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

            </div>
    </div>



</div>
   <%-- <%@include file="_include/footer.jsp" %>--%>
</body>

</html>