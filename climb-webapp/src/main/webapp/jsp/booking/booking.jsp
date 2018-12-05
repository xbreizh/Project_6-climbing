<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>



<%@include file="../_include/header.jsp" %>

<sx:head />
<h1>Booking
    <s:a action="topo_detail" style="display:block;text-decoration:none;" >
    <s:property value="topo.name" escapeHtml="false"/>
    <s:param name="id" value="topo.id"/>
</s:a></h1>



<!-- Datepicker as text field -->
<s:if test="#session.user">
<s:if test="session.user.id != topo.owner.id"  >
    <%@include file="bookingInStructions.jsp" %>
    <s:form action="topo_booking" namespace="/" method="POST" >
        <s:hidden name="id" value="%{id}" requiredLabel="true"/>
        <s:hidden name="booking.topo.id" value="%{id}" requiredLabel="true" />
        <s:hidden name="booking.booker.id" value="%{session.user.id}" requiredLabel="true" />

        <sx:datetimepicker name="booking.bookingDate" label="Format (dd/MM/yyyy)"
                           displayFormat="dd-MMM-yyyy" value="%{'today'}"/>
        <s:fielderror fieldName="booking.bookingDate"/>

        <sx:datetimepicker name="booking.plannedReturnDate" label="Format (dd/MM/yyyy)"
                           displayFormat="dd-MMM-yyyy" value="%{'today'}"/>
        <s:fielderror fieldName="booking.plannedReturnDate"/>
        <s:submit value="Book it"/>

    </s:form>
    <s:if test="%{conflictList.size()>0}">

        <table class="table table-bordered table-hover" style="border:none">
        <s:iterator value="%{conflictList}">
            <tr  style="color:#ff8a82">
                <td><s:property value="id"/></td>
                <td><s:date name = "bookingDate" format = "dd/MM/yyyy"/></td>
                <td><s:date name = "plannedReturnDate" format = "dd/MM/yyyy" /></td>
            </tr>
        </s:iterator>
        </table>
    </s:if>
</s:if>
</s:if>
<s:else>
    Connect to Book!
    <%@include file="../_include/connectButton.jsp" %>
</s:else>
    <h2>Bookings planned</h2>
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <s:if test="session.user.role == 'superadmin'"  >
            <th>BookingId</th></s:if>
            <th>Start Date </th>
            <th>Return Date(planned) </th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="%{topo.bookingList}">
            <tr><s:if test="session.user.role == 'superadmin'"  >
                <td><s:property value="id"/></td></s:if>
                <td><s:date name = "bookingDate" format = "dd/MM/yyyy" /></td>
                <td><s:date name = "plannedReturnDate" format = "dd/MM/yyyy" /></td>
            </tr>
        </s:iterator>
        </tbody>
    </table>


