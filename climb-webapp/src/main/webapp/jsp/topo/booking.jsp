<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>



<%@include file="../_include/header.jsp" %>

<sx:head />
<h1>Booking page <s:property value="topo.name"/></h1>



<!-- Datepicker as text field -->
<s:if test="#session.user">
    <s:form action="topo_booking" namespace="/" method="POST" >
        <s:hidden name="id" value="%{id}" requiredLabel="true"/>
        <s:hidden name="booking.topo.id" value="%{id}" requiredLabel="true" />
        <s:hidden name="booking.booker.id" value="%{session.user.id}" requiredLabel="true" />

        <sx:datetimepicker name="beginBook" label="Format (dd/MM/yyyy)"
                           displayFormat="dd-MMM-yyyy" value="%{'today'}"/>
        <s:fielderror fieldName="beginBook"/>

        <sx:datetimepicker name="endBook" label="Format (dd/MM/yyyy)"
                           displayFormat="dd-MMM-yyyy" value="%{'today'}"/>
        <s:fielderror fieldName="endBook"/>
        <s:submit value="Book it"/>

    </s:form>
    <s:if test="%{conflictList.size()>0}">
        <table class="table table-bordered table-hover">
        <s:iterator value="%{conflictList}">
            <tr  style="color:#ff8a82">
                <td><s:property value="id"/></td>>
                <td><s:date name = "bookingDate" format = "dd/MM/yyyy"/></td>
                <td>  <s:date name = "returnDate" format = "dd/MM/yyyy" /></td>
            </tr>
        </s:iterator>
        </table>
    </s:if>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>BookingId</th>
            <th>Start Date </th>
            <th>End Date </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{topo.listBookings}">
            <tr>
                <td><s:property value="id"/></td>>
                <td><s:date name = "bookingDate" format = "dd/MM/yyyy" /></td>
                <td>  <s:date name = "returnDate" format = "dd/MM/yyyy" /></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if>
<s:else>
    Connect to Book!
    <%@include file="../_include/connectButton.jsp" %>
</s:else>

