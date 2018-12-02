<%--
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1><s:property value="continent"/></h1>
<br><br>

<br><br>
Country: <s:property value="%{country}"/><br>
<s:form class="form-group" action="spot_list">
    <s:select class="form-control" id="selectCountry" name="country" value="%{country}"
              headerKey="" headerValue="--Select Country--"
              list="countryList"
              onchange="this.form.submit()"
    /><br><br>

    <s:hidden name="continent" value="%{continent}" />

</s:form>
<s:if test="%{c!=null}">
    <s:if test="spotList.size()>0">
    <s:form class="form-group" action="spot_list">
        <s:select class="form-control" id="selectCity" name="city" value="%{city}"
                  headerKey="" headerValue="--Select City--"
                  list="cityList"
                  onchange="this.form.submit()"
        /><br><br>

        <s:hidden name="continent" value="%{continent}" />
        <s:hidden name="country" value="%{country}" />

    </s:form>
        <s:if test="#session.user">
            <s:form action="createSpotAndCity">
                <s:hidden name="id" value="%{c.id}"/>
                <s:submit cssClass="btn btn-primary" value="New City"/>

            </s:form>
        </s:if>
    </s:if>
    <s:else>No spot created yet</s:else>
    <s:if test="#session.user">
    <s:form class="form-group" action="choseCity">

        <s:hidden name="continent" value="%{continent}" />
        <s:hidden name="country" value="%{country}" />
        <s:submit  cssClass="btn btn-primary" value="New Spot"/>

    </s:form>
    </s:if>

</s:if>
<s:iterator value="spotList">
    <ul>
            <s:a action="spot_detail"><s:property value="name"/>
                <s:if test="routeList.size()>1">
                (<s:property value="routeList.size()"/> routes)
                </s:if><s:elseif test="routeList.size()==1">
                    (<s:property value="routeList.size()"/> route)
                </s:elseif>
                <s:else>(no route created yet)</s:else>
                <s:param name="id" value="id"/>
            </s:a>
        <li>Country: <s:property value="country.name"/></li>
        <li>City: <s:property value="city"/></li>
        <li>Description: <s:property value="description"/></li>
        <li>GPS coordinates: <s:property value="latitude"/>,<s:property value="longitude"/></li>
        <li>Creator:
            <s:a action="member_detail">
                <s:param name="id" value="memberSpot.id"/>
                <s:property value="memberSpot.login"/>
            </s:a>
        </li>
    </ul>
</s:iterator>

</body>
</html>
--%>
