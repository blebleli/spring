<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>     

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	mvc/valid/view.jsp :${errorMsg }
	
	<spring:hasBindErrors name="validVo"/>
	<spring:hasBindErrors name="validjsr303Vo"/>
	
	<form action="/valid/submit" method="post">
		userId : <input type="text" name="userId" value="brown"><form:errors path="validVo.userId"/><br>
		name   :  <input type="text" name="name" value="브라운"><form:errors path="validVo.name"/><br>
		password : <input type="password" name="password" value=""><form:errors path="validVo.password"/><br>
		<input type="submit" value="전송"><br>
		
	</form>
	
	
	<h3> jsr303 validator</h3>
	<form action="/valid/submit/jsr303" method="post">
		userId : <input type="text" name="userId" value="brown"><form:errors path="validjsr303Vo.userId"/><br>
		name   :  <input type="text" name="name" value="브라운"><form:errors path="validjsr303Vo.name"/><br>
		password : <input type="password" name="password" value=""><form:errors path="validjsr303Vo.password"/><br>
		<input type="submit" value="전송"><br>
	</form>
	
	
	<h3>spring validator + jsr303(@valid)</h3>	
	<form action="/valid/submit" method="post">
		userId : <input type="text" name="userId" value="brown"><form:errors path="validVo.userId"/><br>
		name   :  <input type="text" name="name" value="브라운"><form:errors path="validVo.name"/><br>
		password : <input type="password" name="password" value=""><form:errors path="validVo.password"/><br>
		<input type="submit" value="전송"><br>
		
	</form>	

		
</body>
</html>