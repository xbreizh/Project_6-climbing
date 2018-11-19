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


            map = new Microsoft.Maps.Map('#myMap', {
                credentials: '${token}'
            });

            map.setView({
               /* mapTypeId: Microsoft.Maps.MapTypeId.aerial,*/
                zoom: 1.4 });


            //Create an infobox at the center of the map but don't show it.
            infobox = new Microsoft.Maps.Infobox(map.getCenter(), {
                visible: false
            });

            //Assign the infobox to a map instance.
            infobox.setMap(map);

          /*  //Create random locations in the map bounds.*/

            for (var i = 0 ; i < pushpinInfos.length; i++) {
                locs[i] = new Microsoft.Maps.Location(pushpinInfos[i].lat, pushpinInfos[i].lon);
                var pin;
                if(pushpinInfos[i].cType === 'BOULDER') {
                    pin = new Microsoft.Maps.Pushpin(locs[i], {color: 'green'});
                }else{
                    pin = new Microsoft.Maps.Pushpin(locs[i], {color: 'red'});
                }
                //Store some metadata with the pushpin.
                pin.Ref = pushpinInfos[i].ref;
                pin.Title = pushpinInfos[i].title;
                pin.Description = pushpinInfos[i].description;
                pin.City = pushpinInfos[i].city;

                //Add a click event handler to the pushpin.
                Microsoft.Maps.Events.addHandler(pin, 'click', pushpinClicked);

                //Add pushpin to the map.
                map.entities.push(pin);
            }
            //Create a legend.

        }



        function pushpinClicked(e) {
            //Make sure the infobox has metadata to display.
                //Set the infobox options with the metadata of the pushpin.
                infobox.setOptions({
                    title: e.target.City,
                    description: '<a href="spot_detail.action?id='+e.target.Ref+'" >'+e.target.Title.toUpperCase()+'</a>',
                    visible: true
                });
            infobox.setLocation(e.target.getLocation());
        }


    </script>
</head>
<body>
<div id="myMap" style="height:600px;"></div>
<fieldset style="position:absolute;bottom:27px;left:20px;width:160px;margin-top:10px; background-color:#fff9d1;border-radius:10px;">
    <legend>Legend</legend>
    <table>
        <tr>
            <th>Boulder</th>
            <td><img src="../img/green_pin.jpg"></td>
        </tr>
        <tr>
            <th>RopeClimbing</th>
            <td><img src="../img/green_pin.jpg"></td>
        </tr>

    </table>
</fieldset>
</body>
</html>
