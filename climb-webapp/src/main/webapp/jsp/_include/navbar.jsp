<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">

        <div class="navbar-header">
            <button type="button" class="col-sm-2  navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="navbar-brand">
                <s:a  action="index">
                    <s:text name="home.welcome"/>
                </s:a>
            </div>
        </div>

            <r:if test="#session.user">
                <%@include file="navbar_admin.jsp"%>
            </r:if>
            <r:else>
                <%@include file="navbar_visitor.jsp"%>
            </r:else>
    </div>

</nav>
