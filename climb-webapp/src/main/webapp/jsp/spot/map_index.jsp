<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="utf-8" />
    <script type='text/javascript'
            src='http://www.bing.com/api/maps/mapcontrol?callback=GetMap'
            async defer></script>
    <script type='text/javascript'>
        var map, infobox;

        function GetMap() {
            var pushpinInfos = [];
            //json array
            var result = ${listo};
            console.log(result[0]);
            // loop around the list but issue for i doesn't get incremented within the loop for the java values
            for(var i=0; i < result.length ; i++){
                pushpinInfos[i] = result[i];
            }

            var pinLayer = new Microsoft.Maps.EntityCollection();
            var locs = [];
            /*for (var i = 0 ; i < pushpinInfos.length; i++) {
                locs[i] = new Microsoft.Maps.Location(pushpinInfos[i].lat, pushpinInfos[i].lon);
                var pin = new Microsoft.Maps.Pushpin(locs[i]);
                pin.Title = pushpinInfos[i].title;
                pin.Description = pushpinInfos[i].description;
                console.log('title: '+pin.Title)
                console.log('description: '+pin.Description);
                pinLayer.push(pin);
                Microsoft.Maps.Events.addHandler(pin, 'click', pushpinClicked);
            }*/


            map = new Microsoft.Maps.Map('#myMap', {
                credentials: '${token}'
            });

            map.setView({
                zoom: 1.3 });


            //Create an infobox at the center of the map but don't show it.
            infobox = new Microsoft.Maps.Infobox(map.getCenter(), {
                visible: false
            });

            //Assign the infobox to a map instance.
            infobox.setMap(map);

          /*  //Create random locations in the map bounds.
            var randomLocations = Microsoft.Maps.TestDataGenerator.getLocations(5, map.getBounds());*/

            for (var i = 0 ; i < pushpinInfos.length; i++) {
                locs[i] = new Microsoft.Maps.Location(pushpinInfos[i].lat, pushpinInfos[i].lon);
                var pin = new Microsoft.Maps.Pushpin(locs[i]);
                //Store some metadata with the pushpin.
                pin.Ref = pushpinInfos[i].ref;
                pin.Title = pushpinInfos[i].title;
                pin.Description = pushpinInfos[i].description;

                //Add a click event handler to the pushpin.
                Microsoft.Maps.Events.addHandler(pin, 'click', pushpinClicked);

                //Add pushpin to the map.
                map.entities.push(pin);
            }
        }

        function pushpinClicked(e) {
            //Make sure the infobox has metadata to display.
           /* alert('plagf');*/
           /* if (e.target.metadata) {*/
                //Set the infobox options with the metadata of the pushpin.
                infobox.setOptions({
                    title: e.target.Title,
                    description: '<a href="spot_detail.action?id='+e.target.Ref+'" >'+e.target.Description+'</a>',
                    visible: true
                });
            infobox.setLocation(e.target.getLocation());
            /*}*/
        }
    </script>
</head>
<body>
<div id="myMap" style="position:relative;width:600px;height:400px;"></div>
</body>
</html>
