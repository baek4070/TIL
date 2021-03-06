<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../../common/header.jsp"/>
<!-- qna_write.jsp -->
<section>
	<!-- enctype="application/x-www-form-urlencoded" > -->
	<!-- enctype 속성은 다음 세가지의 값으로 지정될 수 있다.
		1. application/www-form-urlencoded
		디폴트값이다. enctype을 따로 설정하지 않으면 이 값이 설정된다. 폼데이터는 서버로 전송되기 전에 URL-Encode 된다.
		
		2. multipart/form-data
		파일이나 이미지를 서버로 전송할 경우 이 방식을 사용한다.
		
		3. text/plain
		이 형식은 인코딩을 하지 않은 문자 상태로 전송한다. 
	-->
	<form action="boardWriteSubmit.bo" method="POST" enctype="multipart/form-data">
		<!-- 누가 작성하는지 알아야하니까 히든타입으로 로그인멤버 이름과 번호값을 같이 전송 -->
		<input type="hidden" name="qna_name" value="${member.name}"/>
		<input type="hidden" name="qna_writer_num" value="${member.num}"/>  
		<table>
			<tr>
				<td colspan="2"><h1>글 작성</h1></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${member.name}</td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td><input type="text" name="qna_title" required /></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td>
					<textarea id="editor" name="qna_content"></textarea>
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="qna_file"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성완료"/>
					<input type="reset" value="새로작성"/>
				</td>
			</tr>
		</table>
	</form>
</section>
<script src="https://cdn.tiny.cloud/1/82ubugvq9p4ukktpdfxo6tc3oglykfj5kh7u4xi5uh1sw4s3/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
<script>
	var plugins = ["textcolor", "link", "image","help"];
	var edit_toolbar = 'link image forecolor backcolor help';
	
    tinymce.init({
      language : "ko_KR", // 한글 판으로 변경
      width : 600,
      height : 500,
      menubar : false,
      selector: '#editor',
      plugins: plugins,
      toolbar: edit_toolbar,
      toolbar_mode: 'floating',
      tinycomments_mode: 'embedded',
      tinycomments_author: 'Author name',
      /* image upload */
      image_title : true,
      automatic_uploads : true,
      file_picker_types : "image",
      file_picker_callback : function(cb, value, meta){
    	  var input = document.createElement("input");
    	  input.setAttribute("type","file");
    	  input.setAttribute("accept","image/*");
    	  
    	  input.onchange = function(){
    		  var file = this.files[0];
    		  var reader  = new FileReader();
    		  reader.onload = function(){
   				var id = "blobid"  +(new Date()).getTime();
   				var blobCache = tinymce.activeEditor.editorUpload.blobCache;
   				var base64 = reader.result.split(',')[1];
   				var blobInfo = blobCache.create(id,file,base64);
   				blobCache.add(blobInfo);
   				cb(blobInfo.blobUri(),{title : file.name});
    		  };
    		  reader.readAsDataURL(file);
    	  };
    	  input.click();
      }
    /* image upload end */
    });
  </script>
<jsp:include page="../../common/footer.jsp"/>