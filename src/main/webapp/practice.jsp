<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML+RDFa 1.0//EN" "http://www.w3.org/MarkUp/DTD/xhtml-rdfa-1.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="content-language" content="en" />

    <title>Mark your snag</title>




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

    <script src="http://maps.google.com/maps?file=api&v=2&key=AIzaSyABhJ9Hbp5gF8WEyv4agisgqh-k4pVZSs0" type="text/javascript"></script>




    <div id="map"></div>
    <div class="eventtext">
        <div>Lattitude: <span id="latspan"></span></div>
        <div>Longitude: <span id="lngspan"></span></div>
        <div>Lat Lng: <span id="latlong"></span></div>
        <div>Lat Lng on click:
            <input type="text" id="latlongclicked" style="border:1px inset gray;"></div>
    </div>



    <script type="text/javascript">
        if (GBrowserIsCompatible())
        {
            map = new GMap2(document.getElementById("map"));
            map.addControl(new GLargeMapControl());
            map.addControl(new GMapTypeControl(3));
            map.setCenter( new GLatLng(43.120908478032554, -89.33107709886826), 11,0);

            GEvent.addListener(map,'mousemove',function(point)
            {
                document.getElementById('latspan').innerHTML = point.lat()
                document.getElementById('lngspan').innerHTML = point.lng()
                document.getElementById('latlong').innerHTML = point.lat() + ', ' + point.lng()
            });

            GEvent.addListener(map,'click',function(overlay,point)
            {
                document.getElementById('latlongclicked').value = point.lat() + ', ' + point.lng()
            });
        }
    </script>



</div>
<!-- end div main -->

</body>
</html>