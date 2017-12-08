(function($) {
    $(document).ready(function() {
        $.ajax({
            type: "get",
            url: "genericListLogReversed",
            datatype: "json",

            success: function (jsonReversedLogList) {
                for (var i = 0, length = jsonReversedLogList.length; i < length; i++) {
                    $("#logThumb" + i).empty().append($("<h4>").text(jsonReversedLogList[i].waterBodyType));
                    $("#logThumb" + i).append($("<span>").text(jsonReversedLogList[i].city + ", " + jsonReversedLogList[i].state));
                    $("#logThumb" + i).append($("<span>").text(jsonReversedLogList[i].weatherDescription + ", " + jsonReversedLogList[i].temperature + " F"));
                }
            },
            error: function (xhr, textStatus, errorThrown) {
                console.log("JS call to get log list has failed")
            }
        });
    });
})(jQuery);

$("#answerContainer").empty().append($("<p>").text(decisionReturned));