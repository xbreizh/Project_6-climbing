<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../../_include/header.jsp" %>


<h1>New Spot for <s:property value="%{c.continent}"/></h1>
<br><br>
<s:if test="#session.user">

<s:form action="createSpot" method="POST">
    <s:select list="%{countryList}" name="spot.country.id" listKey="key" headerKey="-1" headerValue="-- Country --" />
    <s:textfield name="spot.city" requiredLabel="true" placeholder="Type City Name"/>
    <s:select list="climbingList" name="spot.type" placeholder="Type" headerKey="-1" headerValue="-- Climbing Type --"
              requiredLabel="true" />
    <s:hidden name="spot.memberSpot.id" value="%{session.user.id}" label="Member:"/>
    <s:textfield name="spot.name" placeholder="Type Spot Name" requiredLabel="true"/>
    <s:textarea name="spot.latitude" placeholder="Latitude" />
    <s:textarea name="spot.longitude" placeholder="Longitude" /><a href="https://www.gps-coordinates.net/" target="_blank">Get coordinates</a>
    <s:textarea name="spot.description" placeholder="Type Spot Description" requiredLabel="true"/>
    <s:submit class="btn btn-success" value="Create"/>
</s:form>

</s:if>
<s:else>
Connect to add a spot<br><br>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>