<%@ taglib prefix="s" uri="/struts-tags" %>

    <%@include file="_include/head.jsp" %>

    <%@include file="_include/navbar.jsp" %>
<div  class="container-fluid index-container">
    <div class="row ">

            <div class="col-lg-12 col-md-12 col-sm-12 sidebar-nav-fixed affix" id="skra">

                <div class="row mapContainer">
                    <%@include file="/jsp/map/map_index.jsp" %>
                    <%@include file="/jsp/map/index_map_legend.jsp" %>
                </div>
                <div  class="container ">
                    <div  class="row">
                        <div class="col-lg-6 col-centered">
                             <%@include file="search/searchForm.jsp" %>
                        </div>
                        <div style="font-size: 30px;justify-content:center; align-self:center; "
                             class=" d-flex justify-content-center col-lg-2 col-md-2">
                            <button type="button" class="<%--vertical-btn--%> btn-primary"
                                    onclick="resizeElement()">Show / Hide Result</button>
                        </div>
                        <div class="col-lg-2 visible-lg">

                        </div>
                    </div>
                </div>



            </div>
            <div class="hidden col-lg-6 col-md-12 col-sm-12 pull-right jumbotron" id="index_result">
                        <%@include file="/jsp/map/menu_index_result.jsp" %>
                <div>
                        <%@include file="spot/spotMapTable.jsp" %>
                <div></div>
                        <%@include file="topo/topoMapTable.jsp" %>
            </div>

            </div>
    </div>

    <script >
        $('a').on('click', function(){
            var target = $(this).attr('rel');
            $("#"+target).show().siblings("div").hide();
        });
    </script>


    <%@include file="_include/footer.jsp" %>
