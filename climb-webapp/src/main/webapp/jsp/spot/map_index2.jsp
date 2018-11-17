<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0" type="text/javascript" charset="UTF-8"></script>
<body onload="GetMap();">
<div id="map" style="position: relative; width: 600px; height: 450px;"></div>


<script>var pinInfobox;

function GetMap() {

    var pushpinInfos = [];
    //json array
    var result = ${listo};
    console.log(result[0]);

    // loop around the list but issue for i doesn't get incremented within the loop for the java values
    for(var i=0; i < result.length ; i++){
       pushpinInfos[i] = result[i];
    }

    var infoboxLayer = new Microsoft.Maps.EntityCollection();

    var pinLayer = new Microsoft.Maps.EntityCollection();
   /* var apiKey = "<api key>";*/

    var map = new Microsoft.Maps.Map(document.getElementById("map"), { credentials: '${token}' });

    // Create the info box for the pushpin
    pinInfobox = new Microsoft.Maps.Infobox(new Microsoft.Maps.Location(0, 0), { visible: false });
    infoboxLayer.push(pinInfobox);

    var locs = [];
    for (var i = 0 ; i < pushpinInfos.length; i++) {
        locs[i] = new Microsoft.Maps.Location(pushpinInfos[i].lat, pushpinInfos[i].lon);
        var pin = new Microsoft.Maps.Pushpin(locs[i]);
        pin.Title = pushpinInfos[i].title;
        pin.Description = pushpinInfos[i].description;
        console.log('title: '+pin.Title)
        console.log('description: '+pin.Description);
        pinLayer.push(pin);
        Microsoft.Maps.Events.addHandler(pin, 'click', displayInfobox);
    }

    map.entities.push(pinLayer);
    map.entities.push(infoboxLayer);

    var bestview = Microsoft.Maps.LocationRect.fromLocations(locs);
    map.setView({
        mapTypeId: Microsoft.Maps.MapTypeId.aerial,
        center: bestview.center,
        zoom: 1.3 });
}

function displayInfobox(e) {
    pinInfobox.setOptions({
        width :200,
        height :100,
        /*title: e.target.Title,*/
        htmlContent: '<a href="spot_detail.action?id=3" ><strong>'+e.target.Title+'</strong></a><br>'+
            e.target.Description,
        /*description: e.target.Description,*/
        visible: true,
        offset: new Microsoft.Maps.Point(0, 25) ,
    });
    pinInfobox.setLocation(e.target.getLocation());
}

function hideInfobox(e) {
    pinInfobox.setOptions({ visible: false });
}
function btn1Handler()
{
   console.log('plouf');
}
function btn2Handler()
{
    console.log('plaf');
}
</script>--%>
