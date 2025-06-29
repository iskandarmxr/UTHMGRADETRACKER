$(document).ready(function() {
    $("#addCourse").click(function() {
        let index = $(".course-row").length;
        let newRow = $(
        `<div class="course-row row g-2 mb-2">
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
        </div>`);
        newRow.appendTo("#courseInputs");
    });

    $(document).on("click", ".remove-course", function() {
        $(this).closest(".course-row").remove();
    });
});