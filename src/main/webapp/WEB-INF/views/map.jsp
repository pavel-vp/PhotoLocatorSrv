<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Карта</title> 
	
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/date.js"> </script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/jquery-1.9.0.js"> </script>
	<link href="${pageContext.request.contextPath}/lib/jquery/css/smoothness/jquery.ui.theme.css" type="text/css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/lib/jquery/css/smoothness/jquery-ui.css" type="text/css" rel="stylesheet" />
	<script src="${pageContext.request.contextPath}/lib/jquery/jquery-ui-1.10.0.js"></script>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/leaflet/leaflet.css" type="text/css" media="screen, projection">
	<!--[if lte IE 8]><link rel="stylesheet" href="/limetaxi/lib/leaflet/leaflet.ie.css" /><![endif]-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/leaflet/leaflet-src.js"> </script>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/leaflet/MarkerCluster.css" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/leaflet/MarkerCluster.Default.css" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/leaflet/leaflet.draw.css" type="text/css" media="screen, projection">
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/leaflet/leaflet.draw-src.js"> </script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/lib/leaflet/leaflet.markercluster-src.js"> </script>

<script type="text/javascript">



</script>

<style>
	body {
		padding: 0;
		margin: 0;
	}
	html, body, #map {
		height: 100%;
	}
</style>

</head>
<body>
	<div id="map">



	</div>


<script type="text/javascript">

$(function() {

var map = L.map('map').setView([56.850824, 53.202399], 13);

L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    attribution: ''
}).addTo(map);
var markersLayer = L.markerClusterGroup({ spiderfyOnMaxZoom: false, showCoverageOnHover: false, zoomToBoundsOnClick: false, maxClusterRadius: 50, disableClusteringAtZoom: 20 });

markersLayer.on('clusterclick', function (a) {
	a.layer.spiderfy();
});

//var photolist = ${photolist};

$.ajax({
	url : "/restapi/getphotoslistwoimage",
	type : "GET",
	dataType : "json", // expected format for response
	contentType : "application/json", // send as JSON
	data : undefined,
	success : function(response) {
		photolist = response;
		updateList(photolist);	
	},	

	error : function(response) {
		alert('error='+response);
	}
});

    
	function updateList(photolist) {
		// for all object - make markers
		markersList = [];
		$.each(photolist, function(key, _obj){

			var marker = L.marker([_obj.latitude, _obj.longitude]);
			var d = new Date(_obj.createdate);
			
			marker.bindPopup(d.format("dd.mm.yyyy HH.MM")+'<br>' +_obj.name+'<br> <a href="/restapi/getphoto?idx='+_obj.idx+'" target="_blank"><image width="127" height="110" src="/restapi/getphotomini?idx='+_obj.idx+'"/></a>');
			markersList.push(marker);

		});		
		markersLayer.addLayers(markersList);
		map.addLayer(markersLayer);
	}
});
	</script>
</body>
</html>