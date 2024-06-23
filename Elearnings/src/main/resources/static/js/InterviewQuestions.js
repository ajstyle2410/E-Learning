
 function uploadCourseId(){
  var courseId =document.getElementById("courseId").value;
    window.location.href = "/uploadCourseIds/" + courseId;
 }
 
 
 function uploadChapterId()
 {
	  var chapterId = document.getElementById("chapterId").value;   
	   alert("chapter id is "+chapterId);
	   window.location.href="/uplodChapterIds/"+chapterId;
 }