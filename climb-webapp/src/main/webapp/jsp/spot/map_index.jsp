<script src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0" type="text/javascript" charset="UTF-8"></script>
<body onload="GetMap();">
<div id="map" style="position: relative; width: 600px; height: 450px;"></div>
<script>var pinInfobox;

function GetMap() {

    var pushpinInfos = [];




    pushpinInfos[0] = { 'lat': ${spotList.get(0).latitude}, 'lng': ${spotList.get(0).longitude}, 'title': '${spotList.get(0).name}', 'description': '${spotList.get(0).description}'};

    pushpinInfos[1] = { 'lat': ${spotList.get(1).latitude}, 'lng': ${spotList.get(1).longitude}, 'title': '${spotList.get(1).name}', 'description': '${spotList.get(1).description}'};



    var infoboxLayer = new Microsoft.Maps.EntityCollection();
    var pinLayer = new Microsoft.Maps.EntityCollection();
    var apiKey = "<api key>";

    var map = new Microsoft.Maps.Map(document.getElementById("map"), { credentials: '${token}' });

    // Create the info box for the pushpin
    pinInfobox = new Microsoft.Maps.Infobox(new Microsoft.Maps.Location(0, 0), { visible: false });
    infoboxLayer.push(pinInfobox);

    var locs = [];
    for (var i = 0 ; i < pushpinInfos.length; i++) {
        locs[i] = new Microsoft.Maps.Location(pushpinInfos[i].lat, pushpinInfos[i].lng);
        var pin = new Microsoft.Maps.Pushpin(locs[i]);
        pin.Title = pushpinInfos[i].title;
        pin.Description = pushpinInfos[i].description;
        pinLayer.push(pin);
        Microsoft.Maps.Events.addHandler(pin, 'click', displayInfobox);
    }

    map.entities.push(pinLayer);
    map.entities.push(infoboxLayer);

    var bestview = Microsoft.Maps.LocationRect.fromLocations(locs);
    map.setView({ center: bestview.center, zoom: 1 });
}

function displayInfobox(e) {
    pinInfobox.setOptions({ title: e.target.Title, description: e.target.Description, visible: true, offset: new Microsoft.Maps.Point(0, 25) });
    pinInfobox.setLocation(e.target.getLocation());
}

function hideInfobox(e) {
    pinInfobox.setOptions({ visible: false });
}</script>