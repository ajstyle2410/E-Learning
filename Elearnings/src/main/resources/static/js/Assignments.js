  function viewUploadCourseId() {
            var courseId = document.getElementById("courseId").value;
            var con = document.getElementById("con").value;

            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("table").innerHTML = this.responseText;
                }
            };
            xhttp.open("POST", '/viewUploadCourseId/' + courseId, true);
            xhttp.send();
        }

        function viewUploadChapterId() {
            var chapterId = document.getElementById("chapterId").value;
            var con = document.getElementById("con").value;
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("viewAssignments").innerHTML = this.responseText;
                }
            };
            if (con > 0) {
                xhttp.open("POST", '/UploadChapterID/' + chapterId, true);
            } else {
                xhttp.open("POST", '/viewUploadChaptersID/' + chapterId, true);
            }
            xhttp.send();
        }  
        
        $('table').DataTable();
