<!DOCTYPE html>
<html>
<head>
    <title>Geolocation</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 100%;
        }
        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>

<div class='main'>
    <style type='text/css'>
        .eventtext {width:100%; margin-top:20px; font:10pt Arial; text-align:left;
            line-height:25px; background-color:#EDF4F8;padding:5px; border:1px dashed #C2DAE7;}
        #map {width:100%; height:340px; border:5px solid #DEEBF2;}
        ul {font:10pt arial; margin-left:25px; padding:0px;}
        li {margin-left:0px; padding:5px; list-style-type:decimal;}
        .small {font:9pt arial; color:gray; padding:2px; }
    </style>


    <div id="map"></div>
    <div class="eventtext">
        <div>Lattitude: <span id="latspan"></span></div>
        <div>Longitude: <span id="lngspan"></span></div>
        <div>Lat Lng: <span id="latlong"></span></div>
        <div>Lat Lng on click:
            <input type="text" id="latlongclicked" style="border:1px inset gray;"></div>
    </div>
</div>
<script>
    var map, infoWindow;
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: 46.16176104498355, lng: -89.21276092529297},
            zoom: 10
        });

        infoWindow = new google.maps.InfoWindow;

        // Try HTML5 geolocation.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function(position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };

                infoWindow.setPosition(pos);
                infoWindow.setContent('Location found.');
                infoWindow.open(map);
                map.setCenter(pos);
            }, function() {
                handleLocationError(true, infoWindow, map.getCenter());
            });
        } else {
            // Browser doesn't support Geolocation
            handleLocationError(false, infoWindow, map.getCenter());
        }

        google.maps.event.addListener(map, "mousemove", function (event) {
            displayCoordinates(event.latLng);
        });

        google.maps.event.addListener(map, "click", function (event) {
            document.getElementById('latlongclicked').value =  event.latLng.lat().toFixed(4)
                + ', ' + event.latLng.lng().toFixed(4);
        });
    }

    function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
            'Error: The Geolocation service failed.' :
            'Error: Your browser doesn\'t support geolocation.');
        infoWindow.open(map);
    }

    function displayCoordinates(point) {
        var lat = point.lat();
        lat = lat.toFixed(4);
        var lng = point.lng();
        lng = lng.toFixed(4);
        console.log("Latitude: " + lat + "  Longitude: " + lng);
        document.getElementById('latspan').innerHTML = point.lat();
        document.getElementById('lngspan').innerHTML = point.lng();
        document.getElementById('latlong').innerHTML = point.lat() + ', ' + point.lng();
    }


</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyABhJ9Hbp5gF8WEyv4agisgqh-k4pVZSs0&callback=initMap">
</script>
</body>
</html>