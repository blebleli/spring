<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>

$(document).ready(function(){
	$("select[name=language]").on("change", function(){
		console.log($(this).val());
		$("form").submit;
	});
});

</script>

 <!-- 
 location.href="/localeSelect?lng="+langu;
 라벨 properties 맞춰 변경되도록하기 
 	tablib tags로 주고 ,
 -->
	<spring:message code="userId"/> : <input type="text" name="userId"><br>
	<spring:message code="password"/>  : <input type="text" name="password"><br>
	
	
	<h3>localeChange</h3>
	
	<form action="/locale/view"> <!-- 호출한 자신에게 보낸다 -->
		<select name="language">
			<c:forEach items="${localeMap }" var="locale">
				<option value="${locale.key}"> ${locale.value}</option>
			</c:forEach>	
		</select> <br>
	</form>
	
	
</body>
</html>

<!-- jquery 를 활용하여 select box 변경시 submit 이 되도록 수정
select box가 현재 locale로 selected 되도록 수정 -->
