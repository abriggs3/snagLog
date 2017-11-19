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