// Function to show SweetAlert on form submission success
function showSuccessAlert() {
    Swal.fire({
        title: 'Success!',
        text: 'Form submitted successfully',
        icon: 'success',
        confirmButtonText: 'OK'
    }).then((result) => {
        if (result.isConfirmed) {
            // Redirect or perform any other action
            window.location.href = '/';
        }
    });
}

// Function to show SweetAlert on form submission failure
function showErrorAlert(message) {
    Swal.fire({
        title: 'Error!',
        text: message,
        icon: 'error',
        confirmButtonText: 'OK'
    });
}

// Handle form submission
$(document).ready(function () {
    $('#contactForm').submit(function (event) {
        event.preventDefault(); // Prevent the form from submitting

        // Frontend validation
        var isValid = true;
        $('#contactForm input, #contactForm textarea').each(function () {
            if ($(this).val().trim() === '') {
                isValid = false;
                $(this).addClass('is-invalid');
            } else {
                $(this).removeClass('is-invalid');
            }
        });

        if (!isValid) {
            Swal.fire({
                title: 'Error!',
                text: 'Please fill out all required fields.',
                icon: 'error',
                confirmButtonText: 'OK'
            });
            return;
        }

        // Construct JSON object from form data
        var formData = {
            name: $('#name').val(),
            instagram: $('#instagram').val(),
            email: $('#email').val(),
            text1: $('#text1').val(),
            text2: $('#text2').val()
        };

        // Send AJAX request to submit form data as JSON
        $.ajax({
            url: '/submitForm',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function (response) {
                // On success, show success alert
                showSuccessAlert();
                // Reset the form
                $('#contactForm')[0].reset();
            },
            error: function (error) {
                // Handle error scenarios
                console.error('Error:', error);
                var errorMessage = error.responseJSON ? error.responseJSON.message : 'There was an error submitting the form.';
                showErrorAlert(errorMessage);
            }
        });
    });
});
