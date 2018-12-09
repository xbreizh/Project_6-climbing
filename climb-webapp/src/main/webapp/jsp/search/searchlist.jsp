<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<h1>Liste de Spots From Research for <s:property value="%{str}"/></h1>
<br><br>
<h2>Spot</h2>
<s:iterator value="spotList">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Continent</th>
            <th>Country</th>
            <th>City</th>
            <th>Name</th>
            <th>Description</th>
            <th>GPS coordinates</th>
            <th>Creator
            </th>
            <th>
                <s:a action="spot_detail">Details
                    <s:param name="id" value="id"/>
                </s:a>

            </th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><s:property value="country.continent"/></td>
            <td><s:property value="country.name"/></td>
            <td><s:property value="city"/></td>
            <td><s:property value="name"/></td>
            <td><s:property value="description"/></td>
            <td><s:property value="latitude"/>,<s:property value="longitude"/></td>
            <td><s:a action="member_detail">
                <s:param name="id" value="memberSpot.id"/>
                <s:property value="memberSpot.login"/>
            </s:a>
            </td>
    </table>
</s:iterator>
<h2>Topo</h2>
<s:iterator value="topoList">
    <li>Name: <s:property value="name"/></li>
    <li>Edition: <s:property value="edition"/></li>
    <li>Author: <s:property value="author"/></li>
    <li>Published Year: <s:property value="publishedYear"/></li>
    <li>Description: <s:property value="description"/></li>
    <li>
        Créateur:
        <s:a action="member_detail">
            <s:param name="id" value="owner.id"/>
            <s:property value="owner.login"/>
        </s:a>
    </li>
    <br><br>
</s:iterator>

</body>
</html>