(function($) {
    $(document).ready(function() {

        $("#btnSubmit").on("click", function() {
            var userProblem = $("#userProblem").val();
            var isCrude = $("#isCrude:checked").is(":checked");
            var isIndecisive = $("#isIndecisive").is(":checked");
            var isIrritated = $("#isIrritated").is(":checked");
            var url = "http://18.220.32.132:8080/decisionMaker/API/decisions/" + isCrude + "/" + isIndecisive + "/" + isIrritated + "/plainText";


            console.log("this is the problem " + userProblem);
            console.log("this is is isIrritated " + isIrritated);
            console.log("this is crude " + isCrude);
            console.log("this is isIndecisive " + isIndecisive);
            console.log("this is the url " + url);


            var userProblem = $("#userProblem").val();
            if (userProblem == "") {
                $("#userProblem").attr("placeholder", "Seriously, Enter your problem!").focus();
            }

            if (userProblem != "") {

            var xhr = new XMLHttpRequest();

            xhr.open("get", url);
            xhr.onreadystatechange = function() {
                if(xhr.readyState == 4) {
                    var dataReturned = xhr.responseText;

                    $("#answerContainer").empty().append($("<p>").text(dataReturned));
                }
            }
            xhr.send(null);
            }
        });

    });

})(jQuery);