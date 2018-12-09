<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>
<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-6">

        <s:if test="session.user.id == spot.memberSpot.id || session.user.role == 'superadmin'">

            <h1><s:property value="%{spot.name}"/>- EDIT(Spot)</h1>
            <div class="info">
                <p>
                    While updating the spot, take the time to adjust the keywords as they are most helpful in the search
                </p>
            </div>
            <br><br>
            <a href="https://www.gps-coordinates.net/" class="btn btn-default" target="_blank">Get coordinates</a>
            <br><br>

            <s:form action="spot_update" method="POST">
                <s:hidden name="spot.id" value="%{spot.id}"/>
                <s:select label="Country" list="%{countryList}" name="spot.country.id" listKey="key" headerKey="-1"
                          headerValue="-- Country --"/>
                <s:textfield label="City" name="spot.city" requiredLabel="true" placeholder="Type City Name"/>
                <s:select label="Climbing Type" list="climbingList" name="spot.type" placeholder="Type" headerKey="-1"
                          headerValue="-- Climbing Type --"
                          requiredLabel="true"/>
                <s:hidden name="spot.memberSpot.id"/>
                <s:textfield label="Spot Name" name="spot.name" placeholder="Type Spot Name" requiredLabel="true"/>
                <s:textarea label="Latitude" name="spot.latitude" placeholder="Latitude"/>
                <s:textarea label="Longitude" name="spot.longitude" placeholder="Longitude"/>
                <s:textarea label="Description" name="spot.description" placeholder="Type Spot Description"
                            requiredLabel="true"/>
                <s:hidden name="submit" placeholder="submit" value="true"/>
                <s:submit class="btn btn-warning" value="Update Spot"/>
            </s:form>

            <br>
            <s:form action="spot_delete" method="POST">
                <s:hidden name="spot.id"/>
                <s:submit class="btn btn-danger" value="Delete"/>
            </s:form>
            <s:a action="spot_detail" style="display:block;text-decoration:none;">
                cancel
                <s:param name="id" value="spot.id"/>
            </s:a>
        </s:if>
    </div>
    <div class="col-md-2"></div>
</div>
<s:else>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
<%@include file="../../_include/header.jsp" %>