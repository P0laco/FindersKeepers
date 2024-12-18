// Join activity related functions
function loadActivityDetails() {
    // Mock activity data (replace with actual data fetching)
    const activity = {
        id: '1',
        type: 'Football',
        date: '2024-03-20',
        time: '18:00',
        location: 'Central Park',
        requiredPlayers: 10,
        currentPlayers: 6
    };

    // Update UI with activity details
    document.getElementById('activity-type').textContent = activity.type;
    document.getElementById('activity-datetime').textContent = 
        `${activity.date} at ${activity.time}`;
    document.getElementById('activity-location').textContent = activity.location;
    document.getElementById('activity-players').textContent = 
        `${activity.currentPlayers}/${activity.requiredPlayers} players`;
}

function handleJoinActivity(event) {
    event.preventDefault();
    
    const formData = new FormData(event.target);
    const data = Object.fromEntries(formData.entries());
    
    // Handle join activity logic here
    console.log('Joining activity:', data);
    
    // Redirect to activities page after successful join
    navigateTo('activities.html');
}

// Load activity details when the page loads
document.addEventListener('DOMContentLoaded', loadActivityDetails);