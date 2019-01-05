<%-- 
    Document   : AATC
    Created on : Mar 17, 2018, 11:55:56 AM
    Author     : Kali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String lat = request.getParameter("lat");
    String lng = request.getParameter("lng");


%>
<html>

    <head>
        <meta charset="utf-8"/>
        <meta http-equiv="refresh" content="300">
        <title>Alexevan24 | Track Flights In Realtime - Flight Tracker For Live Flights </title>
        <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>

        <link rel="stylesheet" href="css/suggestion-box.css"/>

        <style>
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {
                height: 91%;
                opacity: 1;
                background-color:black; 
            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
                opacity: 1;
                background-color: black;
            }
            body {
                font-family: "Lato", sans-serif;
            }

            .sidenav {
                height: 100%;
                width: 200px;
                position: fixed;
                z-index: 1;
                top: 0;
                left: 0;
                background-color: #111;
                overflow-x: hidden;
                padding-top: 0px;
                margin-top: 40px;
            }

            .sidenav a {
                padding: 6px 8px 6px 16px;
                text-decoration: none;
                font-size: 25px;
                color: #818181;
                display: block;
            }

            .sidenav a:hover {
                color: #f1f1f1;
            }

            .main {
                margin-left: 200px; /* Same as the width of the sidenav */
                font-size: 28px; /* Increased text to enable scrolling */
                padding: 0px 0px;
            }

            @media screen and (max-height: 450px) {
                .sidenav {padding-top: 15px;}
                .sidenav a {font-size: 18px;}
            }
            span{
                font-size: 10px;
                font-weight: bold;
                color: lightpink;
                text-align: right;
            }
            img{
                height: 30px;
                width: auto;
            };
            h4{

            }

            hr.style14 { 
                border: 0; 
                height: 1px; 
                background-image: -webkit-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
                background-image: -moz-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
                background-image: -ms-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
                background-image: -o-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0); 
            }

        </style>

        <script src="js/mapstyle.js"></script>
        <script src="js/routes.js"></script>
        <script src="js/airports.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

        <script>
            var marker = [];
            var map;
            function clearOverlays() {
                for (var i = 0; i < marker.length; i++) {
                    marker[i].setMap(null);
                }
                marker.length = 0;
                marker = new Array();
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
            <%            if (lat != null && lng != null) {
                    out.print("center: {lat:" + lat + " , lng:" + lng + " },");
                } else {
                    out.print("center: {lat:23.073426 , lng:72.626571},");
                }
            %>
                    zoom: 13,
                            mapTypeControlOptions: {
                            mapTypeIds: ["hybrid", "StyledMap"]
                            }
                    });
                    var apt = [];
                    for (airport of airports)
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
                                    for (flight of flights){
                            google.maps.event.addListener(marker, 'click', function () {
                            map.setZoom(9);
                                    map.setCenter(marker.getPosition());
                                    alert("no click");
                            });
                                    var x = [];
                                    if (i === 0) {
                            $(document).ready(function () {
                            //{"total":{"ads-b":8115,"mlat":882,"faa":158,"flarm":8,"estimated":881},"visible":{"ads-b":2,"mlat":0,"faa":0,"flarm":0,"estimated":0}}
                            x = flight.total;
                                    y = flight.visible;
                                    var adsb = parseInt(x['ads-b']);
                                    var mlat = parseInt(x['mlat']);
                                    var faa = parseInt(x['faa']);
                                    var flarm = parseInt(x['flarm']);
                                    var estimated = parseInt(x['estimated']);
                                    var total = adsb + mlat + faa + flarm + estimated;
                                    var vadsb = parseInt(y['ads-b']);
                                    var vmlat = parseInt(y['mlat']);
                                    var vfaa = parseInt(y['faa']);
                                    var vflarm = parseInt(y['flarm']);
                                    var vestimated = parseInt(y['estimated']);
                                    var vtotal = vadsb + vmlat + vfaa + vflarm + vestimated;
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
                            var direction = flight[3];
                                    var dir = "";
                                    if (direction === 0 || 350 <= direction || direction <= 10)
                                    dir = "N";
                                    else if (direction === 90 || 80 <= direction || direction >= 100)
                                    dir = "E";
                                    else if (direction === 180 || 170 <= direction || direction <= 190)
                                    dir = "S";
                                    else if (direction === 270 || 260 <= direction || direction <= 280)
                                    dir = "W";
                                    else if (11 <= direction || direction <= 35)
                                    dir = "NNE";
                                    else if (36 <= direction || direction <= 60)
                                    dir = "NE";
                                    else if (61 <= direction || direction <= 79)
                                    dir = "ENE";
                                    else if (101 <= direction || direction <= 124)
                                    dir = "ESE";
                                    else if (125 <= direction || direction <= 144)
                                    dir = "SE";
                                    else if (145 <= direction || direction <= 169)
                                    dir = "SSE";
                                    else if (191 <= direction || direction <= 214)
                                    dir = "SSW";
                                    else if (215 <= direction || direction <= 234)
                                    dir = "SW";
                                    else if (235 <= direction || direction <= 259)
                                    dir = "WSW";
                                    else if (281 <= direction || direction <= 304)
                                    dir = "WNW";
                                    else if (305 <= direction || direction <= 324)
                                    dir = "NW";
                                    else if (305 <= direction || direction <= 324)
                                    dir = "NNW";
                                    else
                                    dir = "NW";
                                    image = new google.maps.MarkerImage(
                                            "images/airplane/" + dir + ".png",
                                            null, /* size is determined at runtime */
                                            null, /* origin is 0,0 */
                                            null, /* anchor is bottom center of the scaled image */
                                            new google.maps.Size(20, 20));
                                    marker[i - 2] = (
                                    new google.maps.Marker({
                                    position: new google.maps.LatLng(flight[1], flight[2]),
                                            icon: image,
                                            title: "Flight : " + flight[13] + "/" + flight[16] + "\n" + "Latitude : " + flight[1] + "\n" + "Longitude : " + flight[2] + "\n" + "Altitude : " + flight[4] + "\n" + "Direction : " + flight[3] + "\n" + "Crusing Speed : " + flight[5] + " Knots"
                                            + "\n" + "Type : " + flight[8] + "\n" + "Radar Technology : " + flight[7] + "\n" + "Departure : " + flight[11] + "\n" + "Arrival : " + flight[12] + "\n" + "Direction : " + dir
                                            ,
                                            map: map
                                    })
                                    //;
                                    );
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
                                    for (flight of flights){

                            var x = [];
                                    if (i === 0) {
                            $(document).ready(function () {
                            //{"total":{"ads-b":8115,"mlat":882,"faa":158,"flarm":8,"estimated":881},"visible":{"ads-b":2,"mlat":0,"faa":0,"flarm":0,"estimated":0}}
                            x = flight.total;
                                    y = flight.visible;
                                    var adsb = parseInt(x['ads-b']);
                                    var mlat = parseInt(x['mlat']);
                                    var faa = parseInt(x['faa']);
                                    var flarm = parseInt(x['flarm']);
                                    var estimated = parseInt(x['estimated']);
                                    var total = adsb + mlat + faa + flarm + estimated;
                                    var vadsb = parseInt(y['ads-b']);
                                    var vmlat = parseInt(y['mlat']);
                                    var vfaa = parseInt(y['faa']);
                                    var vflarm = parseInt(y['flarm']);
                                    var vestimated = parseInt(y['estimated']);
                                    var vtotal = vadsb + vmlat + vfaa + vflarm + vestimated;
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
                            var direction = parseInt(flight[3]);
                                    var dir = "";
                                    if (direction === 0 || 350 <= direction && direction <= 10)
                                    dir = "N";
                                    else if (direction === 90 || 80 <= direction && direction <= 100)
                                    dir = "E";
                                    else if (direction === 180 || 170 <= direction && direction <= 190)
                                    dir = "S";
                                    else if (direction === 270 || 260 <= direction && direction <= 280)
                                    dir = "W";
                                    else if (11 <= direction && direction <= 35)
                                    dir = "NNE";
                                    else if (36 <= direction && direction <= 60)
                                    dir = "NE";
                                    else if (61 <= direction && direction <= 79)
                                    dir = "ENE";
                                    else if (101 <= direction && direction <= 124)
                                    dir = "ESE";
                                    else if (125 <= direction && direction <= 144)
                                    dir = "SE";
                                    else if (145 <= direction && direction <= 169)
                                    dir = "SSE";
                                    else if (191 <= direction && direction <= 214)
                                    dir = "SSW";
                                    else if (215 <= direction && direction <= 234)
                                    dir = "SW";
                                    else if (235 <= direction && direction <= 259)
                                    dir = "WSW";
                                    else if (281 <= direction && direction <= 304)
                                    dir = "WNW";
                                    else if (305 <= direction && direction <= 324)
                                    dir = "NW";
                                    else if (305 <= direction && direction <= 324)
                                    dir = "NNW";
                                    else
                                    dir = "NW";
                                    if (flight[5] <= 200 || flight[4] === 0) {

                            if (flight[5] <= 200) {
                            image = new google.maps.MarkerImage(
                                    "images/airplane/" + dir + " copy.png",
                                    null, /* size is determined at runtime */
                                    null, /* origin is 0,0 */
                                    null, /* anchor is bottom center of the scaled image */
                                    new google.maps.Size(20, 20));
                            }
                            if (flight[4] === 0) {
                            image = new google.maps.MarkerImage(
                                    "images/airplane/yellow/" + dir + " copy.png",
                                    null, /* size is determined at runtime */
                                    null, /* origin is 0,0 */
                                    null, /* anchor is bottom center of the scaled image */
                                    new google.maps.Size(20, 20));
                            }
                            } else
                                    image = new google.maps.MarkerImage(
                                            "images/airplane/" + dir + ".png",
                                            null, /* size is determined at runtime */
                                            null, /* origin is 0,0 */
                                            null, /* anchor is bottom center of the scaled image */
                                            new google.maps.Size(20, 20));
                                    marker[i - 2] = (
                                    new google.maps.Marker({
                                    position: new google.maps.LatLng(flight[1], flight[2]),
                                            icon: image,
                                            title: "Flight : " + flight[13] + "/" + flight[16] + "\n" + "Latitude : " + flight[1] + "\n" + "Longitude : " + flight[2] + "\n" + "Altitude : " + flight[4] + "\n" + "Direction : " + flight[3] + "\n" + "Crusing Speed : " + flight[5] + " Knots"
                                            + "\n" + "Type : " + flight[8] + "\n" + "Radar Technology : " + flight[7] + "\n" + "Departure : " + flight[11] + "\n" + "Arrival : " + flight[12] + "\n" + "Direction : " + dir
                                            ,
                                            map: map
                                    })
                                    //;
                                    );
                            }
                            i++;
                            }
                            //document.getElementById("demo").innerHTML = x;
                            }
                    });
                    }, 5000);
            }


        </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBOm4KJ7Z5m1YewVFaqE3J3SYRXLZ6skNI&callback=initMap">
        </script>

    </head>
    <body>
        <script src="js/suggestion-box.js"></script>
        <script>
                    $(document).ready(function () {
            $('#search').suggestionBox({
            filter: true,
                    widthAdjustment: - 16,
                    leftOffset: - 40,
                    topOffset: 0



            }).loadSuggestions('json/suggestion.json');
            });
                    setInterval(function () {
                    $(document).ready(function () {

                    var d = new Date();
                            var time = d.toUTCString();
                            $("#utc").text(time);
                    });
                    }, 999);
        </script>
        <div class="fluid">
            <!-- NAVBAR STARTS HERE  -->
            <nav class="navbar navbar-inverse" style="z-index: 2;">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="http://192.168.1.105:8080/GoogleMapDemo/index.jsp"><img src="images/AATC White.png"/></a>
                    </div>
                    <div class="navbar-header">
                        <h5 style="text-align: right;color: whitesmoke;"> SWITCH AIRPORT </h5>
                    </div>
                    <div class="navbar-header">
                        <h4 style="text-align: left;color: whitesmoke;"><input type="text" class="form-control" placeholder="IATA / Apt-name" id="search" ></h4>
                    </div>
                    <div class="row">
                        <ul class="nav navbar-nav">
                            <li style=" text-transform: capitalize;"><h5 id="utc" style="color:whitesmoke"></h5></li>
                        </ul>
                    </div>
                </div>
            </nav>


            <!-- SIDEBAR STARTS HERE -->


            <div class="sidenav">
                <div class="fluid">
                    <hr class="style14">
                    <div class="col-lg-12">
                        <div class="table-responsive"> 
                            <h4 style="text-align: center;"><span style="font-size: 13px;">FLIGHTS : </span><span id="vtotal1" style="color: white;font-size: 13px;">-</span><span style="font-size: 13px;">  /  </span><span id="total1" style="color: white;font-size: 13px;">-</span></h4>
                            <table class="fluid table-condensed">
                                <thead>
                                    <tr>
                                        <th><span style="color: #cccccc;font-size: 10.5px;">DATA-SOURCE</span></th>
                                        <th><span style="color: #cccccc;font-size: 10.5px;">|</span></th>
                                        <th> <span style="color: #cccccc;font-size: 10.5px;">VIEW</span></th>
                                        <th><span style="color: #cccccc;font-size: 10.5px;">|</span></th>
                                        <th><span style="color: #cccccc;font-size: 10.5px;">GOLBAL</span></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><span></span> </td>
                                        <td></td>
                                        <td><span></span> </td>
                                        <td></td>
                                        <td><span></span> </td>
                                    </tr>
                                    <tr>
                                        <td><span></span> </td>
                                        <td></td>
                                        <td><span></span> </td>
                                        <td></td>
                                        <td><span></span> </td>
                                    </tr>

                                    <tr>
                                        <td><span></span> </td>
                                        <td></td>
                                        <td><span></span> </td>
                                        <td></td>
                                        <td><span></span> </td>
                                    </tr>
                                    <tr>
                                        <td><span style="color: whitesmoke;text-align: left;">ADS-B</span></td>
                                        <td></td>
                                        <td>  <span id="vads">-</span>   </td>
                                        <td></td>
                                        <td><span id="ads" >-</span><td>
                                    </tr>
                                    <tr>
                                        <td><span style="color: whitesmoke;text-align: left;">MLAT</span></td>
                                        <td></td>
                                        <td>  <span id="vmlat">-</span>   </td>
                                        <td></td>
                                        <td><span id="mlat" >-</span><td>
                                    </tr>
                                    <tr>
                                        <td><span style="color: whitesmoke;text-align: left;">FAA</span></td>
                                        <td></td>
                                        <td>  <span id="vfaa">-</span>   </td>
                                        <td></td>
                                        <td><span id="faa" >-</span><td>
                                    </tr>
                                    <tr>
                                        <td><span style="color: whitesmoke;text-align: left;">FLARM</span></td>
                                        <td></td>
                                        <td>  <span id="vflarm">-</span>   </td>
                                        <td></td>
                                        <td><span id="flarm" >-</span><td>
                                    </tr>
                                    <tr>
                                        <td><span style="color: whitesmoke;text-align: left;">ESTIMATED</span></td>
                                        <td></td>
                                        <td> <span id="vestimated">-</span>   </td>

                                        <td></td>
                                        <td><span id="estimated" >-</span><td>
                                    </tr>


                                    <tr>
                                        <td><span></span> </td>
                                        <td><span></span> </td>
                                        <td><span></span> </td>
                                    </tr>
                                    <tr>
                                        <td><span></span> </td>
                                        <td><span></span> </td>
                                        <td><span></span> </td>
                                    </tr>

                                    <tr>
                                        <td><span></span> </td>
                                        <td><span></span> </td>
                                        <td><span></span> </td>
                                    </tr>


                                    <tr>
                                        <td><span style="color:whitesmoke;text-align: left;">TOTAL</span></td>
                                        <td></td>
                                        <td>  <span id="vtotal">-</span>   </td>
                                        <td></td>
                                        <td><span id="total" >-</span><td>
                                    </tr>
                                </tbody> 
                            </table>     
                        </div>
                    </div>
                </div>
                <hr class="style14">

                <!--
                
                                <div class="container-fluid">
                                <h4 style="text-align: center;"> <span style="font-size: 13px;">SWITCH AIRPORT</span></h4>
                
                
                                <input type="text" class="form-control" placeholder="IATA / Apt-name" id="search" style="z-index: 99;">
                
                            </div>
                                
                                <hr class="style14">
                -->
                <div class="container-fluid">
                    <h4 style="text-align: center;"> <span style="font-size: 13px;">MISC. INFORMATION</span></h4>
                    <h5 style="text-align: left;"><img src="images/airplane/N.png" style="height: 17px;width: auto;"><span style="color: lightblue; font-size: 8px;"> : UNDER AREA CONTROL</span></h5>
                    <h5 style="text-align: left;"><img src="images/airplane/yellow/N copy.png" style="height: 17px;width: auto;"><span style="color: lightblue; font-size: 8px;"> : UNDER APPROACH CONTROL</span></h5>
                    <h5 style="text-align: left;"><img src="images/airplane/N copy.png" style="height: 17px;width: auto;"><span style="color: lightblue; font-size: 8px;"> : UNDER TOWER/BASE CONTROL</span></h5>
                </div>
                <hr class="style14">
            </div>
            <!-- SIDE NAVBAR ENDS HERE    -->
        </div>





        <div class="main">
            <div id="map">

                <br>

                <br>
                <br>
                <br>
                <p style="text-align:center;"><img src="images/AATC White.png" style="height: 180;width: auto;"></p>
                <br>
                <br>
                <h1 style="text-align: center; color:#dddddd;">L    O    A    D    I    N    G . . .</h1>


            </div>
        </div>

    </body>
</html>
