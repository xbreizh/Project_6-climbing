<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<%@include file="../../_include/header.jsp" %>

<body>
<h2><s:property value="%{spot.name}"/> - New Route:</h2>
<s:if test="#session.user">
<s:form action="createRoute" method="POST" theme="xhtml">
    <s:textfield type="text" name="route.name" placeholder="Name" requiredLabel="true"/>
    <s:select list="heighList" name="route.height" placeholder="Height" requiredLabel="true" headerKey="-1" headerValue="-- Height --"/>
    <s:select list="%{gradeList}"  name="route.grade"  listKey="key" placeholder="Grade" requiredLabel="true"
              headerKey="-1" headerValue="-- Grade --"/>
    <s:textarea type="text" name="route.description" placeholder="Description" requiredLabel="true"/>
    <s:hidden name="route.memberRoute.id" placeholder="Member" value="%{session.user.id}" requiredLabel="true" />
    <s:hidden name="route.spot.id" value="%{spot.id}" placeholder="Spot" requiredLabel="true" />
    <s:hidden name="id" value="%{id}" />
    <s:submit value="OK"/>
</s:form>
</s:if>
<s:else>
    Vous devez vous connecter pour cette action!
    <%@include file="../../_include/connectButton.jsp" %>
</s:else><br><br>
<s:a action="spot_detail">
    <s:param name="id" value="%{spot.id}"/>
    Back to List:
</s:a>

</body>
</html>