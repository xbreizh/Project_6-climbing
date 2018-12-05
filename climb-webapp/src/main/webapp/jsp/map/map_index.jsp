
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
           /* var myStyle = {
                "elements": {
                    "water": { "fillColor": "#ffede3" },
                    "structure": { "fillColor": "#62ff43" },
                    "area": { "fillColor": "#f39ebd" },
                },
                "version": "1.0"
            };
*/
            map = new Microsoft.Maps.Map('#myMap', {
                credentials: '${token}'/*,
                customMapStyle: myStyle*/

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

        }



        /*function pushpinClicked(e) {
            //Make sure the infobox has metadata to display.
                //Set the infobox options with the metadata of the pushpin.
                infobox.setOptions({
                    title: e.target.City,
                    description: '<a href="spot_detail.action?id='+e.target.Ref+'" >'+e.target.Title.toUpperCase()+'</a>',
                    visible: true
                });
            infobox.setLocation(e.target.getLocation());
        }*/


    </script>

<div id="myMap" style="height:600px;">
<%@include file="index_map_legend.jsp" %>

</div>