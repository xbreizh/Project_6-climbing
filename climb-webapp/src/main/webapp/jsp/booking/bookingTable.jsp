<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<h2>Bookings</h2>--%>
<s:if test="%{bookingList.size()>0}">
    <table class="table table-bordered table-hover">
        <thead>
        <tr>
            <th>Topo </th>
            <th>Owner </th>
            <th>Booker </th>
            <th>Date booking </th>
            <th>Date return planned</th>
            <th>Date return </th>
        </tr>
        </thead>
        <tbody >
        <s:iterator value="bookingList">
            <tr>
                <td>
                    <s:a action="topo_detail" style="display:block;text-decoration:none;" >
                        <s:property value="topo.name" escapeHtml="false"/>
                        <s:param name="id" value="topo.id"/>
                    </s:a>
                </td>
                <td>
                    <s:if test="#session.user.id == topo.owner.id">
                        <s:a action="member_detail">
                            <s:param name="id" value="topo.owner.id" />
                            <span style=" font-weight: bold;color: #ffae6e">You</span>
                        </s:a>
                    </s:if>
                    <s:else>
                        <s:a action="member_detail">
                            <s:param name="id" value="topo.owner.id" />
                            <s:property value="topo.owner.login"/>
                        </s:a>
                    </s:else>

                </td>
                <td>
                    <s:if test="#session.user.id == booker.id">
                        <s:a action="member_detail">
                            <s:param name="id" value="booker.id" />
                            <span style=" font-weight: bold;color: #ffae6e">You</span>
                        </s:a>
                    </s:if>
                    <s:else>
                        <s:a action="member_detail">
                            <s:param name="id" value="booker.id" />
                            <s:property value="booker.login"/>
                        </s:a>
                    </s:else>

                </td>
                <td>
                    <s:date name = "bookingDate" format = "dd/MM/yyyy"/>

                </td>
                <td> <s:date name = "plannedReturnDate" format = "dd/MM/yyyy"/>

                    <s:if test="#session.user.id == topo.owner.id && returnDate == null">
                <td style="border: none;">

                        <s:form action="endBooking" method="POST">
                            <s:hidden  name="id" value="%{id}" />
                            <s:hidden  name="memberId" value="%{session.user.id}" />
                            <s:submit value="Mark as returned"/>
                        </s:form>

                </td>
                    </s:if>
                    <s:else>
                        <td>
                            <s:date name = "returnDate" format = "dd/MM/yyyy"/>
                        </td>

                    </s:else>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</s:if><s:else>
    No Topo Found!
</s:else>