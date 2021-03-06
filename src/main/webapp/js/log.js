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

    $("#waterBodyType").on("click", function () {
        giveSubSelectForWaterType($("#waterBodyType option:selected").val());
    })

    $( function() {
        $( "#datepicker" ).datepicker();
    });

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
    if (btnId == "btnStartCoordinates"){
        $("#startPointLat").val($("#latitudeClicked").val());
        $("#startPointLon").val($("#longitudeClicked").val());
    }
    if (btnId == "btnEndCoordinates") {
        $("#endPointLat").val($("#latitudeClicked").val());
        $("#endPointLon").val($("#longitudeClicked").val());
    }
}

function giveSubSelectForWaterType(waterTypeSelected) {
    if (waterTypeSelected == "flatWater") {
        $("#waterTypeSubSelect").empty().append("<label for='waterSubChoice'>flat-water type </label><br>" +
            "                            <select class='form-control' id='waterSubChoice' name='waterSubChoice'>" +
            "                                <option value='noSelection'>click to select</option>" +
            "                                <option value='lake'>small lake - i.e. wind sheltered</option>" +
            "                                <option value='large lake'>large lake - i.e open to high wind and waves</option>" +
            "                                <option value='small river'>small river - less than 100 ft across</option>" +
            "                                <option value='large river'>large river - more than 200 ft across, includes flowages</option>" +
            "                                <option value='Ocean'>Ocean, bay, or Sound</option>" +
            "                            </select>");

    }

    if (waterTypeSelected == "whiteWater") {
        $("#waterTypeSubSelect").empty().append("<label for='waterSubChoice'>whitewater type -- highest class on route </label><br>" +
            "                            <select class='form-control' id='waterSubChoice' name='waterSubChoice'>" +
            "                                <option value='noSelection'>click to select</option>" +
            "                                <option value='class1'>class 1 - small rough spots - no maneuvering required</option>" +
            "                                <option value='class2'>class 2 - some rocks, small drops - basic maneuvering required</option>" +
            "                                <option value='class3'>class 3 - max 3–5 ft drop - significant maneuvering</option>" +
            "                                <option value='class4'>class 4 - considerable drops, sharp maneuvers - significant risk</option>" +
            "                                <option value='class5'>class 5</option>" +
            "                            </select>");
   }

}

