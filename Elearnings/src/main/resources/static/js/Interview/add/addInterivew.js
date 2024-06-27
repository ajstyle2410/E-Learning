
function uploadCourseId()
{
	var courseId = document.getElementById("courseId").value;
	     var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("SelectChapter").innerHTML = this.responseText;
                }
            };
          
                xhttp.open("POST", '/uploadCourseId/' + courseId, true);
        
            xhttp.send();
	
}




        function  UploadChapterId() {
            var chapterId = document.getElementById("chapterId").value;
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("SelectTopic").innerHTML = this.responseText;
                }
            };
          
                xhttp.open("POST", '/UploadChapterId/' + chapterId, true);
        
            xhttp.send();
	   
	   
 }
 
 
 function viewTopic(TopicId)
 {
	 
	  var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("addInterviewQuestion").innerHTML = this.responseText;
                }
            };
          
                xhttp.open("POST", '/UploadTopicId/' + TopicId, true);
        
            xhttp.send();
	   
 }
 