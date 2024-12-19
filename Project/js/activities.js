// Fetch API Data
async function fetchDataActivity() {
    try {
        const response = await fetch('http://localhost:8080/api/activity');
        if (!response.ok) throw new Error('Failed to fetch data');
        
        const data = await response.json();
        console.log(data); // Use the data in your UI
    } catch (error) {
        console.error('Error:', error);
    }
}
// Call the fetch function
fetchDataActivity();

// Fetch API Data
async function fetchDataPlanned() {
    try {
        const response = await fetch('http://localhost:8080/api/planned-activities');
        if (!response.ok) throw new Error('Failed to fetch data');
        
        const data = await response.json();
        console.log(data); // Use the data in your UI
    } catch (error) {
        console.error('Error:', error);
    }
}

// Call the fetch function
fetchDataPlanned();



function renderActivities() {
    const tbody = document.getElementById('activities-list');
    
    activities.forEach(activity => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${activity.type}</td>
            <td>${activity.date}</td>
            <td>${activity.time}</td>
            <td>${activity.location}</td>
            <td>${activity.currentPlayers}/${activity.requiredPlayers}</td>
            <td>
                <button class="btn-primary" onclick="joinActivity('${activity.id}')">
                    Join
                </button>
            </td>
        `;
        tbody.appendChild(tr);
    });
}

function joinActivity(id) {
    // Handle joining activity
    console.log('Joining activity:', id);
}

document.addEventListener('DOMContentLoaded', renderActivities);