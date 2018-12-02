<%@ taglib prefix="s" uri="/struts-tags" %>



<%@include file="../../_include/header.jsp" %>


<s:if test="session.user.id == spot.memberSpot.id || session.user.role == 'superadmin'">

    <h1><s:property value="%{spot.name}"/>- EDIT(Spot)</h1>

    <br><br>
    <a href="https://www.gps-coordinates.net/" class="btn btn-default" target="_blank">Get coordinates</a>
    <br><br>

    <s:form action="spot_update" method="POST">
        <s:hidden name="spot.id" value="%{spot.id}"/>
        <s:select list="%{countryList}" name="spot.country.id" listKey="key" headerKey="-1" headerValue="-- Country --" />
        <s:textfield name="spot.city" requiredLabel="true" placeholder="Type City Name"/>
        <s:select list="climbingList" name="spot.type" placeholder="Type" headerKey="-1" headerValue="-- Climbing Type --"
                  requiredLabel="true" />
        <s:textfield name="spot.memberSpot.id" />
        <s:textfield name="spot.name" placeholder="Type Spot Name" requiredLabel="true"/>
        <s:textarea name="spot.latitude" placeholder="Latitude" />
        <s:textarea name="spot.longitude" placeholder="Longitude" />
        <s:textarea name="spot.description" placeholder="Type Spot Description" requiredLabel="true"/>
        <s:hidden name="submit" placeholder="submit" value="true"/>
        <s:submit class="btn btn-warning" value="Update Spot"/>
    </s:form>

<br>
    <s:form action="spot_delete" method="POST">
    <s:textfield name="spot.id" />
        <s:submit class="btn btn-danger" value="Delete"/>
    </s:form>
</s:if>
<s:else>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
