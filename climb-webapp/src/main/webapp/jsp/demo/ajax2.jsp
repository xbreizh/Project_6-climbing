<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="/struts-tags" prefix="form"%>

<html>

<%@include file="../_include/header.jsp" %>

<body>

<%--
<s:select id="selectContinent" name="continentList" label="Country"
          list="continentList" listKey="id" listValue="value"
          onchange="onSelectContinentChange()"/>
--%>

<s:select label="Select Continent" listKey="continent"

          name="continent"
          headerValue="Select Continent"
          list="continentList" onchange="onSelectContinentChange()"
/>
<s:select label="Select Country" listKey="country"

          name="country"
          headerValue="Select Country"
          list="countryList" onchange="onSelectCountryChange()"
/>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

/*     function onSelectContinentChange() {
         // URL de l'action AJAX
         var url = "*/<%--<s:url action="demo_ajaxGetListCountry"--%>/*/>";

        // Paramètres de la requête AJAX
        var params = {
            continent: jQuery("#onSelectContinentChange").val()
            /!*country: jQuery("#onSelectContinentChange").val(),
            region: jQuery("#onSelectContinentChange").val()*!/
        };

        // Action AJAX en POST
        jQuery.post(
            url,
            params,
            function (data) {
                var selectSpot = jQuery("#selectSpot");
                countryList.empty();
                jQuery.each(data, function (key, val) {
                    selectSpot.append(
                        jQuery("<option>")
                        .text(val.name)
                            .val(val.name)
                    );
                });
            })
            .fail(function (data) {
                if (typeof data.responseJSON === 'object') {
                    console.log(data.responseJSON);
                } else {
                    console.log(data);
                }
                alert("Une erreur s'est produite.");
            });
    }*/
</script>

</body>
</html>