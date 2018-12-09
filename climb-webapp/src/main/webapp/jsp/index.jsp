<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="_include/head.jsp" %>

<%@include file="_include/navbar.jsp" %>
<div class="container-fluid index-container">
    <div class="row ">

        <div class="col-lg-12 col-md-12 col-sm-12 sidebar-nav-fixed affix" id="skra">

            <div class="row mapContainer">
                <%@include file="/jsp/map/map_index.jsp" %>

            </div>
            <div class="container-fluid ">
                <%@include file="/jsp/map/index_map_legend.jsp" %>
                <div class="row">
                    <div class="col-lg-6 col-centered">
                        <%@include file="search/searchForm.jsp" %>
                    </div>
                    <div id="btn-menu1" style="font-size: 30px;justify-content:center;
                        display:block; align-self:center; "
                         class="btn-menu1 justify-content-center col-lg-2 col-md-2">
                        <button type="button" class=" btn-primary"
                                onclick="resizeElement()">Show <s:property value="%{spotList.size()}"/> Spot<s:if
                                test="spotList.size() >1">s</s:if> <br>

                        </button>
                    </div>
                    <div id="btn-menu2" style="display:none; font-size: 30px;
                        justify-content:center; align-self:center; "
                         class=" justify-content-center col-lg-2 col-md-2">
                        <button type="button" class="btn-warning"
                                onclick="resizeElement()">Hide Result
                        </button>
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
                <%--<div></div>--%>
                <%@include file="topo/topoMapTable.jsp" %>
                <%@include file="route/routeMapTable.jsp" %>
            </div>

        </div>
    </div>

    <script>
        $('a').on('click', function () {
            var target = $(this).attr('rel');
            $("#" + target).show().siblings("div").hide();
        });
    </script>


    <%@include file="_include/footer.jsp" %>
