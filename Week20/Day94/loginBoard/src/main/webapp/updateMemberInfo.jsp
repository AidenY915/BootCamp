<%@page import="com.loginboard.www.daodto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="UpdateMemberInfoOK.do">
		<div>
			<div>이름</div>
			<input type='text' name='name' value = '${member.name}'>
		</div>
		<div>
			<div>아이디</div>
			<input type='text' value = '${member.id}' disabled>
			<button>중복 확인</button>
		</div>
		<div>
			<div>닉네임</div>
			<input type='text' name='nickname' value = '${member.nickname}'>
		</div>
		<div>
			<div>비밀번호</div>
			<input type='password' name='password'>
		</div>
		<div>
			<div>비밀번호 확인</div>
			<input type='password' name='passwordCheck'>
		</div>
		<div>
			<div>이메일</div>
			<input type='email' name='email' value = '${member.email}'>
		</div>
		<div>
			<div>주소</div>
			<input type="text" id="postNum" placeholder="우편번호" value = '${member.postNum}'>
			<input type="button" onclick="execDaumPostcode()"
				value="우편번호 찾기"
			><br> <input type="text" id="roadAddress" 
				placeholder="도로명주소"
			> <input type="text" id="jibunAddress" placeholder="지번주소">
			<span id="guide" style="color: #999; display: none"></span> <input
				type="text" id="detailAddress" placeholder="상세주소" name = 'detailAddress'
			> <input type="text" id="extraAddress" placeholder="참고항목">
		</div>
		<div>
			<div>생년월일</div>
			<input type="text" name='birthday' value = '${birthdayYear}'> 
			<select name='birthday'>
				<c:forEach begin = '1' end = '12' varStatus = 'status'>
					<c:set var = 'month' value = '${status.index < 10 ? "0"+=status.index : status.index}'/>
					<option value = '${month}' ${birthdayMonth == month ? "selected" : ""}>${status.index}</option>
				</c:forEach>
			</select> 
			<input type="text" name='birthday' value = '${birthdayDate}'>
		</div>
		<div>
			<div>전화번호</div>
			<input type='text' name='phone' value = '${member.phone}'>
		</div>
		<div>
			<div>성별</div>
			<input type='radio' name='sex' value = '1' ${member.sex == 1 ? "checked" : ""}><label>남</label><input
				type='radio' name='sex' value = '2' ${member.sex == 2 ? "checked" : ""}
			><label>여</label>
		</div>
		<button>정보수정</button>
		<a href='login.do'><button type='button'>취소</button></a>
	</form>



	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"
	></script>
	<script>
	function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postNum').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
	</script>
</body>
</html>