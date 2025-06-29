window.addEventListener("DOMContentLoaded", function () {
    console.log("script.js loaded");

    const addBtn = document.getElementById("addCourse");
    const container = document.getElementById("courseInputs");

    if (!addBtn || !container) {
        console.error("Missing #addCourse or #courseInputs in DOM");
        return;
    }

    addBtn.addEventListener("click", function () {
        const index = container.querySelectorAll(".course-row").length;
        const newRow = document.createElement("div");
        newRow.classList.add("course-row", "row", "g-2", "mb-2");
        newRow.innerHTML = `
            <div class="col">
                <input type="text" name="courseList[${index}].courseName" class="form-control" placeholder="Course Name (optional)">
            </div>
            <div class="col">
                <input type="text" name="courseList[${index}].grade" class="form-control" placeholder="Grade (e.g. A, B+)" required>
            </div>
            <div class="col">
                <input type="number" name="courseList[${index}].creditHour" class="form-control" placeholder="Credit Hour" step="0.5" required>
            </div>
            <div class="col-auto">
                <button type="button" class="btn btn-danger remove-course">Delete</button>
            </div>
        `;
        container.appendChild(newRow);
    });

    container.addEventListener("click", function (e) {
        if (e.target.classList.contains("remove-course")) {
            const row = e.target.closest(".course-row");
            if (row) row.remove();
        }
    });
});