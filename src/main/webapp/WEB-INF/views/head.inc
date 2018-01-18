<link href="/limetaxi/images/favicon.png" type="image/vnd.microsoft.icon" rel="shortcut icon" />

<script type="text/javascript" src="/limetaxi/lib/jquery/jquery-1.9.0.js"> </script>
<link href="/limetaxi/lib/jquery/css/smoothness/jquery.ui.theme.css" type="text/css" rel="stylesheet" />
<link href="/limetaxi/lib/jquery/css/smoothness/jquery-ui.css" type="text/css" rel="stylesheet" />
<script src="/limetaxi/lib/jquery/jquery-ui-1.10.0.js"></script>

<script src="/limetaxi/lib/jquery/custom.jquery-ui-timepicker-addon.js"></script>
<script src="/limetaxi/lib/datejs/date-ru-RU.js"></script>
<script src="/limetaxi/lib/datejs/timepicker_ru.js"></script>
<script src="/limetaxi/lib/datejs/jquery.inputmask.js"></script>
<script src="/limetaxi/lib/datejs/jquery.inputmask.date.extensions.js"></script>
<script src="/limetaxi/lib/datejs/lime.jquery.inputmask.date.js"></script>

<link rel="stylesheet" href="/limetaxi/lib/leaflet/leaflet.css" type="text/css" media="screen, projection">
<!--[if lte IE 8]><link rel="stylesheet" href="/limetaxi/lib/leaflet/leaflet.ie.css" /><![endif]-->
<script type="text/javascript" src="/limetaxi/lib/leaflet/leaflet-src.js"> </script>

<link rel="stylesheet" href="/limetaxi/lib/leaflet/leaflet.draw.css" type="text/css" media="screen, projection">
<script type="text/javascript" src="/limetaxi/lib/leaflet/leaflet.draw-src.js"> </script>
<script type="text/javascript" src="/limetaxi/lib/lime/maps/draw-ru.js"> </script>

<link rel="stylesheet" href="/limetaxi/lib/lime/css/leaflet-lime.css" type="text/css" media="screen, projection">
<script src="/limetaxi/lib/lime/maps/common.js"></script>

<script type="text/javascript">
	window.Lime = window.Lime || {};
	Lime.map = Lime.map || {
		providerUrl: '/limetaxi/maps/tile?s={s}&z={z}&x={x}&y={y}',//'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png' 'http://{s}.tile.cloudmade.com/BC9A493B41014CAABB98F0471D759707/997/256/{z}/{x}/{y}.png'
		attribution: '${siteinfo}',
		boundsw: [<c:out value='${boundsw}'/>],
		boundne: [<c:out value='${boundne}'/>]
	};
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
