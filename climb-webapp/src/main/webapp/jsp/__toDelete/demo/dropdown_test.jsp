<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<%@include file="../../_include/header.jsp" %>
<body>
<form action="demo_dropdown" method="POST">
    <select name="portchoice">
        <option>news</option>
        <option>weather</option>
        <option>entertainment</option>
    </select>
    <input type="submit" value="Select"/>
</form>

<h1> Option choisie: ${param.portchoice} </h1>

</body>
</html>