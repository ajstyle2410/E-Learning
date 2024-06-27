

 function viewUploadCourseId()
 {
	   var courseId = document.getElementById("courseId").value;
	     
	    
	      var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("ChapterList").innerHTML = this.responseText;
                }
            };
            xhttp.open("POST", '/viewUploadCourseId/' + courseId, true);
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
 
 
 // *****************  view chapters ******************
 
  function viewUploadChapterId()
  {
	    var courseId = document.getElementById("chapterId").value;
	     
	     alert(courseId)
	      var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
					
					  alert(this.status)
                    document.getElementById("ChapterList").innerHTML = this.responseText;
                }
            };
            xhttp.open("POST", '/viewUploadCourseId/' + courseId, true);
            xhttp.send();
        }

        function  viewUploadChapterId() {
            var chapterId = document.getElementById("chapterId").value;
            
              alert("view chapter id "+chapterId)
            
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
					alert(this.status)
                    document.getElementById("Topic").innerHTML = this.responseText;
                }
            };
          
                xhttp.open("POST", '/viewUploadTopicID/' + chapterId, true);
            xhttp.send();
	   
  }
  
  
   function viewTopic(topicId)
   {
	    alert("Topic Id is "+topicId)
	      var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState == 4 && this.status == 200) {
					
					  alert(this.status)
                    document.getElementById("assignment").innerHTML = this.responseText;
                }
            };
            xhttp.open("POST", '/viewUploadAssignment/' + topicId, true);
            xhttp.send();
   }
  
  