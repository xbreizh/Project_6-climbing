<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../../_include/header.jsp" %>
<div class="row">
<div class="col-md-2"></div>
<div class="col-md-6">
<h2>New Spot</h2>

<s:if test="#session.user">

    <div class="info">
        <p>
            After creating a Spot, you must provide some routes to complete the information.<br>
            Only the spots having at least a route will appear on the main map.
        </p>
    </div>
    <br><br>
    <a href="https://www.gps-coordinates.net/" class="btn btn-default" target="_blank">Get coordinates</a>
    <br><br>

    <s:form action="createSpot" method="POST">
        <s:select label="Country" list="%{countryList}" name="spot.country.id" listKey="key" headerKey="-1"
                  headerValue="-- Country --"/>
        <s:textfield label="City" name="spot.city" requiredLabel="true" placeholder="Type City Name"/>
        <s:select label="Climbing Type" list="climbingList" name="spot.type" placeholder="Type" headerKey="-1"
                  headerValue="-- Climbing Type --"
                  requiredLabel="true"/>
        <s:hidden name="spot.memberSpot.id" value="%{session.user.id}" label="Member:"/>
        <s:textfield label="Spot Name" name="spot.name" placeholder="Spot Name" requiredLabel="true"/>
        <s:textarea label="Latitude" name="spot.latitude" placeholder="Latitude"/>
        <s:textarea label="Longitude" name="spot.longitude" placeholder="Longitude"/>
        <s:textarea label="Description" name="spot.description" placeholder="Spot Description" requiredLabel="true"/>
        <s:submit class="btn btn-success" value="Create"/>
    </s:form>
    </div>
    <div class="col-md-2"></div>
    </div>
</s:if>
<s:else>
    Connect to add a spot<br><br>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
<%@include file="../../_include/footer.jsp" %>