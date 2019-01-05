/*
 * Set of Function that initialize the gmaps
 * @author Albert Stepanyan
 * @date 27.03.2012 
 * */

var map; //the future object

var startPointY = y[0];

var startPointX =x[0];

var limit;// the limit for setinterval

var distance; //the distance between two points

var timer = 0; //the timer

var nextTimer = 1 ;//the timer of the next element

var singleStep = 0; //setInterval for one step

var limitStep; // setIntervalLimit for one step

var speed = 60; //the speed for hour in km

var theRouteTime  = 5; //in minutes gets from the database

var miliSec =  theRouteTime * 60 *1000;

var timeLimit = x.length;

var interval = miliSec/timeLimit; //the step timer for Interval

var marker;

var busMarker;

var coordsArray = new Array();//array the contains positions
	for(var i=0;i<x.length;i++){
		coordsArray[i] = new google.maps.LatLng(y[i], x[i])
}
	 
 // Array that will contain the coordinates of the map clicks


var endCoord = x.length -1;

var distance = google.maps.geometry.spherical.computeDistanceBetween (y[0], y[endCoord]);


var busMove;

var result = document.getElementById("result");

var bus = 'green.png';

var startIcon ='Neon.png';

var stopIcon ='Neon.png';

var Yerevan = new google.maps.LatLng(startPointY,startPointX);
window.onload = initialize(Yerevan);
//starts the map initialization
function initialize(center) {
  var mapOptions = {
    zoom: 15,
    center: center,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  };
  map =  new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
  
    /*google.maps.event.addListener(map, 'click', function(event) {
       getCoord(event.latLng);
    });*/


  
}//end of initialize


//function that adds the stations
function getCoord(location){//coordinates on click
 	var stationMarker = addMarker(location,station);
    coordsArray.push(location);
    var myLatLng = location;
    var lat = location.lat();
    var lng = location.lng();
    //passCoord(lat,lng); //function that sends ajax request to the database
}

//function that will add the busses
function addBusses(){
		var curY = y[0];
		var curX = x[0];
		var location = new google.maps.LatLng(curY,curX);
			var busMarker = addMarker(location,bus);
			marker = busMarker;
			marker.setMap(map);
			setTimeout(function(){
				drawRoute();
			},1000);
			
}//end of function

function putStart(){
	var curY = y[0];
	var curX = x[0];
	var start = new google.maps.LatLng(curY,curX);
	start = new google.maps.Marker({
		position:start,
	    map:map,
	    draggable:true,
	    animation: google.maps.Animation.DROP,
	    icon:startIcon
  	});
  	start.setMap(map);
}

function putStop(){
	var curY = y[endCoord];
	var curX = x[endCoord];
	var stop = new google.maps.LatLng(y[endCoord],x[endCoord]);
	stop = new google.maps.Marker({
		position:stop,
	    map:map,
	    draggable:true,
	    animation: google.maps.Animation.DROP,
	    icon:stopIcon
  	});
  	stop.setMap(map);
}

// Ads markers on Map 
function addMarker(location,icon){
	marker = new google.maps.Marker({
		position:location,
	    map:map,
	    draggable:true,
	    animation: google.maps.Animation.DROP,
	    icon:icon
  	});
  	return marker;
}


//draws polyline
function drawRoute(){
   var flightPath = new google.maps.Polyline({
	    path: coordsArray,
	    strokeColor: "#FF0000",
	    strokeOpacity: 1.0,
	    strokeWeight: 2
  	});
  	flightPath.setMap(map);
  	putStart();
  	putStop();
  	busMove = setInterval(
  		function(){
  			movement();
  		},interval
  	);
  	  	
}

function movement(){
	//start of function
    	var limit = x.length-1;
    	if(timer < limit || nextTimer <= limit){
	   		var strictLat = y[nextTimer];
			var strictLng = x[nextTimer];
				var newPosition = new google.maps.LatLng(strictLat,strictLng); 
				marker.setPosition(newPosition);
				map.setCenter(newPosition);
		}
    	else{
    		clearInterval(busMove);
    		alert("trip finished");
    	}
    	nextTimer++;
    	timer++
}//end of movement

