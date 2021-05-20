<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Start</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script> <!-- 이걸 하면 태그안 이름 $로 표현 가능 -->
<script type="text/javascript">
	function checkID(){  /* submit을 사용하면 폼안에 모든 데이터를 처리하고 페이지 전환이 일어나지만 데이터 하나를 버튼(이벤트 처리(함수와 연결과 같이)하는 것이기 때문에 여러 데이터도 당연 가능 변수 두개세개)을 눌렀을 시 페이지를 전환하지 않고 바로 뜨게 하기 위해 ajax를 사용하는데 ID확인을 누르면 controller를 갔다 처리하고 여기로 다시 온다 */
		var id = $("#userId").val();
		alert('check '+id);
		$.ajax(
			{
	         type:"get",
	         url:"/rest/member/checkId.do", /* 이쪽으로 보내겠다 */
	         contentType:"application/json",
	         data :{"userId":id}, /* 이 데이터를 보내겠다 */
		    	 success:function (data,textStatus){ /* 성공하면 이쪽 */
		    	 	alert(data);
		    	 	var obj = JSON.parse(data);
		    	 	alert(obj.result);
		    	 	if(obj.result){
		    			 $('#message').text(id+" 사용불가능");
		    		 } else {
		    			 $('#message').text(id+" 사용가능");
		    		 } 
		 	    },
		     	error:function(data,textStatus){ /* 실패하면 이쪽 */
		       	 alert("에러가 발생했습니다.");
		  	   },
		  	   complete:function(data,textStatus){ /* 완료한 뒤 이거 실행 */
		    	 
		    	 }
			  }	
			);
			return false;
	}
</script>
</head>
<body>
	<form action="" method="">
		<input type="text" name="userId" id="userId">
		<input type="button" value="ID확인" onclick="checkID()"><br>
		<span id="message"></span><br>
		<input type="password" name="pwd" id="pwd">
		<input type="submit" value="회원가입">
	</form>
</body>
</html>