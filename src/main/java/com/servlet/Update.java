package com.servlet;
import java.io.IOException;

import com.dao.studentDAO;
import com.db.DBConnect;
import com.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/update")
public class Update extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String add=req.getParameter("address");
		String qual=req.getParameter("qual");
		String email=req.getParameter("email");
		int id=Integer.parseInt(req.getParameter("id"));
		
		Student student=new Student(id,name,dob,add,qual,email);
		
		studentDAO dao=new studentDAO(DBConnect.getConn());
		
		boolean f=dao.updatestudent(student);
		HttpSession session=req.getSession();
		
		if(f) {
			session.setAttribute("succMsg", "Student Details Update Successfully..");
			resp.sendRedirect("index.jsp");
			System.out.println("Student Details Update Successfully...");
		}else {
			session.setAttribute("FMsg", "Something wrong on server..!");
			resp.sendRedirect("index.jsp");
			System.out.println("Something wrong on server.");
		}
		
		
	}
	

}
