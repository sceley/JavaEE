<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加车次</title>
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
				<h2 class="title">添加车次</h2>
				<form action="createTrain" method="POST">
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="trainNumber">车次编号</label> <input type="text"
									class="form-control" name="trainNumber" id="trainNumber"
									placeholder="车次编号">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="source">起始站点</label> <select class="form-control"
									id="source" placeholder="起始站点" name="source.stationId">
									<c:forEach items="${stations}" var="station">
										<option value="${station.getStationId()}">${station.getStationName() }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label for="center">中间站点</label>
								<select class="form-control"
									id="center" placeholder="中间站点" name="center.stationId">
									<c:forEach items="${stations}" var="station">
										<option value="${station.getStationId()}">${station.getStationName() }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label for="destination">终止站点</label>
								<select
									class="form-control" id="destination" placeholder="终止站点"
									name="destination.stationId">
									<c:forEach items="${stations}" var="station">
										<option value="${station.getStationId()}">${station.getStationName() }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="centerTime">中间站停留时间</label> <input type="text"
									class="form-control" name="centerTime" id="centerTime"
									placeholder="中间站点停留时间">
							</div>
						</div>
						<div class="col-4">
							<div class="form-group">
								<label for="time">经历时间</label> <input type="text"
									class="form-control" name="time" id="time" placeholder="经历时间">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-4">
							<div class="form-group">
								<label for="capacity">乘客容量</label> <input type="text"
									class="form-control" name="capacity" id="capacity"
									placeholder="乘客容量">
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