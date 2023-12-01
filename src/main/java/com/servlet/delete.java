package com.servlet;

import java.io.IOException;

import com.dao.studentDAO;
import com.db.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class delete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		studentDAO dao = new studentDAO(DBConnect.getConn());
		boolean f = dao.deleteStudent(id);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("succMsg", "Student Details Delete Successfully..");
			resp.sendRedirect("index.jsp");
			System.out.println("Student Details delete Successfully...");
		} else {
			session.setAttribute("FMsg", "Something wrong on server..!");
			resp.sendRedirect("index.jsp");
			System.out.println("Something wrong on server.");
		}

	}

}
