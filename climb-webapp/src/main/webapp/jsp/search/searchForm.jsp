<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

Min: <s:property value="%{levelMin}"/>
Max: <s:property value="%{levelMax}"/>
Climbing Type: <s:property value="%{climbingType}"/>
<s:form class="justify-content-center"  action="index" method="POST">

    <s:textfield class="form-control" label="Keyword" placeholder="Keyword" name="str"  value = "%{str}" requiredLabel="false"/>
    <s:if test="%{climbingType.equals('')}">
        <s:radio list="climbingList" checked="checked" value="ALL" name="climbingType" label="Climbing Type" />
    </s:if>
    <s:else>
        <s:radio list="climbingList"  name="climbingType" label="Climbing Type" />
    </s:else>

    <s:select list="%{levelList}" name="levelMin" listKey="key" label="Level Min"/>
    <s:if test="%{levelMax==0}">
        <s:select list="%{levelList}" name="levelMax"  value="32" listKey="key" label="Level Max"/>
    </s:if>
    <s:else>
        <s:select list="%{levelList}" name="levelMax"  listKey="key" label="Level Max"/>
    </s:else>

    <s:checkbox  name="hasTopo"  label="has Topo">
        <s:if test="%{hasTopo.equals('on')}">checked="true"</s:if>
    </s:checkbox>



    <s:submit value="Refresh"/>

</s:form>




