function uploadCourseId() {
    alert("Function called....");

    var courseId = document.getElementById("courseId").value;
    alert("Selected Course ID: " + courseId);

    var httpData = new XMLHttpRequest();

    httpData.onreadystatechange = function () {
        if (this.readyState == 4) {
            if (this.status == 200) {
                alert("Response received: " + this.responseText);
                document.getElementById("courseIdds").innerHTML = this.responseText;
                // Optionally, you can process the response to update the page dynamically here
            } else {
                console.error("Error: " + this.status);
            }
        }
    };

    httpData.open("POST", "/viewChapters/" + courseId, true);
    httpData.send();
}
