<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.studentDAO"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allcss.jsp"%>
</head>
<body class="bg-light">

	<%@include file="navbar.jsp"%>


	<div class="container p-5">
		<div class="card">
			<div class="card-body">

				<p class="text-center fs-1">All Student Details</p>
				<c:if test="${ not empty succMsg}">
					<p class="text-center text-success fs-5">${succMsg }</p>
					<c:remove var="succMsg" />
				</c:if>

				<c:if test="${ not empty FMsg}">
					<p class="text-center text-danger fs-5">${FMsg }</p>
					<c:remove var="FMsg" />
				</c:if>

				<table class="table table-responsive">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Date of Birth</th>
							<th scope="col">Address</th>
							<th scope="col">Qualification</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<%
						studentDAO dao = new studentDAO(DBConnect.getConn());
						List<Student> list = dao.getAllStudents();

						for (Student s : list) {
						%>
						<tr>
							<td><%=s.getFname()%></td>
							<td><%=s.getDob()%></td>
							<td><%=s.getAdd()%></td>
							<td><%=s.getQual()%></td>
							<td><%=s.getEmail()%></td>
							<td><a href="edit.jsp?id=<%=s.getId()%>"
								class="btn btn-sm btn-primary">Edit</a> <a
								href="delete?id=<%=s.getId()%>"
								class="btn btn-sm btn-danger ms-1">Delete</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
				<br>
			</div>
		</div>
	</div>
</body>

</html>