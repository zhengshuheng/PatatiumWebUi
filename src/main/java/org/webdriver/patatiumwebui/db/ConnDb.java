package org.webdriver.patatiumwebui.db;
import  java.sql.*;
import java.util.ArrayList;


import org.webdriver.patatiumwebui.utils.Log;
public class ConnDb {
	private Log log=new Log(this.getClass());
	public  Connection getConn(String DataBaseName)
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.227:3306/"
				+DataBaseName ;
		String username = "hk";
		String password = "hk@test";
		Connection conn = null;
		try {
			Class.forName(driver); //classLoader,加载对应驱动
			conn = DriverManager.getConnection(url, username, password);
			log.info("连接数据库成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args)
	{
		ConnDb connDb=new ConnDb();
		Connection connection=connDb.getConn("HISAPPOINTMENT");
		String sql="SELECT HospitalName  FROM Hospital.Hospital S WHERE S.ProvinceId='19' AND S.CityId='2157'";
		ArrayList<String> hospitaList=new ArrayList<String>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				int row = rs.getRow();

				String h=rs.getString(1);
				//System.out.println(row);
				hospitaList.add(h);
				System.out.println(h);


			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//return null;
	}

}


