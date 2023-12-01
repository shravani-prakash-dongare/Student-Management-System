<%@page import="com.entity.Student"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.studentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allcss.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>
	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Student</p>
						<%
						int id=Integer.parseInt(request.getParameter("id"));
						studentDAO dao=new studentDAO(DBConnect.getConn());
						Student s =dao.getStudentById(id);
						
						
						%>
						<form action="update" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name </label> <input
									type="text" class="form-control" value="<%=s.getFname() %>" name="name">
							</div>
							<div class="mb-3">
								<label class="form-label">Date of Birth</label> <input
									type="date" class="form-control" name="dob" value="<%=s.getDob()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Address</label> <input
									type="text" class="form-control" name="address" value="<%=s.getAdd()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Qualification</label> <input
									type="text" class="form-control" name="qual" value="<%=s.getQual()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input
									type="email" class="form-control" name="email" value="<%=s.getEmail()%>">
							</div>
							<input  type="hidden" name="id" value="<%=s.getId()%>">
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>