<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../../_include/header.jsp" %>
<s:if test="#session.user.id == topo.owner.id || session.user.role == 'superadmin'">
<h2>Update</h2>

<s:if test="#session.user">
    <s:form action="topo_update" method="POST">
        <s:select list="countryList" name="topo.country.id" placeholder="Country" headerKey="-1"
                           value="topo.country.id" headerValue="-- Country --" requiredLabel="true" />
        <s:textfield label="Name" name="topo.name"  placeholder="Nom" requiredLabel="true"/>
        <s:textfield label="Edition" name="topo.edition" placeholder="Edition(type No if not available)" requiredLabel="true"/>
        <s:textfield label="Author" name="topo.author" placeholder="Author" requiredLabel="true"/>
        <s:select list="yearList" name="topo.publishedYear" placeholder="Published Year" headerKey="-1"
                  value="topo.publishedYear" headerValue="-- Published Year --" requiredLabel="true" />
        <s:textarea label="Description" name="topo.description" placeholder="Description" requiredLabel="true"/>
        <s:textarea name="topo.keywords" placeholder="Keywords(add here the spotname to link with the main map)"
                    requiredLabel="true"/>
        <s:hidden name="topo.owner.id"  placeholder="owner" requiredLabel="true" />
        <s:hidden  name="topo.available" placeholder="available" />
        <s:hidden  name="topo.id" placeholder="topo id" />
        <s:hidden name="submit" placeholder="submit" value="true"/>
        <s:submit class="btn btn-warning" value="Update Topo"/>
    </s:form>
</s:if>
<s:else>
    You must connect for that action!<br><br>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>

    <br>
    <s:form action="topo_delete" method="POST">
        <s:textfield name="topo.id" />
        <s:submit class="btn btn-danger" value="Delete"/>
    </s:form>
    <s:a action="topo_detail" style="display:block;text-decoration:none;" >
        cancel
        <s:param name="id" value="topo.id"/>
    </s:a>
</s:if>
<s:else>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>