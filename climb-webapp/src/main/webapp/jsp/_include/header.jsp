<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="r" uri="/struts-tags" %>

<%--<header>
    &lt;%&ndash;<%@ page contentType="text/html;charset=UTF-8" language="java" %>&ndash;%&gt;
        <link href="<s:url value="/css/style.css"/>" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Climb</title>

       &lt;%&ndash; <script>window.open("login","login", "width=200,height=200,scrollbars=no");
        </script>&ndash;%&gt;
   &lt;%&ndash; <r:if test="#session.user">
        Utilisateur connecté :
        <r:property value="#session.user.login"/>
       &lt;%&ndash; <s:property value="#session.member.nom"/>&ndash;%&gt;
        <br>
        <r:a action="logout">Déconnexion</r:a>
    </r:if>
    <r:else>
        <r:a action="login">Connexion</r:a>  |  <r:a action="member_new">Become Member</r:a>
    </r:else>&ndash;%&gt;
</header>
    <body>

    <div class="container">--%>
<%--<%@include file="navbar.jsp"%>--%>
<%@include file="head.jsp"%>
    <%@include file="navbar2.jsp"%>
<%--<nav>
    <s:a action="projet_list">
        <s:text name="nav.listProjet" />
    </s:a>

    <s:a action="projet_new">Créer un nouveau projet</s:a>
</nav>--%>

<s:actionerror/>
<s:actionmessage/>