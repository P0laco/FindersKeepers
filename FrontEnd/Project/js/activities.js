const activities = [
    {
        id: '1',
        type: 'Football',
        date: '2024-03-20',
        time: '18:00',
        location: 'Central Park',
        requiredPlayers: 10,
        currentPlayers: 6
    },
    {
        id: '2',
        type: 'Basketball',
        date: '2024-03-21',
        time: '19:30',
        location: 'Sports Center',
        requiredPlayers: 8,
        currentPlayers: 4
    }
];

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