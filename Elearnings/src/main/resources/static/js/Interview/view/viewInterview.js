
function viewUploadCourseId()
{
	var courseId = document.getElementById("courseId").value;
	alert(courseId)
	     var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("SelectChapter").innerHTML = this.responseText;
                }
            };
          
                xhttp.open("POST", '/sendUploadCourseId/' + courseId, true);
        
            xhttp.send();
	
}

function viewUploadChapterId()
{
	
}