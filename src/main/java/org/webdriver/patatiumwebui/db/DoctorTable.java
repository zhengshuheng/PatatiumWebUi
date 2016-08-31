package org.webdriver.patatiumwebui.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DoctorTable {
	public String id;
	static String baseSQL="select * from Doctor";
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DoctorTable doctor=new DoctorTable();
		doctor.selectAsDoctorId("1512092235585ahxr");

	}
	public void selectAsDoctorId(String doctorId)
	{
		ConnDb connDb=new ConnDb();
		Connection connection=connDb.getConn("HISAPPOINTMENT");
		String sql=baseSQL+"   where id='"+doctorId+"'";
		System.out.println(sql);
		//String sql="select * from Doctor where id='"+doctorId+"'";
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int row=resultSet.getRow();
				String id=resultSet.getString("id");
				System.out.println(id);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
