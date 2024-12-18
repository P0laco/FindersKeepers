function handleCreateActivity(event) {
    event.preventDefault();
    
    const formData = new FormData(event.target);
    const data = Object.fromEntries(formData.entries());
    
    // Handle form submission
    console.log('Creating activity:', data);
    
    // Redirect to activities page
    navigateTo('activities.html');
}