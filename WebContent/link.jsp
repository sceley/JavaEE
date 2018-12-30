<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>线段管理</title>
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
				<h2 class="title">线段管理</h2>
				<div class="clearfix">
					<a href="showCreateLink" class="btn btn-primary btn-sm float-right">添加</a>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">线段编号</th>
							<th scope="col">始点名称</th>
							<th scope="col">终点名称</th>
							<th scope="col">线段价格</th>
							<th scope="col">线段管理</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${links}" var="link">
							<tr>
								<td>${link.getLinkId()}</td>
								<td>${link.source.getStationName()}</td>
								<td>${link.destination.getStationName()}</td>
								<td>${link.getPrice()}</td>
								<td>
									<a class="btn btn-danger btn-sm"
									href="deleteLink?linkId=${link.getLinkId()}">删除</a>
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