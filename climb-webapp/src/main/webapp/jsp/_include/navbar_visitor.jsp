<%@ taglib prefix="s" uri="/struts-tags" %>




<ul class="nav navbar-nav collapse navbar-collapse" id="myNavbar">
    <li>
        <s:a class="active" action="topo_list">
            Topos
        </s:a>
    </li>
    <li>
        <s:a class="active" action="member_new">
            Create an Account
        </s:a>
    </li>
</ul>

<ul class="nav navbar-nav navbar-right">
        <ul>
            <li>
                <span style=" visibility: hidden;">spa</span>
            </li>
            <li>

                <a  style="color: white ; text-decoration: none; text-align: left" href="javascript: popupLogin()">
                    <span class="glyphicon glyphicon-log-out"></span>Connect<span style=" visibility: hidden;">spa</span>
                </a>
            </li>
            <li>
                <span style=" visibility: hidden;">spa</span>
            </li>
        </ul>

</ul>
