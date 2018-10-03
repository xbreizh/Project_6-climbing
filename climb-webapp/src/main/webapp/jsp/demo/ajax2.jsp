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
    <s:if test="%{continent!=null}">
            <s:select id="selectCountry" name="country"
                      headerKey="-1" headerValue="Select Country"
                      list="countryList"
                      onchange="this.form.submit()"/>
    </s:if>
    <s:if test="%{country!=null}">
            <s:select id="selectRegion" name="region" label="Region"
                      list="regionList"
                      onchange="this.form.submit()"/>
    </s:if>
</s:form>
Continent: <s:property value="%{continent}"/><br>
Country: <s:property value="%{country}"/>
<%--
<s:if test="%{continent!=null}">
<s:form action="demo_ajaxGetListRegion">
<s:select id="selectCountry" name="country"
          headerKey="-1" headerValue="Select Country"
          list="countryList"
          onchange="this.form.submit()"/>
</s:form>
</s:if>

<s:if test="%{country!=null}">
<s:form action="demo_ajaxGetListRegion">
    <s:select id="selectRegion" name="region" label="Region"
              list="regionList"
              onchange="this.form.submit()"/>
</s:form>
</s:if>
<s:else>
    Continent: <s:property value="%{continent}"/>
    Country: <s:property value="%{country}"/></s:else>
--%>

</body>
</html>