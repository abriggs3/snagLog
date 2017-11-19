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
        <form class="form-group" method="post" action="markSnag">
            <div>Latitude: <span id="latspan"></span></div>
            <div>Longitude: <span id="lngspan"></span></div>
            <div><lable>Selected Coordinates:</lable><br>
                <input class="input-lg" type="text" id="latitudeClicked"  name="latitudeClicked"> latitude<br>
                <input class="input-lg" type="text" id="longitudeClicked"  name="longitudeClicked"> longitude
            </div>
            <div>
                <lable for="blockageType">Blockage Type</lable><br>
                <select class="form-control">
                    <option name="blockageType" value="noSelection">click to select</option>
                    <option name="blockageType" value="rocks">low water exposed rocks</option>
                    <option name="blockageType" value="mud">low water mud</option>
                    <option name="blockageType" value="treeFall">tree fall</option>
                    <option name="blockageType" value="other">other</option>
                </select>
            </div>
            <div>
                <lable for="hazardOrNot">Snag is </lable><br>
                <select class="form-control">
                    <option name="hazardOrNot" value="noSelection">click to select</option>
                    <option name="hazardOrNot" value="annoying">annoying</option>
                    <option name="hazardOrNot" value="slight">slight hazard</option>
                    <option name="hazardOrNot" value="major">major hazard</option>
                </select>
            </div>
            <div>
                <lable for="time delayed">Time required to navigate blockage in minutes</lable><br>
                <input type="text" class="input-small" name="timeDelay">
            </div>
            <div>
                <lable for="additionalBlockageInformation">Additional description or information</lable><br>
                <input class="input-lg" type="text" name="additionalBlockageInformation">
            </div>
            <div>
                <input type="submit" value="mark the snag">
            </div>
        </form>
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
            document.getElementById("latitudeClicked").value =  event.latLng.lat().toFixed(6);
            document.getElementById("longitudeClicked").value = event.latLng.lng().toFixed(6);
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
        lat = lat.toFixed(6);
        var lng = point.lng();
        lng = lng.toFixed(6);
        console.log("Latitude: " + lat + "  Longitude: " + lng);
        document.getElementById('latspan').innerHTML = point.lat();
        document.getElementById('lngspan').innerHTML = point.lng();
    }


</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyABhJ9Hbp5gF8WEyv4agisgqh-k4pVZSs0&callback=initMap">
</script>
</body>
</html>