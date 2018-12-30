<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>添加线段</title>
<link rel="stylesheet" href="assets/bootstrap.min.css">
<link rel="stylesheet" href="assets/trainsystem.css">
<script src="assets/jquery-3.3.1.min.js"></script>
</head>

<body>
	<%@ include file="./header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="./sider.jsp"%>
			<div class="col-md-8 py-md-3 px-md-5">
				<h2 class="title">添加线段</h2>
				<form action="createLink" method="POST">
					<div class="row">
						<div class="col-6">
							<div class="form-group">
								<label for="src">起始站点</label> <select class="form-control"
									id="src" placeholder="起始站点" name="source.stationId">
									<c:forEach items="${stations}" var="station">
										<option value="${station.getStationId()}">${station.getStationName() }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-6">
							<div class="form-group">
								<label for="src">结束站点</label> <select class="form-control"
									id="src" placeholder="结束站点" name="destination.stationId">
									<c:forEach items="${stations}" var="station">
										<option value="${station.getStationId()}">${station.getStationName() }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<div class="form-group">
								<label for="price">线段价格</label> <input type="text"
									class="form-control" id="price" name="price" placeholder="线段价格">
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary btn-sm">添加</button>
					<a class="btn btn-success btn-sm" href="javascript:history.go(-1);">返回</a>
				</form>
			</div>
		</div>
	</div>
</body>

</html>