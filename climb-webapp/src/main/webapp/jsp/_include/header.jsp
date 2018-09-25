<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="r" uri="/struts-tags" %>

<header>
    <%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
    <title>Climb</title>
    <r:if test="#session.user">
        Utilisateur connecté :
        <r:property value="#session.user.login"/>
       <%-- <s:property value="#session.member.nom"/>--%>
        <br>
        <r:a action="logout">Déconnexion</r:a>
    </r:if>
    <r:else>
        <r:a action="login">Connexion</r:a>
    </r:else>
</header>
<%@include file="navbar.jsp"%>
<%--<nav>
    <s:a action="projet_list">
        <s:text name="nav.listProjet" />
    </s:a>

    <s:a action="projet_new">Créer un nouveau projet</s:a>
</nav>--%>

<s:actionerror/>
<s:actionmessage/>