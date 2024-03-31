document.addEventListener('DOMContentLoaded', function() {
    // Add event listener to the login form submission
    document.getElementById('login-form').addEventListener('submit', function(event) {
        event.preventDefault(); // Prevent form submission
        
        // Get username and password values
        var username = document.getElementById('username').value;
        var password = document.getElementById('password').value;
        
        // Perform validation here if needed
        
        // For demonstration purpose, log the username and password to the console
        console.log('Username:', username);
        console.log('Password:', password);
        
        // Submit the form (replace this with your actual form submission logic)
        this.submit();
    });
});
