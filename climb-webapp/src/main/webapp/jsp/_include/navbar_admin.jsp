<ul class="nav navbar-nav collapse navbar-collapse" id="myNavbar">

    <li>
        <s:a class="active" action="createSpot">
             New Spot
        </s:a>
    </li>
    <li>
        <s:a class="active" action="spot_list">
            Spots
        </s:a>
    </li>
    <li>
        <s:a class="active" action="topo_list">
            Topos
        </s:a>
    </li>
    <r:if test="#session.user.role=='superadmin'">
        <%@include file="navbar_superAdmin.jsp"%>
    </r:if>
    <li>
        <s:a class="active" action="mySpace">
            My Space
            <s:param name="id" >${session.user.id}</s:param>
        </s:a>
    </li>
    <%--<li>
        <s:a class="active" action="contactAdmin">
            Contact
            <s:param name="id" >${session.user.id}</s:param>
        </s:a>
    </li>--%>

</ul>

<ul class="nav navbar-nav navbar-right">

        <ul>
            <li>
            <span style="color:white;">Connected: <r:property value="#session.user.login"/>!</span>
            </li>
        </ul>
        <ul>
            <li>
                <a href="javascript: popupLogout()"><span class="glyphicon glyphicon-log-out"></span>Logout</a>
            </li>
        </ul>
</ul>

