<%@ taglib prefix="s" uri="/struts-tags" %>


<s:form class="justify-content-center"  action="index" method="POST">

    <s:textfield class="form-control" label="Keyword" placeholder="Keyword" name="str"  value = "%{str}" requiredLabel="false"/>

        <s:radio list="climbingList"  name="climbingType" label="Climbing Type" />


    <s:select list="%{gradeList}" name="levelMin" listKey="key" label="Level Min"/>
    <s:if test="%{gradeList==0}">
        <s:select list="%{gradeList}" name="levelMax"  value="32" listKey="key" label="Level Max"/>
    </s:if>
    <s:else>
        <s:select list="%{gradeList}" name="levelMax"  listKey="key" label="Level Max"/>
    </s:else>

    <s:checkbox  name="hasTopo"  label="has Topo">
        <s:if test="%{hasTopo.equals('on')}">checked="true"</s:if>
    </s:checkbox>


    <s:submit class="btn btn-success" value="Search"/>

</s:form>




