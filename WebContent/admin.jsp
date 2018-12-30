<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link rel="stylesheet" href="assets/bootstrap.min.css">
<link rel="stylesheet" href="assets/trainsystem.css">
<script src="assets/jquery-3.3.1.min.js"></script>
</head>

<body>
	<%@ include file="./header.jsp"%>
	<div class="container-fluid py-md-3 px-md-5">
		<div class="admin-form">
			<h1 class="title">管理员登录</h1>
			<p class="text-danger">${failureMsg}</p>
			<form action="loginAdmin" method="POST">
				<div class="form-group">
					<label for="username">用户名:</label> <input type="text"
						class="form-control" name="username" id="username"
						placeholder="用户名">
				</div>
				<div class="form-group">
					<label for="password">密码:</label> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="密码">
				</div>
				<div class="btn-area">
					<button type="submit" class="btn btn-primary">登录</button>
				</div>
			</form>
		</div>
	</div>
</body>

</html>