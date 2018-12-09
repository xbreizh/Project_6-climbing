<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="../../_include/header.jsp" %>

<s:if test="#session.user">

    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-6">
            <h2>(Spot) <s:property value="%{spot.name}"/></h2>
            <h3> New Route:</h3>


            <s:form action="createRoute" method="POST" theme="xhtml">
                <s:textfield label="Name" type="text" name="route.name" placeholder="Name" requiredLabel="true"/>
                <s:select label="Height" list="heightList" name="route.height" placeholder="Height" requiredLabel="true"
                          headerKey="-1" headerValue="-- Height --"/>
                <s:select label="Grade" list="%{gradeList}" name="route.grade" listKey="key" placeholder="Grade"
                          requiredLabel="true"
                          headerKey="-1" headerValue="-- Grade --"/>
                <s:textarea label="Description" type="text" name="route.description" placeholder="Description"
                            requiredLabel="true"/>
                <s:hidden label="Member " name="route.memberRoute.id" placeholder="Member" value="%{session.user.id}"
                          requiredLabel="true"/>
                <s:hidden label="Spot " name="route.spot.id" value="%{id}"/>
                <s:submit class="btn btn-success" value="Create"/>
            </s:form>


            <br><br>
            <s:a action="spot_detail">
                <s:param name="id" value="%{spot.id}"/>
                Back to List:
            </s:a>

        </div>
        <div class="col-md-2"></div>
    </div>
</s:if>
<s:else>
    <%@include file="../../_include/connectButton.jsp" %>
</s:else>
