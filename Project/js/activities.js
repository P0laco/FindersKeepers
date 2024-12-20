// Fetch API Data
async function fetchDataActivity() {
    try {
        const response = await fetch('http://localhost:8080/api/activity');
        if (!response.ok) throw new Error('Failed to fetch data');
        
        const data = await response.json(); 
        return data; // Return the data
      
    } catch (error) {
        console.error('Error:', error);
    }
}
// Call the fetch function


// Fetch API Data
async function fetchDataPlanned() {
    try {
        const response = await fetch('http://localhost:8080/api/planned-activities');
        if (!response.ok) throw new Error('Failed to fetch data');
        
        const data = await response.json();
        console.log(data); // Use the data in your UI
        return data;
    } catch (error) {
        console.error('Error:', error);
    }
}

// Call the fetch function


function renderActivities(activityData, plannedData) {
    const tbody = document.getElementById('activities-list');
    
    plannedData.forEach((plannedActivity, index) => {
        
        const activityName = index  < activityData.length ? activityData[index].name : activityData[index - 3].name;
        const date = plannedActivity.date;
        const time = plannedActivity.time;
        const location = plannedActivity.location;
        const numberOfPeople = plannedActivity.numberOfPeople;

        console.log(plannedData, "Aaaaaaaaa");
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${activityName}</td>
            <td>${date}</td>
            <td>${time}</td>
            <td>${location}</td>
            <td>${numberOfPeople}/${numberOfPeople}</td>
            <td>
                <button class="btn-primary" onclick="joinActivity('${plannedActivity.id}')">
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

document.addEventListener('DOMContentLoaded', async () => {
    const activityData =  await fetchDataActivity();
    const plannedData = await fetchDataPlanned();
    renderActivities(activityData, plannedData);
});