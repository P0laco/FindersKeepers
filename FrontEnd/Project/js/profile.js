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
