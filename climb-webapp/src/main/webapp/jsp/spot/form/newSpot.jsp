<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../../_include/header.jsp" %>

<s:if test="#session.user">

    <h2>New Spot</h2>
    <p><div class="definition">
After creating a Spot, you must provide some routes to complete the information.<br>
Only the spots having at least a route will appear on the main map.
    </div></p>
    <br><br>
    <a href="https://www.gps-coordinates.net/" class="btn btn-default" target="_blank">Get coordinates</a>
    <br><br>

<s:form action="createSpot" method="POST">
    <s:select list="%{countryList}" name="spot.country.id" listKey="key" headerKey="-1" headerValue="-- Country --" />
    <s:textfield name="spot.city" requiredLabel="true" placeholder="Type City Name"/>
    <s:select list="climbingList" name="spot.type" placeholder="Type" headerKey="-1" headerValue="-- Climbing Type --"
              requiredLabel="true" />
    <s:textfield name="spot.memberSpot.id" value="%{session.user.id}" label="Member:"/>
    <s:textfield name="spot.name" placeholder="Spot Name" requiredLabel="true"/>
    <s:textarea name="spot.latitude" placeholder="Latitude" />
    <s:textarea name="spot.longitude" placeholder="Longitude" />
    <s:textarea name="spot.description" placeholder="Spot Description" requiredLabel="true"/>
    <s:submit class="btn btn-success" value="Create"/>
</s:form>

</s:if>
<s:else>
Connect to add a spot<br><br>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
</div>