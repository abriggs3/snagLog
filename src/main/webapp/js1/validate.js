function validate() {
    alert("running validate");
}


/*
(function() {
    'use strict';

    window.addEventListener('load', function() {
        var form = document.getElementById('newRegistrationForm');
        form.addEventListener('submit', function(event) {
            if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
    }, false);
})();
*/