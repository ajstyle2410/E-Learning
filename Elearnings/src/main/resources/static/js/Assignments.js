function viewUploadCourseId() {
    var courseId = document.getElementById("courseId").value;

    var xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // Update the content of the specified <div> element with the response
            document.getElementById("table").innerHTML = this.responseText;
        }
    };

    xhttp.open("POST", '/viewUploadCourseId/' + courseId, true);
    xhttp.send();
}
