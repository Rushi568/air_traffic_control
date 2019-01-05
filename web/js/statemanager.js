function Save()

  {

  var mapzoom=map.getZoom();

  

  var mapcenter=map.getCenter();

  var maplat=mapcenter.lat();

  var maplng=mapcenter.lng();

  var maptypeid=map.getMapTypeId();

  

  var cookiestring=maplat+"_"+maplng+"_"+mapzoom+"_"+maptypeid;

  

  var exp = new Date();     //set new date object

  exp.setTime(exp.getTime() + (1000 * 60 * 60 * 24 * 30));     //set it 30 days ahead

  

  setCookie("DaftLogicGMRLL",cookiestring, exp);

  //mapDiv.innerHTML='Saved';

  }

function Load()

  {

  var loadedstring=getCookie("DaftLogicGMRLL");

  var splitstr = loadedstring.split("_");

  

  var latlng = new google.maps.LatLng(parseFloat(splitstr[0]), parseFloat(splitstr[1]));

  map.setCenter(latlng);

  map.setZoom(parseFloat(splitstr[2]));

  map.setMapTypeId(splitstr[3])

 // mapDiv.innerHTML='Loaded';

  }

function setCookie(name, value, expires) 

  {

  document.cookie = name + "=" + escape(value) + "; path=/" + ((expires == null) ? "" : "; expires=" + expires.toGMTString());

  }

function getCookie(c_name)

  {

  if (document.cookie.length>0)

  {

  c_start=document.cookie.indexOf(c_name + "=");

  if (c_start!=-1)

  { 

  c_start=c_start + c_name.length+1; 

  c_end=document.cookie.indexOf(";",c_start);

  if (c_end==-1) c_end=document.cookie.length;

  return unescape(document.cookie.substring(c_start,c_end));

  } 

  }

  return "";

  }