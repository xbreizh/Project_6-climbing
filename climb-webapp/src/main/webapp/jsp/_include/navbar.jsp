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
        </div>
        <ul class="nav navbar-nav collapse navbar-collapse" id="myNavbar">
            <li><s:a class="active" action="spot_list">
                Africa
                <s:param name="continent">Africa</s:param>
            </s:a></li>
                <li><s:a class="active" action="spot_list">
                    America
                    <s:param name="continent">America</s:param>
                </s:a></li> <li><s:a class="active" action="spot_list">
                Asia
                <s:param name="continent">Asia</s:param>
            </s:a></li> <li><s:a class="active" action="spot_list">
                Europe
                <s:param name="continent">Europe</s:param>
            </s:a></li> <li><s:a class="active" action="spot_list">
                Oceania
                <s:param name="continent">Oceania</s:param>
            </s:a></li>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <r:if test="#session.user">
                <ul>
                    <span style="color:white">Connected: <r:property value="#session.user.login"/>!</span>
                </ul><ul>
                <r:a action="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</r:a>
            </ul>
            </r:if>
            <r:else>
                <ul>
                    <li> </li>
                    <li>
                    <script type="text/javascript">
                        function popupLogin() {
                            window.open('login','popup','width=250,height=300,top=100,left=100');
                        }
                    </script>
                <a  style="color: white ; text-decoration: none; text-align: left" href="javascript: popupLogin()"><span class="glyphicon glyphicon-log-out"></span>Connect<span style=" visibility: hidden;">spa</span></a>
                    </li>
                    <li> </li>
            </ul>

            </r:else>
        </ul>
    </div>
</nav>
