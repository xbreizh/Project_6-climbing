<%@ taglib prefix="s" uri="/struts-tags" %>

    <%@include file="_include/head.jsp" %>

    <%@include file="_include/navbar.jsp" %>
<div <%--style="padding-top: 3%;"--%> class="container-fluid main-container">
    <div class="row ">

            <div class="col-lg-12 col-md-12 col-sm-12 sidebar-nav-fixed affix" id="skra">

                <div class="row mapContainer">
                    <%@include file="/jsp/map/map_index.jsp" %>
                    <%@include file="/jsp/map/index_map_legend.jsp" %>
                </div>
                <div style="background: cadetblue" class="container">
                    <div style="background: cadetblue" class="row">
                        <div  class="col-lg-4 col-md-2">
                             <%@include file="search/searchForm.jsp" %>
                        </div>
                        <div class="col-lg-4 col-md-2">
                            <button type="button" class="<%--vertical-btn--%> btn-primary"
                                    onclick="resizeElement()">Show / Hide Result</button>
                        </div>
                        <div class="col-lg-4 col-md-2">

                        </div>
                    </div>
                </div>



            </div>
            <div class="hidden col-lg-6 col-md-12 col-sm-12 pull-right jumbotron" id="index_result">

                        <%@include file="spot/spotMapTable.jsp" %>
                        <%@include file="topo/topoMapTable.jsp" %>


            </div>
    </div>

        <style>



        </style>


    <%@include file="_include/footer.jsp" %>
