package org.webdriver.patatiumwebui.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HospitalTable {

	public ArrayList<String> hospitalNames()
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
				String h=rs.getString(1);
				hospitaList.add(h);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hospitaList;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		HospitalTable hospitalTable=new HospitalTable();
		System.out.println( hospitalTable.hospitalNames().size());
	}

}
