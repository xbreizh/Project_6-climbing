<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../../_include/header.jsp" %>


<h2>update</h2>

<s:if test="#session.user">
    <s:form action="topo_update" method="POST">
        <s:select list="countryList" name="topo.country.id" placeholder="Country" headerKey="-1"
                           value="topo.country.id" headerValue="-- Country --" requiredLabel="true" />
        <s:textfield label="Name" name="topo.name"  placeholder="Nom" requiredLabel="true"/>
        <s:textfield label="Edition" name="topo.edition" placeholder="Edition" requiredLabel="true"/>
        <s:textfield label="Author" name="topo.author" placeholder="Author" requiredLabel="true"/>
        <s:select list="yearList" name="topo.publishedYear" placeholder="Published Year" headerKey="-1"
                  value="topo.publishedYear" headerValue="-- Published Year --" requiredLabel="true" />
        <s:textarea label="Description" name="topo.description" placeholder="Description" requiredLabel="true"/>
        <s:textarea name="topo.keywords" placeholder="Keywords(add here the spotname to link with the main map)"
                    requiredLabel="true"/>
        <s:textarea name="topo.owner.id"  placeholder="owner" requiredLabel="true" />
        <s:textarea  name="topo.available" placeholder="available" />
        <s:textarea  name="topo.id" placeholder="topo id" />
        <s:textfield name="submit" placeholder="submit" value="true"/>
        <s:submit value="OK"/>
    </s:form>
</s:if>
<s:else>
    You must connect for that action!<br><br>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
