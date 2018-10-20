<%@ taglib prefix="s" uri="/struts-tags" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">ClimbingWorld</a>
        </div>
        <ul class="nav navbar-nav collapse navbar-collapse" id="myNavbar">
            <li class="active"><a href="index2.html">Africa</a></li>
            <li><a href="#">America</a></li>
            <li><a href="index2.html">Asia</a></li>
            <li><a href="#">Europe</a></li>
            <li><a href="#">Oceania</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <r:if test="#session.user">
                <%-- <li><br>

                 </li>

                 &lt;%&ndash; <s:property value="#session.member.nom"/>&ndash;%&gt;--%>
                <ul>
                    <span style="color:white">Connected: <r:property value="#session.user.login"/>!</span>
                </ul><ul>
                <r:a action="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</r:a>
            </ul>
            </r:if>
            <r:else>
                <%--<r:a action="login">Connexion</r:a>  |  <r:a action="member_new">Become Member</r:a>--%>
                <ul>
                        <%--<span style="color:white">Connected: <r:property value="#session.user.login"/>!</span>--%>
                    <r:a action="member_new"><span style="color:white">Become Member</span></r:a>
                </ul><ul>
                    <%--<li>--%><r:a action="login"><span class="glyphicon glyphicon-log-in"></span> Login</r:a>
            </ul>

            </r:else>
        </ul>
       <%-- <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>--%>
    </div>
</nav>
