
function UploadCourseId() {
	var courseId = document.getElementById("courseId").value;

	var http = new XMLHttpRequest();
	http.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			document.getElementById("Chapter").innerHTML = this.responseText;
		}
	};

	http.open("POST", '/uploadCourseByTopic/'+courseId, true);
	http.send();

}

function UploadChapterId(chapterId)
{
	      
	      var http = new XMLHttpRequest();
	      http.onreadystatechange=function()
	      {
			   if(this.readyState==4 && this.status== 200)
			   {
				    document.getElementById("TopicPage").innerHTML=this.responseText;
			   }
		  };
		  http.open("POST",'/uploadChpaerByTopic/'+chapterId,true);
		  http.send();
}




$('table').DataTable();