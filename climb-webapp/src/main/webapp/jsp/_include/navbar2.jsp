<%@ taglib prefix="s" uri="/struts-tags" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <s:a  class="navbar-brand" action="index">
                <s:text name="home.welcome"/>
            </s:a>
           <%-- <a class="navbar-brand" href="#">ClimbingWorld</a>--%>
        </div>
        <ul class="nav navbar-nav collapse navbar-collapse" id="myNavbar">
            <%--<li class="active"><a href="index2.html">Africa</a></li>--%>
            <li><s:a class="active" action="spot_list">
                Africa
               <s:param name="id">0</s:param>
            </s:a></li>
                <li><s:a class="active" action="spot_list">
                    America
                    <s:param name="id">1</s:param>
                </s:a></li> <li><s:a class="active" action="spot_list">
                Asia
                <s:param name="id">2</s:param>
            </s:a></li> <li><s:a class="active" action="spot_list">
                Europe
                <s:param name="id">3</s:param>
            </s:a></li> <li><s:a class="active" action="spot_list">
                Oceania
                <s:param name="id">4</s:param>
            </s:a></li>
            <%--<li><a href="#">America</a></li>
            <li><a href="index2.html">Asia</a></li>
            <li><a href="#">Europe</a></li>
            <li><a href="#">Oceania</a></li>--%>
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

                <%--<form name=popupform>
                    <input type="button" name="chooser" onClick="window.open('login','popup','width=250,height=200,top=100,left=100');" value="Login"><br>
                    <input type="text" name="choice" value=""/>
                </form>--%>
               <%-- <script onClick="window.open('login','popup','width=250,height=200,top=100,left=100');"></script>--%>
                    <script type="text/javascript">
                        function popupLogin() {
                            window.open('login','popup','width=250,height=200,top=100,left=100');
                        }
                    </script>

                <a href="javascript: popupLogin()"><button><span class="glyphicon glyphicon-log-in"></span> Login</button></a>

                    <%--<li>--%><%--<r:a action="login"><span class="glyphicon glyphicon-log-in"></span> Login</r:a>--%>
            </ul>

            </r:else>
        </ul>
       <%-- <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>--%>
    </div>
</nav>
