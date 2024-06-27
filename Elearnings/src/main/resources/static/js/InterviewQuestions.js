
 function uploadCourseId(){
  var courseId =document.getElementById("courseId").value;
    window.location.href = "/uploadCourseIds/" + courseId;
 }
 


 function viewUploadCourseId(){
  var courseId =document.getElementById("courseId").value;
    window.location.href = "/uploadCoursesId/" + courseId;
 }
 


 
 function uploadChapterId()
 {
	  var chapterId = document.getElementById("chapterId").value;   
	   alert("view chapter id is "+chapterId);
	   window.location.href="/viewChapterIds/"+chapterId;
 }
 
  function viewUploadChapterId()
 {
	  var chapterId = document.getElementById("chapterId").value;   
	   alert("View Chapter id"+chapterId);
	   window.location.href="/viewUplodChapterIds/"+chapterId;
 }
 
 
  function UploadTopicId()
  {
	    var topicId = document.getElementById("topicId").value;
	    
	    alert("Topic Id is "+topicId);
	    
	    window.location.href="/viewInterviewQuestionByTopicId/"+topicId;
  }
 
 
 		$('table').DataTable();

 
 
 