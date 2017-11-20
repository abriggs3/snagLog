var map, infoWindow;
var bounds = new google.maps.LatLngBounds();

function initMap() {
    var mapOptions = {
        zoom: 10,
        center: new google.maps.LatLng(46.16176104498355, -89.21276092529297)
    }

    map = new google.maps.Map(document.getElementById("map"), mapOptions);




    /*
       // Display multiple markers on a map
       infoWindow = new google.maps.InfoWindow(), marker, i;

       var marker = new google.maps.Marker({
           position: myLatLng,
           map: map,
           title: 'Hello World!'
       });


                       var position = new google.maps.LatLng(markersReturned.locationLat[i][1], markersReturned.locationLon[i][2]);
                   bounds.extend(position);
                   marker = new google.maps.Marker({
                       position: position,
                       map: map,
                       title: markersReturned.additionalInformation[i][0]
                   });

   */

        // request the map points and place on map
    $.ajax({
        type: "get",
        url: "serveUpMapMarkers",
        datatype: "json",
        success: function (markersReturned) {
            var parsedMarkers = JSON.parse(markersReturned);

            $.each(parsedMarkers, function (index, value) {

                console.log("this should be a description " + parsedMarkers[index].additionalInformation)
                console.log("this should be the lat " + parsedMarkers[index].locationLat)
                console.log("this should be the lon" +parsedMarkers[index].locationLon)
                console.log("")
                /*
                var position = new google.maps.LatLng(parsedMarkers[index].locationLat, parsedMarkers[index].locationLon);
                bounds.extend(position);
                marker = new google.maps.Marker({
                    position: position,
                    map: map,
                    title: markersReturned[index].additionalInformation
                });
                */
                var markerLatLng = {lat: parsedMarkers[index].locationLat, lng: parsedMarkers[index].locationLon};
                var marker = new google.maps.Marker({
                    position: markerLatLng,
                    map: map,
                    title: "delay " + parsedMarkers[index].estimatedDelay + " min, " + parsedMarkers[index].additionalInformation
                });

            });



        },
        error: function (xhr, textStatus, errorThrown) {
            console.log("the call to retrieve the list of snags failed");
        }
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
    document.getElementById('latspan').innerHTML = point.lat();
    document.getElementById('lngspan').innerHTML = point.lng();
}

