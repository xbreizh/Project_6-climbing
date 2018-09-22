<%@ taglib prefix="s" uri="/struts-tags" %>

<html>

<%@include file="../_include/head.jsp" %>

<body>
<h2>Démo - AJAX</h2>


<h3>Liste des membres</h3>
<%--<ul id="listMember">
    <li><em>à charger...</em></li>
</ul>
<h3>Selects en cascade</h3>
<button onclick="reloadListMember()">Actualiser</button>--%>
<s:form>
    <s:select id="selectMember" name="member" label="Member"
              list="listMember" listKey="id" listValue="login"
              onchange="onSelectMemberChange()"/>

    <s:select id="selectSpot" label="Spot" list="{}"/>
</s:form>
<li>Login: <s:property value="login"/></li>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>

    function onSelectMemberChange() {
        // URL de l'action AJAX
        var url = "<s:url action="demo_ajax_getListSpot"/>";

        // Paramètres de la requête AJAX
        var params = {
            member: jQuery("#selectMember").val()
        };

        // Action AJAX en POST
        jQuery.post(
            url,
            params,
            function (data) {
                var selectSpot = jQuery("#selectSpot");
                selectSpot.empty();
                jQuery.each(data, function (key, val) {
                    selectSpot.append(
                        jQuery("<option>")
                        .append(val.login)
                            /*.text(val.id)
                            .val(val.id)*/
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
    }

   /* function reloadListMember() {
        // URL de l'action AJAX
        var url = "*/<%--<s:url action="demo_ajax_getListMember"/>--%>/*";

        // Action AJAX en POST
        jQuery.post(
            url,
            function (data) {
                var $listMember = jQuery("#listMember");
                $listMember.empty();
                jQuery.each(data, function (key, val) {
                    $listMember.append(
                        jQuery("<li>")
                            .append(val.login)
                            .append(" - Creator : ")
                            .append(val.description)
                    );
                });
            })
            .fail(function () {
                alert("Une erreur s'est produite.");
            });
    }*/
</script>
</body>
</html>