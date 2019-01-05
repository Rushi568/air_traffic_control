
//https://data-live.flightradar24.com/clickhandler/?version=1.5&flight=10c01938

var marker = [];
var map;
function clearOverlays() {
    for (var i = 0; i < marker.length; i++) {
        marker[i].setMap(null);
    }
    marker.length = 0;
    marker=new Array();
}
function initMap() {

   
    var styledMapType = new google.maps.StyledMapType(v, {name: 'Styled Map'});

    var flightPlanCoordinates = [];
    var image = new google.maps.MarkerImage(
            "green.png",
            null, /* size is determined at runtime */
            null, /* origin is 0,0 */
            null, /* anchor is bottom center of the scaled image */
            new google.maps.Size(20, 20));
    var imageapt = new google.maps.MarkerImage(
            'apt1.png',
            null, /* size is determined at runtime */
            null, /* origin is 0,0 */
            null, /* anchor is bottom center of the scaled image */
            new google.maps.Size(15, 30));
    var temp;


     map = new google.maps.Map(document.getElementById('map'), {
        center: {lat:22, lng: 23},
        zoom: 8,
        mapTypeControlOptions: {
            mapTypeIds: []
        }
    });

    var apt = [];
            for (airport in airports)
    {
        // console.log(airport);
        apt.push(new google.maps.Marker({
            map: map,
            position: new google.maps.LatLng(airport.location[0], airport.location[1]),
            title: airport.airportcode,
            icon: imageapt

        }));
    }
    var lat0, lng0, lat1, lng1;
    map.mapTypes.set('styled_map', styledMapType);
    map.setMapTypeId('styled_map');
    console.log("Map Loaded");
    google.maps.event.addListener(map, 'bounds_changed', function () {
        lat0 = map.getBounds().getNorthEast().lat();
        lng0 = map.getBounds().getNorthEast().lng();
        lat1 = map.getBounds().getSouthWest().lat();
        lng1 = map.getBounds().getSouthWest().lng();
       
    });
    $.ajax({
            type: "GET",
            url: "https://data-live.flightradar24.com/zones/fcgi/feed.js?bounds=" + lat0 + "," + lat1 + "," + lng1 + "," + lng0 + "&faa=1&mlat=1&flarm=1&adsb=1&gnd=1&air=1&vehicles=1&estimated=1&maxage=14400&gliders=1&stats=1",
            success: function (myObj) {

                var i;
                var j = 0;
                var flights = [];
                for (i in myObj) {


                   
                        //x += myObj[i] + "<br>";
                        flights.push(myObj[i]);
                    
                    j++;
                }

                clearOverlays();
                var i = 0;
                // marker.length = 0;
                // marker[i]=setMap(null);
                for (flight in flights){
                
                    var x=[];
                if(i===0){
                $(document).ready(function () {
                    //{"total":{"ads-b":8115,"mlat":882,"faa":158,"flarm":8,"estimated":881},"visible":{"ads-b":2,"mlat":0,"faa":0,"flarm":0,"estimated":0}}
              x=flight.total;
              y=flight.visible;
             
                    var adsb=parseInt(x['ads-b']);
                    var mlat=parseInt(x['mlat']);
                    var faa=parseInt(x['faa']);
                    var flarm=parseInt(x['flarm']);
                    var estimated=parseInt(x['estimated']);
                    var total=adsb+mlat+faa+flarm+estimated;
                    var vadsb=parseInt(y['ads-b']);
                    var vmlat=parseInt(y['mlat']);
                    var vfaa=parseInt(y['faa']);
                    var vflarm=parseInt(y['flarm']);
                    var vestimated=parseInt(y['estimated']);
                    var vtotal=vadsb+vmlat+vfaa+vflarm+vestimated;
                    $("#ads").text(adsb);
                    $("#mlat").text(mlat);
                    $("#faa").text(faa);
                    $("#flarm").text(flarm);
                    $("#estimated").text(estimated);
                    $("#total").text(total);
                    $("#total1").text(total);
                    $("#vads").text(vadsb);
                    $("#vmlat").text(vmlat);
                    $("#vfaa").text(vfaa);
                    $("#vflarm").text(vflarm);
                    $("#vestimated").text(vestimated);
                    $("#vtotal").text(vtotal);
                    $("#vtotal1").text(vtotal);
                    
                   // console.log(JSON.stringify(flight));
                  
                });
                }
                if (i >= 2) {
                     var direction=flight[3];
                    var dir="";
                    if(direction===0||350<=direction||direction<=10)
                        dir="N";
                     else if(direction===90||80<=direction||direction>=100)
                        dir="E";
                     else if(direction===180||170<=direction||direction<=190)
                        dir="S";
                    
                     else if(direction===270||260<=direction||direction<=280)
                        dir="W";
                     else if(11<=direction||direction<=35)
                        dir="NNE";
                     else if(36<=direction||direction<=60)
                        dir="NE";
                     else if(61<=direction||direction<=79)
                        dir="ENE";
                     else if(101<=direction||direction<=124)
                        dir="ESE";
                     else if(125<=direction||direction<=144)
                        dir="SE";
                     else if(145<=direction||direction<=169)
                        dir="SSE";
                     else if(191<=direction||direction<=214)
                        dir="SSW";
                     else if(215<=direction||direction<=234)
                        dir="SW";
                     else if(235<=direction||direction<=259)
                        dir="WSW";
                     else if(281<=direction||direction<=304)
                        dir="WNW";
                     else if(305<=direction||direction<=324)
                        dir="NW";
                     else if(305<=direction||direction<=324)
                        dir="NNW";
                     else 
                        dir="NW";
                    
                    
                     image = new google.maps.MarkerImage(
           "images/airplane/"+dir+".png",
            null, /* size is determined at runtime */
            null, /* origin is 0,0 */
            null, /* anchor is bottom center of the scaled image */
            new google.maps.Size(20, 20));
                    marker[i-2] = (
                            new google.maps.Marker({
                                position: new google.maps.LatLng(flight[1], flight[2]),
                                icon: image,
                                title: "Flight : " + flight[13] + "/" + flight[16] + "\n" + "Latitude : " + flight[1] + "\n" + "Longitude : " + flight[2] + "\n" + "Altitude : " + flight[4] + "\n" + "Direction : " + flight[3] + "\n" + "Crusing Speed : " + flight[5] + " Knots"
                                       + "\n" + "Type : " + flight[8] + "\n" + "Radar Technology : " + flight[7] + "\n" + "Departure : " + flight[11] + "\n" + "Arrival : " + flight[12] + "\n"+"Direction : "+dir
                                ,
                                map: map
                            })
                            //;
                            );
          google.maps.event.addListener(marker[i-2],'click',function() {
                    map.setZoom(9);
                    map.setCenter(marker[i-2].getPosition());
                    alert("no click");
                });
                    
    }
                i++;
            }
            //document.getElementById("demo").innerHTML = x;
            }
        });
    //var flightPath;
    var flightPlanCoordinates = [];
    setInterval(function () {

        $.ajax({
            type: "GET",
            url: "https://data-live.flightradar24.com/zones/fcgi/feed.js?bounds=" + lat0 + "," + lat1 + "," + lng1 + "," + lng0 + "&faa=1&mlat=1&flarm=1&adsb=1&gnd=1&air=1&vehicles=1&estimated=1&maxage=14400&gliders=1&stats=1",
            success: function (myObj) {

                var i;
                var j = 0;
                var flights = [];
                for (i in myObj) {


                   
                        //x += myObj[i] + "<br>";
                        flights.push(myObj[i]);
                    
                    j++;
                }

                clearOverlays();
                var i = 0;
                // marker.length = 0;
                // marker[i]=setMap(null);
                for (flight in flights){
                
                    var x=[];
                if(i===0){
                $(document).ready(function () {
                    //{"total":{"ads-b":8115,"mlat":882,"faa":158,"flarm":8,"estimated":881},"visible":{"ads-b":2,"mlat":0,"faa":0,"flarm":0,"estimated":0}}
              x=flight.total;
              y=flight.visible;
             
                    var adsb=parseInt(x['ads-b']);
                    var mlat=parseInt(x['mlat']);
                    var faa=parseInt(x['faa']);
                    var flarm=parseInt(x['flarm']);
                    var estimated=parseInt(x['estimated']);
                    var total=adsb+mlat+faa+flarm+estimated;
                    var vadsb=parseInt(y['ads-b']);
                    var vmlat=parseInt(y['mlat']);
                    var vfaa=parseInt(y['faa']);
                    var vflarm=parseInt(y['flarm']);
                    var vestimated=parseInt(y['estimated']);
                    var vtotal=vadsb+vmlat+vfaa+vflarm+vestimated;
                    $("#ads").text(adsb);
                    $("#mlat").text(mlat);
                    $("#faa").text(faa);
                    $("#flarm").text(flarm);
                    $("#estimated").text(estimated);
                    $("#total").text(total);
                    $("#total1").text(total);
                    $("#vads").text(vadsb);
                    $("#vmlat").text(vmlat);
                    $("#vfaa").text(vfaa);
                    $("#vflarm").text(vflarm);
                    $("#vestimated").text(vestimated);
                    $("#vtotal").text(vtotal);
                    $("#vtotal1").text(vtotal);
                    
                   // console.log(JSON.stringify(flight));
                  
                });
                }
                if (i >= 2) {
                    var direction=parseInt(flight[3]);
                    var dir="";
                    if(direction===0||350<=direction&&direction<=10)
                        dir="N";
                     else if(direction===90||80<=direction&&direction<=100)
                      dir="E";
                     else if(direction===180||170<=direction&&direction<=190)
                        dir="S";
                    
                     else if(direction===270||260<=direction&&direction<=280)
                        dir="W";
                     else if(11<=direction&&direction<=35)
                        dir="NNE";
                     else if(36<=direction&&direction<=60)
                        dir="NE";
                     else if(61<=direction&&direction<=79)
                        dir="ENE";
                     else if(101<=direction&&direction<=124)
                        dir="ESE";
                     else if(125<=direction&&direction<=144)
                        dir="SE";
                     else if(145<=direction&&direction<=169)
                        dir="SSE";
                     else if(191<=direction&&direction<=214)
                        dir="SSW";
                     else if(215<=direction&&direction<=234)
                        dir="SW";
                     else if(235<=direction&&direction<=259)
                        dir="WSW";
                     else if(281<=direction&&direction<=304)
                        dir="WNW";
                     else if(305<=direction&&direction<=324)
                        dir="NW";
                     else if(305<=direction&&direction<=324)
                        dir="NNW";
                     else 
                        dir="NW";
                    if(flight[5]<=200||flight[4]===0){
                     
                    if(flight[5]<=200){
                        image = new google.maps.MarkerImage(
            "images/airplane/"+dir+" copy.png",
            null, /* size is determined at runtime */
            null, /* origin is 0,0 */
            null, /* anchor is bottom center of the scaled image */
            new google.maps.Size(20, 20)); 
        }
        if(flight[4]===0){
                         image = new google.maps.MarkerImage(
            "images/airplane/yellow/"+dir+" copy.png",
            null, /* size is determined at runtime */
            null, /* origin is 0,0 */
            null, /* anchor is bottom center of the scaled image */
            new google.maps.Size(20, 20)); 
        }
        } else
                        image = new google.maps.MarkerImage(
            "images/airplane/"+dir+".png",
            null, /* size is determined at runtime */
            null, /* origin is 0,0 */
            null, /* anchor is bottom center of the scaled image */
            new google.maps.Size(20, 20));
                    marker[i-2] = (
                            new google.maps.Marker({
                                position: new google.maps.LatLng(flight[1], flight[2]),
                                icon: image,
                                title: "Flight : " + flight[13] + "/" + flight[16] + "\n" + "Latitude : " + flight[1] + "\n" + "Longitude : " + flight[2] + "\n" + "Altitude : " + flight[4] + "\n" + "Direction : " + flight[3] + "\n" + "Crusing Speed : " + flight[5] + " Knots"
                                       + "\n" + "Type : " + flight[8] + "\n" + "Radar Technology : " + flight[7] + "\n" + "Departure : " + flight[11] + "\n" + "Arrival : " + flight[12] + "\n"+"Direction : "+dir
                                ,
                                map: map
                            })
                            //;
                            );
                   google.maps.event.addListener(map, 'click', function(event) {
                    map.setZoom(9);
                    map.setCenter(event.getPosition());
                    alert("no click");
                });
          
                }
                i++;
            }
            //document.getElementById("demo").innerHTML = x;
            }
        });

    }, 5000);
}

