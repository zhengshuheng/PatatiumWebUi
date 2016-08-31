import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.testng.annotations.DataProvider;
import org.webdriver.patatiumwebui.action.CommonAction;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.webdriver.patatiumwebui.action.LoginAction;
import org.webdriver.patatiumwebui.pageObject.HomePage;
import org.webdriver.patatiumwebui.pageObject.LoginPage;
import org.webdriver.patatiumwebui.utils.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class LoginTest extends TestBaseCase {
	ElementAction action=new ElementAction();
	@Test(description="登录成功测试")
	@Parameters({"BaseUrl"})//读取testng.xml参数
	public void login(String BaseUrl) throws IOException
	{
		//调用登录方法，输入正确的用户名和密码
		LoginAction loginAction=new LoginAction(BaseUrl+"/new/login.aspx","111111","abc123");
		action.sleep(2);
		//设置检查点
		Assertion.VerityTextPresentPrecision("jd_845622","输入正确的用户名和密码，验证是否成功进入主页");
		//设置用例断言，判断用例是否失败
		Assertion.VerityError();
	}
	//数据驱动案例--start
	@DataProvider(name="longinData")
	public Object[][] loginData()
	{
		//读取登录用例测试数据
		String filePath="src/main/resources/data/loginData.xls";
		//读取第一个sheet，第2行到第5行-第2到第4列之间的数据
		return ExcelReadUtil.case_data_excel(0, 1, 4, 1, 3,filePath);
	}
	@Test(description="登录失败用例",dataProvider = "longinData")
	public void loginFail (String userName,String password,String message) throws IOException, DocumentException {
		//代替testng参数化的方法
		String BaseUrl= XmlReadUtil.getTestngParametersValue("testng.xml","BaseUrl");
		//调用登录方法
		LoginAction loginAction=new LoginAction(BaseUrl+"/new/login.aspx",userName,password);
		action.sleep(1);
		//设置检查点
		Assertion.VerityTextPresent(message,"验证是否出现预期的错误提示信息:"+message);
		//设置断言
		Assertion.VerityError();
	}
	//数据驱动案例--end

}