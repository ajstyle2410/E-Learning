function UploadCourseId() {
    var courseId = document.getElementById("courseId").value;
    
    var http = new XMLHttpRequest();
    http.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("viewChapter").innerHTML = this.responseText;
            // Initialize DataTable after content is loaded
            $(document).ready(function() {
                $('table').DataTable();
            });
        }
    };
    http.open("POST", '/CourseId/' + courseId, true);
    http.send();
}


const UploadChapterId=(chapterId)=>{



    var http = new XMLHttpRequest();
    http.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("viewTopic").innerHTML = this.responseText;
            // Initialize DataTable after content is loaded
            $(document).ready(function() {
                $('table').DataTable();
            });
        }
    };
    http.open("POST", '/TopicChapterId/' + chapterId, true);
    http.send();
}
