<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>添加站点</title>
<link rel="stylesheet" href="assets/bootstrap.min.css">
<link rel="stylesheet" href="assets/trainsystem.css">
<script src="assets/jquery-3.3.1.min.js"></script>
</head>

<body>
	<%@ include file="./header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="./sider.jsp"%>
			<div class="col-md-8 px-md-5 py-md-3">
				<h2 class="title">添加站点</h2>
				<form action="createStation" method="POST">
					<div class="form-group">
						<label for="stationName">站点名称</label> <input type="text"
							class="form-control" name="stationName" id="stationName"
							placeholder="站点名称">
					</div>
					<button type="submit" class="btn btn-primary btn-sm">添加</button>
					<a class="btn btn-success btn-sm" href="javascript:history.go(-1);">返回</a>
				</form>
			</div>
		</div>
	</div>
</body>

</html>