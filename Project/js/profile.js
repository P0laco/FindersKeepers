// Fetch API Data
async function fetchDataUser() {
    try {
        const response = await fetch('http://localhost:8080/api/user');
        if (!response.ok) throw new Error('Failed to fetch data');
        
        const data = await response.json();
        console.log(data); // Use the data in your UI
    } catch (error) {
        console.error('Error:', error);
    }
}

// Call the fetch function
fetchDataUser();

// Fetch API Data
async function fetchDataParticipants() {
    try {
        const response = await fetch('http://localhost:8080/api/activity-participants');
        if (!response.ok) throw new Error('Failed to fetch data');
        
        const data = await response.json();
        console.log(data); // Use the data in your UI
    } catch (error) {
        console.error('Error:', error);
    }
}

// Call the fetch function
fetchDataParticipants();







// Evento de delete de atividades
document.addEventListener("DOMContentLoaded", function () {
    const deleteButtons = document.querySelectorAll(".delete-btn");

    deleteButtons.forEach(button => {
        button.addEventListener("click", function () {
            const row = button.closest("tr");
            if (confirm("Are you sure you want to delete this activity?")) {
                row.remove();
            }
        });
    });
});

// Modal elements
const openFormBtn = document.getElementById("openFormBtn");
const closeFormBtn = document.getElementById("closeFormBtn");
const activityFormModal = document.getElementById("activityFormModal");
const newActivityForm = document.getElementById("newActivityForm");

// Abrir modal
openFormBtn.addEventListener("click", () => {
    activityFormModal.style.display = "block";
});

// Fechar modal
closeFormBtn.addEventListener("click", () => {
    activityFormModal.style.display = "none";
});

// Submissão do formulário
newActivityForm.addEventListener("submit", (e) => {
    e.preventDefault();

    // Captura os valores do formulário
    const type = document.getElementById("activityType").value;
    const date = document.getElementById("activityDate").value;
    const time = document.getElementById("activityTime").value;
    const location = document.getElementById("activityLocation").value;
    const peopleNeeded = document.getElementById("activityPeople").value;

    // Adicionar nova linha na tabela
    const table = document.querySelector(".activities-list table tbody");
    const newRow = table.insertRow();

    newRow.innerHTML = `
        <td>${type}</td>
        <td>${date}</td>
        <td>${time}</td>
        <td>${location}</td>
        <td>${peopleNeeded}</td>
        <td><button class="delete-btn">Delete</button></td>
    `;

    // Adicionar funcionalidade ao botão delete
    const deleteButton = newRow.querySelector(".delete-btn");
    deleteButton.addEventListener("click", function () {
        if (confirm("Are you sure you want to delete this activity?")) {
            newRow.remove();
        }
    });

    // Fechar modal e limpar formulário
    activityFormModal.style.display = "none";
    newActivityForm.reset();
});
