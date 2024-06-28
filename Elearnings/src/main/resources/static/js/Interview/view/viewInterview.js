
function viewUploadCourseId() {
	var courseId = document.getElementById("courseId").value;
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("SelectChapter").innerHTML = this.responseText;
		}
	};

	xhttp.open("POST", '/sendUploadCourseId/' + courseId, true);

	xhttp.send();

}

function viewUploadChapterId() {

	var chapterId = document.getElementById("chapterId").value;
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("Topics").innerHTML = this.responseText;
		}
	};

	xhttp.open("POST", '/uploadChapterWiseTopicQuestions/' + chapterId, true);

	xhttp.send();

}

function viewTopic(topicId) 
{
	var http = new XMLHttpRequest();
	alert("Topic Id " + topicId)
	http.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			alert(this.status)
			document.getElementById("InterviewQuestion").innerHTML = this.responseText;
		}
	};
	http.open("POST", '/uploadTopicId/' + topicId, true);
	http.send();
}

