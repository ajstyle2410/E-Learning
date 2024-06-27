
function uploadCourseId()
{
	var courseId = document.getElementById("courseId").value;
	alert(courseId)
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
            alert(chapterId)
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("assignment").innerHTML = this.responseText;
                }
            };
          
                xhttp.open("POST", '/viewUploadChapterID/' + chapterId, true);
        
            xhttp.send();
	   
	   
 }
 