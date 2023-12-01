package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class studentDAO {

	private Connection conn;

	public studentDAO(Connection connection) {
		super();
		this.conn = connection;
	}

	public boolean addStudent(Student student) {

		boolean f = false;
		try {
			String sql = "insert into student(fname,dob,address,qualification,email) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getFname());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAdd());
			ps.setString(4, student.getQual());
			ps.setString(5, student.getEmail());

			int i = ps.executeUpdate();
			if (i == 1) {

				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();
		Student s = null;

		try {
			String sql = "select * from student";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				s = new Student(null, null, null, null, null);

				s.setId(rs.getInt(1));
				s.setFname(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setAdd(rs.getString(4));
				s.setQual(rs.getString(5));
				s.setEmail(rs.getString(6));
				list.add(s);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return list;
	}

	public Student getStudentById(int id) {
		Student s = null;

		try {
			String sql = "select * from student where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				s = new Student(null, null, null, null, null);

				s.setId(rs.getInt(1));
				s.setFname(rs.getString(2));
				s.setDob(rs.getString(3));
				s.setAdd(rs.getString(4));
				s.setQual(rs.getString(5));
				s.setEmail(rs.getString(6));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s;
	}

	public boolean updatestudent(Student student) {

		boolean f = false;
		try {
			String sql = "update student set fname=?,dob=?,address=?,qualification=?,email=? where id=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, student.getFname());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getAdd());
			ps.setString(4, student.getQual());
			ps.setString(5, student.getEmail());
			ps.setInt(6, student.getId());
			int i = ps.executeUpdate();
			if (i == 1) {

				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean deleteStudent(int id) {
		boolean f = false;

		try {

			String sql = "delete from student where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;
	}

}
