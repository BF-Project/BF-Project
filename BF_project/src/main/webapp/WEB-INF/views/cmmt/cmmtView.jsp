<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<!-- <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->


<script>
	function goUpdate(cmmt_num) {
		document.formm.action = "update?cmmt_num=" + cmmt_num;
		document.formm.submit();
	}

	/*삭제  */
	function goDelete(cmmt_num) {
		document.formm.action = "delete?cmmt_num=" + cmmt_num;
		document.formm.submit();
	}
</script>

<script>
$(document).ready(function() {
    var cmmt_num = $('#cmmt_num').val();
    var data ={'cmmt_num' : cmmt_num};
    
    $.ajax({
       url:'<%=request.getContextPath()%>/cmmtcmt/cmmtcmtList',
       contentType:'application/json',
       dataType:'json',
       data:JSON.stringify(data),
       type:'post',
       success : function(data){
          $.each(data, function(i) {
             var date = new Date(
                   data[i].cmmtcmt_date);
             var year = date.getFullYear();
             var month = (1 + date.getMonth());
             month = month >= 10 ? month : '0'
                   + month;
             var day = date.getDate();
             day = day >= 10 ? day : '0' + day;
             var fullD = year + '년' + month
                   + '월' + day + '일';
             var cmmtcmtList1 = '<div id="'
	         	   + data[i].cmmtcmt_num	
	         	   + '">아이디 : '
	               + data[i].mbr_id
	               + '  /  ' + '작성 날짜 : '
				   + fullD
				   +'<a href="" id="'
	               +data[i].cmmtcmt_num
	               +'" ' 
	               +'class="cmmtcmt" name="cmmtcmt">삭제</a>'
				   + '<div>  ->'
	               + data[i].cmmtcmt_content
	               +'</div></div><br><br>';
             $('div#comment').append(cmmtcmtList1);
          });          
       },
       error:function(error){
    	alert(error);   
       }
    });
});

function commm_go() {
	var cmmt_num = $('#cmmt_num').val();
    var cmmtcmt_content = $('#cmmtcmt_content').val();
    var dataWrite = {
       'cmmt_num' : cmmt_num,
       'cmmtcmt_content' : cmmtcmt_content
    };
    $.ajax({
       url : '<%=request.getContextPath()%>/cmmtcmt/cmmtcmtWrite',
	   data : JSON.stringify(dataWrite),
	   type : 'post',
	   contentType : 'application/json',
	   success : function(data) {
	      $('#cmmtcmt_content').val('');
	      $('div #comment').empty();
	      $.each(data, function(i) {
	         var date = new Date(data[i].cmmtcmt_date);
	         var year = date.getFullYear();
	         var month = (1 + date.getMonth());
	         month = month >= 10 ? month : '0' + month;
	         var day = date.getDate();
	         day = day >= 10 ? day : '0' + day;
	         var fullD = year + '년' + month + '월' + day + '일';
	         var cmmtcmtList1 = '<div id="'
	         	   + data[i].cmmtcmt_num	
	         	   + '">아이디 : '
	               + data[i].mbr_id
	               + '  /  ' + '작성 날짜 : '
				   + fullD
				   +'<a href="" id="'
	               +data[i].cmmtcmt_num
	               +'" ' 
	               +'class="asd" name="asd">삭제</a>'
				   + '<div>  ->'
	               + data[i].cmmtcmt_content
	               +'</div></div><br><br>';
	         $('div #comment').append(cmmtcmtList1);
	      });
	   },
	   error : function() {
	      alert('댓글 등록 실패');
	   }
	});
}

$(document).on('click','.cmmtcmt',function(e){
    e.preventDefault();
    var result = $(this).attr('id');
    $.ajax({
       url:"<%=request.getContextPath()%>/cmmtcmt/cmmtcmtDelete",
       data: {"result" : result},
       dataType:'json',
       type:'post',
       
       success:function(map1){
          cmmtcmtMap = jQuery.map(map1 , function(a){
             return a;
          })
          $('#'+cmmtcmtMap).remove();
       }
    });
 });
</script>


<style>
#freeView {
	margin: auto;
	width: 70%;
}

#mod, del, list {
	margin-left: 28.9999%;
}
</style>
</head>
<body>
	<!-- PRELOADER -->
	<img id="preloader"
		src="<%=request.getContextPath()%>/resources/images/preloader.gif"
		alt="" />
	<!-- 로딩 이미지 -->

	<!-- //PRELOADER -->
	<div class="preloader_hide">
		<div class="qnaHeader">

			<!-- BREADCRUMBS -->
			<section class="breadcrumbs_block clearfix parallax">
				<div class="container center">
					<h2>
						<b>FREE</b> BOARD
					</h2>
					<br> <br>
					<p>'자유게시판' 페이지 입니다.</p>
				</div>
			</section>
			<!-- //BREADCRUMBS -->
			<br>
			
		<form name="formm" method="post" action="cmmtView">
				<div class="container">
					<table class="table table-hover" id="cmmtView1">
						<tr>
							<th>제목</th>
							<td>${cmmtVO.cmmt_title}</td>
						</tr>

						<tr>
							<th>내용</th>
							<td>${cmmtVO.cmmt_content}</td>
						</tr>

						<tr>
							<th>작성자</th>
							<td>${cmmtVO.mbr_id}</td>
						</tr>

						<tr>
							<th>게시날짜</th>
							<td>${cmmtVO.cmmt_date}</td>
						</tr>
						
						<tr>
						<th>사진첨부</th>
						<td>
						<img src="<%=request.getContextPath() %>/resources/upload/${cmmtVO.cmmt_pict_afat}" width="200pt"> 
						</td>
						
					</tr>
					
					</table>
				</div>
				<br>
				<%-- <input type="button" value="수정하기" onclick="goUpdate('${qnaVO.qna_num}')"> --%>
				<c:choose>
					<c:when test="${cmmtVO.mbr_id==sessionScope.loginUser }">
						<!-- 수정  -->
						<button type="button" id="mod" class="btn"
							onclick="goUpdate('${cmmtVO.cmmt_num}')"
							style="color: white; background-color: black;">수정</button>
						<!-- 삭제  -->
						<button type="button" id="del" class="btn"
							onclick="goDelete('${cmmtVO.cmmt_num}')"
							style="color: white; background-color: black;">삭제</button>
						<!-- 목록 -->
						<button type="button" id="list" class="btn"
							onclick="location.href='cmmtList'"
							style="color: white; background-color: black;">목록</button>
					</c:when>
					<c:otherwise>
						<button type="button" id="list2" class="btn"
							onclick="location.href='cmmtList'"
							style="color: white; background-color: black;">목록</button>
					</c:otherwise>
				</c:choose>
				
				

				<div id="comment"></div>
				<input type="hidden" value="${cmmtVO.cmmt_num }" id="cmmt_num" name="cmmt_num"> 
				댓글 : <input type="text" id="cmmtcmt_content" name="cmmtcmt_content"> 
				<input type="button" id="insertCmt" name="insertCmt" value="등록" onclick="commm_go();">
			
			</form>
		</div>
	</div>


</body>
</html>