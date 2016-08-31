package org.webdriver.patatiumwebui.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

import org.webdriver.patatiumwebui.config.Config;
import org.webdriver.patatiumwebui.pageObject.LoginPage;
import org.webdriver.patatiumwebui.db.ConnDb;
import org.webdriver.patatiumwebui.utils.Assertion;
import org.webdriver.patatiumwebui.utils.Locator;
import org.webdriver.patatiumwebui.utils.ScreenShot;
import org.webdriver.patatiumwebui.utils.TableElement;
import org.webdriver.patatiumwebui.utils.TestBaseCase;
import org.webdriver.patatiumwebui.utils.ElementAction;

public class CommonAction extends TestBaseCase {

	public static  void Login(String Url,String UserName,String PassWord) throws IOException
	{
		//此driver变量继承自TestBase变量
		LoginPage loginPage=new LoginPage();
		loginPage.open(Url);
		System.out.println(driver.getCurrentUrl());
		//设置截图名字
		ElementAction action=new ElementAction();
		action.clear(loginPage.密码输入框());
		action.type(loginPage.用户名输入框(),UserName);
		action.clear(loginPage.密码输入框());
		action.type(loginPage.密码输入框(),PassWord);
		action.click(loginPage.登录按钮());

	}
	public static void TimeWidgetManage(String elementName,String time) {
		String date=CommonAction.formatDate(time, "yyyy-MM-dd");
		String js="$(function(){$(\"input[name='"
				+ elementName
				+"']\""
				+ ").removeAttr('readonly');"
				+ "$(\"input[name='"
				+ elementName
				+"']\""
				+ ").val(\""
				+ date
				+ "\");"
				+ "})";
		((JavascriptExecutor) driver).executeScript(js);
		System.out.println(js);
	}
	public  static String formatDate(Date date,String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		System.out.println(formatter.format(date).toString());
		return formatter.format(date).toString();

	}
	public  static String formatDate(String date,String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat(format);
		String sss = null;
		try {
			sss = sdf2.format(sdf.parse(date));
			System.out.println(sss);
		} catch (ParseException e) {
			// TODO Auto-generated catch block  
			e.printStackTrace();
		}
		return sss;
	}
	public  static String formatDate(long date){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(formatter.format(date));
		return formatter.format(date);
	}
	/**
	 *
	 * @param locatorForSelectInput 查询条件输入框
	 * @param selectForValue 查询条件值
	 * @param locatorForSelectButton 查询按钮
	 * @param locatorForResultTable 查询结果表格
	 * @param rowForResultTable 需要对照的查询结果表格行号
	 * @param colForResult 需要对照的查询结果表格行号
	 * @param locatorForCountLocator 查询结果对照的页面记录数
	 * @param database 需要对照的数据库
	 * @param databaseTable 后台数据库表
	 * @param databaseFiled 后台数据库表字段
	 * @throws IOException
	 */
	public static void checkSelectFunctionForInput(Locator locatorForSelectInput,String selectForValue,
												   Locator locatorForSelectButton,Locator locatorForResultTable,int rowForResultTable,int colForResult,
												   Locator locatorForCountLocator,String database,String databaseTable,String databaseFiled ) throws IOException
	{
		ElementAction action=new ElementAction();
		action.clear(locatorForSelectInput);
		action.type(locatorForSelectInput, selectForValue);
		action.click(locatorForSelectButton);
		TableElement tableElement=new TableElement(action.findElement(locatorForResultTable));
		//连接数据库
		ConnDb connDb=new ConnDb();
		Connection connection=connDb.getConn(database);
		int ResultCount = 0;
		String sql="select count(*) as rowcount from"+databaseTable+"where"+databaseFiled+"="+selectForValue;
		try {
			PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
			{
				ResultCount = rs.getInt("rowcount") ;}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		String count=action.getText(locatorForCountLocator);
		String result=tableElement.getCellText(rowForResultTable, colForResult);
		Assertion.VerityString(result, selectForValue);
		Assertion.VerityString(count, String.valueOf(ResultCount));
		Assertion.VerityError();

	}
	public static void main(String[] args)
	{
		CommonAction.TimeWidgetManage("xngn", "2015-10-10");
		CommonAction.formatDate("89-09-19", "yyyy-MM-dd");
		CommonAction.formatDate(42369);
	}

}
