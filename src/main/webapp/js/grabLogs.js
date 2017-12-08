(function($) {
    $(document).ready(function() {
        $.ajax({
            type: "get",
            url: "genericListLog",
            success: function () {
                console.log("log session variable set")
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log("JS call has failed to set the session variable for logs")
            }
        });
    });
})(jQuery);