<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../../_include/header.jsp" %>

<s:if test="#session.user">


<h2><s:property value="%{spot.name}"/> - New Route:</h2>


<s:form action="createRoute" method="POST" theme="xhtml">
    <s:textfield type="text" name="route.name" placeholder="Name" requiredLabel="true"/>
    <s:select list="heightList" name="route.height" placeholder="Height" requiredLabel="true" headerKey="-1" headerValue="-- Height --"/>
    <s:select list="%{gradeList}"  name="route.grade"  listKey="key" placeholder="Grade" requiredLabel="true"
              headerKey="-1" headerValue="-- Grade --"/>
    <s:textarea type="text" name="route.description" placeholder="Description" requiredLabel="true"/>
    <s:textfield name="route.memberRoute.id" placeholder="Member" value="%{session.user.id}" requiredLabel="true" />
   <%-- <s:textfield name="route.spot.id" value="%{spotId}" placeholder="Spot" requiredLabel="true" />--%>
    <s:textfield name="route.spot.id" value="%{id}" />
   <%-- <s:textfield name="submit" value="true" />--%>
    <s:submit class="btn btn-success" value="Create"/>
</s:form>


    <br><br>
<s:a action="spot_detail">
    <s:param name="id" value="%{spot.id}"/>
    Back to List:
</s:a>

</s:if>
<s:else>
    Connect to add a Route<br><br>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
</div>