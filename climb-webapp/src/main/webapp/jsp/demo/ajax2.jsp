<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<script type="text/javascript">
function populate(s1, s2){
    var s1 = document.getElementById(s1);
    var s2 = document.getElementById(s2);
    s2.innerHTML = "";
    if(s1.value = "Chevy"){
        var optionArray = ["|", "camaro|Camaro", "corvette|Corvette", "impala|Impala"];
    }
    else if(s1.value = "Dodge"){
        var optionArray = ["|", "dogdge1|Dodge1", "dogdge2|Dodge2", "dogdge3|Dodge3"];
    }
    else if(s1.value = "Chevy"){
        var optionArray = ["|", "chevy1|Chevy1", "chevy2|Chevy2", "chevy3|Chevy3"];
    }
    for(var option in optionArray){
        var pair = optionArray[option].split("|");
        var newOption = document.createElement("option");
        newOption.value = pair[0];
        newOption.innerHTML = pair[1];
        s2.options.add(newOption);
    }

}





</script>
<h2>Choose your car</h2>
<hr />
Choose car make:
<select inlist="listMember" id="slct1" name="slct1" onchange="populate(this.id, 'slct2')">
    <%--<option value=""></option>--%>
    <option value="Chevy">Chevy</option>
    <option value="Dodge">Dodge</option>
    <option value="Ford">Ford</option>
</select>
<%--<s:combobox label="Pick a Member"
            headerKey="-1" headerValue="--- Select ---"
            list="slct2"
            name="slct2"  />--%>
<hr />
    Choose car model:
    <select id="slct2" name="slct2">
    </select>
<hr />
</body>
</html>