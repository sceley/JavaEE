<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>火车系统</title>
<link rel="stylesheet" href="assets/bootstrap.min.css">
<link rel="stylesheet" href="assets/trainsystem.css">
<script src="assets/jquery-3.3.1.min.js"></script>
</head>

<body>
	<%@ include file="./header.jsp"%>
	<div class="container-fluid py-md-3 px-md-5">
		<form action="queryTrain" method="POST">
			<div class="form-row">
				<div class="col">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<span class="input-group-text">出发地</span>
						</div>
						<input type="text" name="startStation.StationName"
							class="form-control" placeholder="出发地">
					</div>
				</div>
				<div class="col">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<span class="input-group-text">目的地</span>
						</div>
						<input type="text" name="endStation.StationName"
							class="form-control" placeholder="目的地">
					</div>
				</div>
				<div class="col">
					<div class="input-group mb-2">
						<div class="input-group-prepend">
							<span class="input-group-text">出发日期</span>
						</div>
						<input type="date" name="date" class="form-control"
							placeholder="出发日期">
					</div>
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary">查询</button>
					<!-- <button type="submit" class="btn btn-success">高级查询</button> -->
				</div>
			</div>
		</form>
		<c:if test="${querys.size() > 0}">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th scope="col">车次编号</th>
						<th scope="col">出发站点</th>
						<th scope="col">到达站点</th>
						<th scope="col">列车站点</th>
						<th scope="col">中间站停留时间</th>
						<th scope="col">经历时间</th>
						<th scope="col">乘客容量</th>
						<th scope="col">票价</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${querys}" var="query">
						<tr>
							<td>${query.getTrainNumber()}</td>
							<td>${query.startStation.getStationName()}</td>
							<td>${query.endStation.getStationName()}</td>
							<td>${query.source.getStationName()} ->
								${query.center.getStationName()} ->
								${query.destination.getStationName()}</td>
							<td>${query.getCenterTime()}</td>
							<td>${query.getTime()}</td>
							<td>${query.getCapacity()}</td>
							<td>${query.getPrice()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>

</html>