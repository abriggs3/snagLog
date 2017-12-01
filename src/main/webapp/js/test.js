(function($) {$(document).ready(function() {
    $(document).ready(function() {
        console.log("on")

    });

    $( function() {
        $( "#datepicker" ).datepicker();
    });



    $("#sendDate").on("click", function() {
        console.log("this is what the date will be " + $("#datepicker").val())
    })



    });
})(jQuery);