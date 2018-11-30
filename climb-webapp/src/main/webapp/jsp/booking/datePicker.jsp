<%--
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

    <sx:head />

<s:actionerror/>
<s:actionmessage/>
<h1>Struts 2 datetimepicker example</h1>

<s:form action="topo_booking" namespace="/" method="POST" >
    <s:textfield name="id" value="%{id}" />

    <sx:datetimepicker name="beginBook" label="Format (dd-MMM-yyyy)"
                       displayFormat="dd-MMM-yyyy" /><s:fielderror fieldName="beginBook"/>

    <sx:datetimepicker name="endBook" label="Format (dd-MMM-yyyy)"
                       displayFormat="dd-MMM-yyyy" value="%{'today'}"/>
                        <s:fielderror fieldName="endBook"/>
    <s:fielderror fieldName="endBook"/>
    <s:submit value="OK"/>

</s:form>


--%>
