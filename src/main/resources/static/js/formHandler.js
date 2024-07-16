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

        // Serialize form data
        var formData = $(this).serialize();

        // Send AJAX request to submit form data
        $.ajax({
            url: '/submitForm',
            type: 'POST',
            data: formData,
            success: function (response) {
                // On success, show success alert
                showSuccessAlert();
                // Reset the form
                $('#contactForm')[0].reset();
            },
            error: function (error) {
                // Handle error scenarios
                console.error('Error:', error);
                Swal.fire({
                    title: 'Error!',
                    text: 'There was an error submitting the form.',
                    icon: 'error',
                    confirmButtonText: 'OK'
                });
            }
        });
    });
});
