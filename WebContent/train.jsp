<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>车次管理</title>
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
				<h2 class="title">车次管理</h2>
				<div class="clearfix">
					<a href="showCreateTrain"
						class="btn btn-primary btn-sm float-right">添加</a>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">车次编号</th>
							<th scope="col">起始站点</th>
							<th scope="col">中间站点</th>
							<th scope="col">终点站点</th>
							<th scope="col">中间站停留时间</th>
							<th scope="col">经历时间</th>
							<th scope="col">乘客容量</th>
							<th scope="col">车次管理</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${trains}" var="train">
							<tr>
								<td>${train.getTrainNumber()}</td>
								<td>${train.source.getStationName()}</td>
								<td>${train.center.getStationName()}</td>
								<td>${train.destination.getStationName()}</td>
								<td>${train.getCenterTime()}</td>
								<td>${train.getTime()}</td>
								<td>${train.getCapacity()}</td>
								<td><a class="btn btn-danger btn-sm"
									href="deleteTrain?trainId=${train.getTrainId()}">删除</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>