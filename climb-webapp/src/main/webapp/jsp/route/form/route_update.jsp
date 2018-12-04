<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../../_include/header.jsp" %>
<s:if test="session.user.id == route.memberRoute.id || session.user.role == 'superadmin'">

    <h1><s:property value="%{route.name}"/>- EDIT(Route)</h1>

<s:form action="route_update" method="POST" theme="xhtml">
    <s:textfield name="route.id" value="%{route.id}"/>
    <s:textfield type="text" name="route.name" placeholder="Name" requiredLabel="true"/>
   <%-- <s:select list="%{heighList}" name="route.height"  listKey="key"  headerKey="-1" headerValue="-- Height --"/>--%>
    <s:select list="%{heightList}"  name="route.height"  listKey="key" placeholder="Height" requiredLabel="true"
              headerKey="-1" headerValue="-- Height --"/>
    <s:select list="%{gradeList}"  name="route.grade"  listKey="key" placeholder="Grade" requiredLabel="true"
              headerKey="-1" headerValue="-- Grade --"/>
    <s:textarea type="text" name="route.description" placeholder="Description" requiredLabel="true"/>
    <s:textfield name="route.memberRoute.id" placeholder="Member" value="%{session.user.id}" requiredLabel="true" />
    <s:textfield name="route.spot.id" value="%{route.spot.id}" placeholder="Spot" requiredLabel="true" />
    <s:textfield name="id" value="%{id}" />
    <s:hidden name="submit" placeholder="submit" value="true"/>
    <s:submit class="btn btn-warning" value="Update Route"/>
</s:form>
<br>

    <s:form action="route_delete" method="POST">
        <s:textfield name="route.id" />
        <s:submit class="btn btn-danger" value="Delete"/>
    </s:form>
    <s:a action="route_detail" style="display:block;text-decoration:none;" >
        cancel
        <s:param name="id" value="route.id"/>
    </s:a>

</s:if>
<s:else>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
