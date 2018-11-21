<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>


<h1>How to book a book!</h1>

start book: <s:property value="%{beginDate}" /><br>
end book: <s:property value="endDate" />
<s:if test="#session.user">
    <s:form action="submitBooking" method="POST">
    <li>Name: <s:property value="topo.name"/></li>
    <li>Edition: <s:property value="topo.edition"/></li>
    <li>Author: <s:property value="topo.author"/></li>
    <li>Published Year: <s:property value="topo.publishedYear"/></li>
    <li>Description: <s:property value="topo.description"/></li>
    <li>Available: <s:property value="topo.available"/></li>
        <li>Creator:
            <s:a action="member_detail">
                <s:param name="id" value="owner.id" />
                <s:property value="topo.owner.login"/>
            </s:a>
        </li>
        <s:submit value="OK"/>

    </s:form>

</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <s:a action="login">Connexion</s:a>
</s:else>