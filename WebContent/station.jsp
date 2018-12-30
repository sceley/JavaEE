<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>站点管理</title>
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
				<h2 class="title">站点管理</h2>
				<div class="clearfix">
					<a href="showCreateStation"
						class="btn btn-primary btn-sm float-right">添加</a>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">站点编号</th>
							<th scope="col">站点名称</th>
							<th scope="col">站点管理</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stations}" var="station">
							<tr>
								<td>${station.getStationId()}</td>
								<td>${station.getStationName()}</td>
								<td><a class="btn btn-danger btn-sm"
									href="deleteStation?stationId=${station.getStationId()}">删除</a>
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