var map, infoWindow;
var bounds = new google.maps.LatLngBounds();

function initMap() {
    var mapOptions = {
        zoom: 10,
        center: new google.maps.LatLng(46.16176104498355, -89.21276092529297)
    }

    map = new google.maps.Map(document.getElementById("map"), mapOptions);

    google.maps.event.addListener(map, "mousemove", function (event) {
        displayCoordinates(event.latLng);
    });

    google.maps.event.addListener(map, "click", function (event) {
        document.getElementById("latitudeClicked").value =  event.latLng.lat().toFixed(6);
        document.getElementById("longitudeClicked").value = event.latLng.lng().toFixed(6);
    });

    $(".btn-select-start-end-point").on("click", function () {
        populateCoordInForm(this.id);
    })
}

function displayCoordinates(point) {
    var lat = point.lat();
    lat = lat.toFixed(6);
    var lng = point.lng();
    lng = lng.toFixed(6);
    document.getElementById('latspan').innerHTML = point.lat();
    document.getElementById('lngspan').innerHTML = point.lng();
}

function populateCoordInForm(btnId) {
    console.log("this is the id " +btnId);
    if (btnId == "btnStartCoordinates"){
        $("#startPointLat").val($("#latitudeClicked").val());
        $("#startPointLon").val($("#longitudeClicked").val());
    }
    if (btnId == "btnEndCoordinates") {
        $("#endPointLat").val($("#latitudeClicked").val());
        $("#endPointLon").val($("#longitudeClicked").val());
    }
}

