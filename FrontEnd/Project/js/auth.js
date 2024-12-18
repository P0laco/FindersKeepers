// Authentication related functions
function handleLogin(event) {
    event.preventDefault();
    
    const formData = new FormData(event.target);
    const data = Object.fromEntries(formData.entries());
    
    // Handle login logic here
    console.log('Login:', data);
    
    // Redirect to activities page after successful login
    navigateTo('activities.html');
}

function handleRegister(event) {
    event.preventDefault();
    
    const formData = new FormData(event.target);
    const data = Object.fromEntries(formData.entries());
    
    // Validate password match
    if (data.password !== data.confirmPassword) {
        alert('Passwords do not match');
        return;
    }
    
    // Handle registration logic here
    console.log('Register:', data);
    
    // Redirect to login page after successful registration
    navigateTo('login.html');
}