  function UploadCourseId() {
            var courseId = document.getElementById("courseId").value;
       
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("table").innerHTML = this.responseText;
                }
            };
            xhttp.open("POST", '/UploadCourseId/' + courseId, true);
            xhttp.send();
        }

        function UploadChapterId() {
            var chapterId = document.getElementById("chapterId").value;
            
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("assignment").innerHTML = this.responseText;
                }
            };
          
                xhttp.open("POST", '/UploadChapterID/' + chapterId, true);
        
            xhttp.send();
        } 
        
       function uploadTopic(topicId) {
      
            alert(topicId)
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
					alert(this.status)
                    document.getElementById("bulkAssignment").innerHTML = this.responseText;
                }
            };
                      alert(topicId)

                xhttp.open("POST", '/uploadBulkAssignments/' + topicId, true);
        
            xhttp.send();
    
    
}

  		$('table').DataTable();

