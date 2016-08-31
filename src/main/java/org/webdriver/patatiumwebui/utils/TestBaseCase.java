package org.webdriver.patatiumwebui.utils;
import org.webdriver.patatiumwebui.utils.Log;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestBaseCase {
	public static WebDriver driver;
	//方法描述
	public static String description;
	public Log log=new Log(this.getClass().getSuperclass());
	@BeforeTest
	@Parameters({"driver","nodeURL"})
	public void  setup( String driver,String nodeURL) throws MalformedURLException {
		log.info("------------------开始执行测试---------------");
		if(nodeURL.equals("")||nodeURL.isEmpty())
		{
			log.info("读取testng.xml配置的"+driver+"浏览器并将其初始化\n");
			try {
				this.driver=setDriver(driver);
			} catch (Exception e) {
				// TODO: handle exception
				//System.out.println("环境配置错误");
				log.error("没有成功浏览器环境配置错误");
				e.printStackTrace();
			}
			System.out.println(nodeURL);
			this.driver.manage().window().maximize();
		}
		else {
			log.info("读取xml配置：浏览器:"+driver+"；gridNodeURL:"+nodeURL);
			try {
				this.driver=setRemoteDriver(driver,nodeURL);
			} catch (Exception e) {
				// TODO: handle exception
				log.error("没有成功浏览器环境配置错误");
			}

			this.driver.manage().window().maximize();
		}

	}

	@AfterTest
	public void tearDown() {
		this.driver.close();
		this.driver.quit();
		log.info("-------------结束测试，并关闭退出浏览器-------------");
	}

	/**
	 * 用枚举类型列出浏览器列表，用于设置浏览器类型的函数参数
	 * @author zheng
	 *
	 */
	private WebDriver setDriver(String browsername)
	{
		switch (browsername)
		{

			case "FirefoxDriver" :
				System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
				FirefoxProfile firefoxProfile=new FirefoxProfile();
				//设置默认下载路径
				firefoxProfile.setPreference("browser.download.folderList", 2);
				firefoxProfile.setPreference("browser.download.dir", "D:\\自动化测试下载文件");
				//加载firebug插件
				firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0.13");
				firefoxProfile.setPreference("extensions.firebug.allPagesActivation", "none");
				//加载firepath插件
				firefoxProfile.setPreference("extensions.firepath.currentVersion", "0.9.7.1.1");
				firefoxProfile.setPreference("extensions.firepath.allPagesActivation", "on");
				this.driver=new FirefoxDriver(firefoxProfile);
				break;
			case "ChormeDriver":
				System.setProperty("webdriver.chrome.driver", "resource\\chromedriver.exe");
				this.driver=new ChromeDriver();
				break;
			case "InternetExplorerDriver":
				System.setProperty("webdriver.ie.driver", "resource\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");
				DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
				dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				dc.setCapability("ignoreProtectedModeSettings", true);
				this.driver=new InternetExplorerDriver(dc);
				break;
			case "HtmlUnitDriver":
				this.driver=new HtmlUnitDriver();
				break;
			default:
				this.driver=new FirefoxDriver();
				break;
		}
		return driver;
	}



	private WebDriver setRemoteDriver(String browsername,String nodeURL) throws MalformedURLException
	{
		switch (browsername)
		{

			case "FirefoxDriver" :
				System.setProperty("webdriver.firefox.bin", "C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
				FirefoxProfile firefoxProfile=new FirefoxProfile();
				//设置默认下载路径
				firefoxProfile.setPreference("browser.download.folderList", 2);
				firefoxProfile.setPreference("browser.download.dir", "D:\\自动化测试下载文件");
				//加载firebug插件
				firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0.13");
				firefoxProfile.setPreference("extensions.firebug.allPagesActivation", "none");
				//加载firepath插件
				firefoxProfile.setPreference("extensions.firepath.currentVersion", "0.9.7.1.1");
				firefoxProfile.setPreference("extensions.firepath.allPagesActivation", "on");
				DesiredCapabilities capabilities=DesiredCapabilities.firefox();
				capabilities.setBrowserName("firefox");
				capabilities.setPlatform(Platform.WINDOWS);
				//driver= new RemoteWebDriver(new URL("http://192.168.0.205:4455/wd/hub"), capabilities);
				driver= new RemoteWebDriver(new URL(nodeURL), capabilities);
				break;
			case "ChormeDriver":
				System.setProperty("webdriver.chrome.driver", "E:\\autotest\\autotmaiton\\resource\\chromedriver.exe");
				//driver=new ChromeDriver();
				DesiredCapabilities dcchorme=DesiredCapabilities.chrome();
				dcchorme.setBrowserName("chrome");
				dcchorme.setVersion("46.0.2490.86 m");
				dcchorme.setPlatform(Platform.WINDOWS);
				driver=new RemoteWebDriver(new URL(nodeURL), dcchorme);
				break;
			case "InternetExplorerDriver-8":
				System.setProperty("webdriver.ie.driver", "E:\\autotest\\autotmaiton\\resource\\IEDriverServer_Win32_2.48.0\\IEDriverServer.exe");
				DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
				dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				dc.setCapability("ignoreProtectedModeSettings", true);
				dc.setBrowserName("internet explorer");
				dc.setVersion("8.0.6001.18702");
				dc.setPlatform(Platform.XP);
				driver= new RemoteWebDriver(new URL(nodeURL), dc);
				break;
			case "InternetExplorerDriver-9":
				System.setProperty("webdriver.ie.driver", "E:\\autotest\\autotmaiton\\resource\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
				DesiredCapabilities dc2 = DesiredCapabilities.internetExplorer();
				dc2.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				dc2.setCapability("ignoreProtectedModeSettings", true);
				dc2.setBrowserName("internet explorer");
				dc2.setVersion("9.0.8112.16421");
				dc2.setPlatform(Platform.WINDOWS);
				driver= new RemoteWebDriver(new URL(nodeURL), dc2);
				//driver=new InternetExplorerDriver(dc2);
				break;
			case "HtmlUnitDriver":
				this.driver=new HtmlUnitDriver();
				break;
			default:
				this.driver=new FirefoxDriver();
				break;
		}
		return driver;
	}
	public static void main(String args[])
	{
		WebDriver driver2=new FirefoxDriver();
		driver2.get("http://www.baidu.com");
	}


}
