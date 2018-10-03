<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="/struts-tags" prefix="form"%>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<s:form action="demo_ajax">
<s:select id="selectContinent" name="continent"
          headerKey="-1" headerValue="Select Continent"
          list="continentList"
          onchange="this.form.submit()"/>
    <s:if test="%{continent!=null && !continent.equals('-1')}">
            <s:select id="selectCountry" name="country"
                      headerKey="-1" headerValue="Select Country"
                      list="countryList"
                      onchange="this.form.submit()"/>
    </s:if>
    <s:if test="%{country!=null && !country.equals('-1')&& !continent.equals('-1')}">
            <s:select id="selectRegion" name="region"
                      headerKey="-1" headerValue="Select Region"
                      list="regionList"
                      onchange="this.form.submit()"/>
    </s:if>
</s:form>
Continent: <s:property value="%{continent}"/><br>
Country: <s:property value="%{country}"/>


</body>
</html>