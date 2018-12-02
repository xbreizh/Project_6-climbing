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

            <r:if test="#session.user">
                <%@include file="navbar_admin.jsp"%>
            </r:if>
            <r:else>
                <%@include file="navbar_visitor.jsp"%>
            </r:else>

    </div>
</nav>
