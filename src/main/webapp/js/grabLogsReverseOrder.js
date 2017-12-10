(function($) {
    var jsonReversedLogList = null;

    $(document).ready(function() {
        $.ajax({
            type: "get",
            url: "genericListLogReversed",
            datatype: "json",

            success: function (jsonReversedLogList) {
                for (var i = 0, length = jsonReversedLogList.length; i < length; i++) {
                    $("#logThumb" + i).empty().append(($("<div>").addClass("logLink").attr("id", i)).append($("<h4>").text(jsonReversedLogList[i].waterBodyType)).append($("<span>").text(jsonReversedLogList[i].city + ", " + jsonReversedLogList[i].state)).append($("<span>").text(jsonReversedLogList[i].weatherDescription + ", " + jsonReversedLogList[i].temperature + " F")));
                }

                // load first log (the most recent log) into reading section
                displayLogToPage(jsonReversedLogList[0]);

                // allow user to click thumbnail and update the displayed log
                $(".logLink").on("click", function(){
                    var idOfLogSelected = $(this).attr("id");
                    displayLogToPage(jsonReversedLogList[idOfLogSelected]);
                });
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log("JS call to get log list has failed")
            }
        });
    });


    function displayLogToPage(selectedLog) {
        console.log("ran this, and sent an object with the id of " + selectedLog.userByUserId.firstName);
        $("#userName").text(selectedLog.userByUserId.userName);
        $("#firstNameLastName").text(selectedLog.userByUserId.firstName + " " + selectedLog.userByUserId.lastName);
        $("#userLogDescription").text(selectedLog.logText);
        if (selectedLog.userByUserId.userName == "admin" || selectedLog.userByUserId.userName == "superman" || selectedLog.userByUserId.userName == "batman" ) {
            $("#userImage").attr("src", "img/user-" + selectedLog.userByUserId.userName + ".jpg");
        } else {
            $("#userImage").attr("src", "img/user-noPic.jpg");
        }


    }

})(jQuery);

