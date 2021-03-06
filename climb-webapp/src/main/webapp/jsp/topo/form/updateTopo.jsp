<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../../_include/header.jsp" %>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-6">
<s:if test="#session.user.id == topo.owner.id || session.user.role == 'superadmin'">
<h2>Update</h2>

    <div class="info">
        <p>
            While updating the topo, take the time to adjust the keywords as they are most helpful in the search
            Is there any existing spot that can be linked to your topo?!!
        </p>
    </div>

    <s:if test="#session.user">
        <s:form action="topo_update" method="POST">
            <s:select list="countryList" name="topo.country.id" placeholder="Country" headerKey="-1"
                               value="topo.country.id" headerValue="-- Country --" requiredLabel="true" />
            <s:textfield label="Name" name="topo.name"  placeholder="Nom" requiredLabel="true"/>
            <s:textfield label="Edition" name="topo.edition"
                         placeholder="Edition(type No if not available)" requiredLabel="true"/>
            <s:textfield label="Author" name="topo.author" placeholder="Author" requiredLabel="true"/>
            <s:select label="Published Year" list="yearList" name="topo.publishedYear"
                      placeholder="Published Year" headerKey="-1"
                      value="topo.publishedYear" headerValue="-- Published Year --" requiredLabel="true" />
            <s:textarea label="Description" name="topo.description" placeholder="Description" requiredLabel="true"/>
            <s:textarea label="Keywords" name="topo.keywords"
                        placeholder="Keywords(add here the spotname to link with the main map)"
                        requiredLabel="true"/>
            <s:hidden name="topo.owner.id"  placeholder="owner" requiredLabel="true" />
            <s:hidden  name="topo.available" placeholder="available" />
            <s:hidden  name="topo.id" placeholder="topo id" />
            <s:hidden name="submit" placeholder="submit" value="true"/>
            <s:submit class="btn btn-warning" value="Update Topo"/>
        </s:form>
    </s:if>
    <s:else>
        <%@include file="../../_include/connectButton.jsp" %>
    </s:else>

    <br>
    <s:form action="topo_delete" method="POST">
        <s:hidden name="id" value="%{id}" />
        <s:submit class="btn btn-danger" value="Delete"/>
    </s:form>
    <s:a action="topo_detail" style="display:block;text-decoration:none;" >
        cancel
        <s:param name="id" value="topo.id"/>
    </s:a>
</s:if>
    </div>
    <div class="col-md-2"></div>
</div>
<s:else>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>

<%@include file="../../_include/footer.jsp" %>