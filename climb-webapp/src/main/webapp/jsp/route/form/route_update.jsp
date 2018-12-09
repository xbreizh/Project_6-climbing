<%@ taglib prefix="s" uri="/struts-tags" %>


<%@include file="../../_include/header.jsp" %>
<s:if test="session.user.id == route.memberRoute.id || session.user.role == 'superadmin'">

    <h1><s:property value="%{route.name}"/>- EDIT(Route)</h1>

    <s:form action="route_update" method="POST" theme="xhtml">
        <s:hidden name="route.id" value="%{route.id}"/>
        <s:textfield label="Name" type="text" name="route.name" placeholder="Name" requiredLabel="true"/>
        <s:select label="Height" list="%{heightList}" name="route.height" listKey="key" placeholder="Height"
                  requiredLabel="true"
                  headerKey="-1" headerValue="-- Height --"/>
        <s:select label="Grade" list="%{gradeList}" name="route.grade" listKey="key" placeholder="Grade"
                  requiredLabel="true"
                  headerKey="-1" headerValue="-- Grade --"/>
        <s:textarea label="Description" type="text" name="route.description" placeholder="Description"
                    requiredLabel="true"/>
        <s:textfield name="route.memberRoute.id" placeholder="Member" value="%{session.user.id}" requiredLabel="true"/>
        <s:textfield name="route.spot.id" value="%{route.spot.id}" placeholder="Spot" requiredLabel="true"/>
        <s:textfield name="submit" placeholder="submit" value="true"/>
        <s:submit class="btn btn-warning" value="Update Route"/>
    </s:form>
    <br>

    <s:form action="route_delete" method="POST">
        <s:hidden name="route.id"/>
        <s:submit class="btn btn-danger" value="Delete"/>
    </s:form>
    <s:a action="route_detail" style="display:block;text-decoration:none;">
        cancel
        <s:param name="id" value="route.id"/>
    </s:a>

</s:if>
<s:else>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
