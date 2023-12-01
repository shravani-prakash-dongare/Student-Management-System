package com.servlet;

import java.io.IOException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import com.dao.studentDAO;
import com.db.DBConnect;
import com.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class register extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String add=req.getParameter("address");
		String qual=req.getParameter("qual");
		String email=req.getParameter("email");
		
		Student student=new Student(name,dob,add,qual,email);
		
		studentDAO dao=new studentDAO(DBConnect.getConn());
		
		boolean f=dao.addStudent(student);
		HttpSession session=req.getSession();
		
		
		if(f) {
			session.setAttribute("succMsg", "Student Details Submit Successfully..");
			resp.sendRedirect("addStudent.jsp");
			System.out.println("Student Details Submit Successfully...");
		}else {
			session.setAttribute("FMsg", "Something wrong on server..!");
			resp.sendRedirect("addStudent.jsp");
			System.out.println("Something wrong on server.");
		}
		
		
		
	}

}
