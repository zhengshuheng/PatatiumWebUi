package org.webdriver.patatiumwebui.utils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * 页面元素操作类--操作页面元素的方法
 * @author Administrator 郑树恒
 *
 */
public class ElementAction extends TestBaseCase{

	private Log log=new Log(this.getClass());
	public static ArrayList<Exception> noSuchElementExceptions=new ArrayList<Exception>();
	private String formatDate(Date date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HHmmssSSS");
		return formatter.format(date).toString();
	}
	/**
	 * 查找一组元素
	 * @param locator 元素定位信息
	 * @return
	 */
	public List<WebElement>  findElements(final Locator locator)
	{

		/**
		 * 查找某个元素等待几秒
		 */
		//Waitformax(Integer.valueOf(locator.getWaitSec()));
		List<WebElement>  webElements=null;
		try {
			webElements=(new WebDriverWait(driver, 20)).until(
					new ExpectedCondition<List<WebElement>>() {

						@Override
						public List<WebElement> apply(WebDriver driver) {
							// TODO 自动生成的方法存根
							List<WebElement> element=null;
							element=getElements(locator);
							return element;}
					});
			return webElements;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			log.info("无法定位页面元素");
			e.printStackTrace();
			Assertion.assertInfolList.add("failed,找不到元素：["+locator.getBy()+":"+locator.getElement()+"等待:"+locator.getWaitSec());
			noSuchElementExceptions.add(e);
			Assertion.messageList.add("找不到所需页面元素["+locator.getElement()+"]:failed");
			ScreenShot screenShot=new ScreenShot(driver);
			//设置截图名字
			Date nowDate=new Date();
			screenShot.setscreenName(this.formatDate(nowDate));
			screenShot.takeScreenshot();
			Assertion.messageList.add("&lt;a class=\"clickbox\" href=\"#url\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"100\" width=\"100\" alt=\"\" /&gt;\n"
					+ "&lt;b class=\"lightbox\"&gt;\n"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;\n"
					+ "&lt;b class=\"box\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;\n"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面.&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/a&gt;\n"
					+ "&lt;br class=\"clear\" /&gt;\n"
					+"&lt;a class=\"clickbox\" href=\"#url\"&gt;"
					+ "点击查看大图"
					+ "&lt;b class=\"lightbox\"&gt;"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;"
					+ "&lt;b class=\"box\"&gt;&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面."
					+ "&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;"
					+ "&lt;/b&gt;"
					+ "&lt;/b&gt;"
					+ " &lt;/a&gt;\n&lt;/br&gt;"
					+ "&lt;div id=\"close\"&gt;&lt;/div&gt;\n");
			log.info(this.formatDate(nowDate));
			//Assertion.assertInfolList.add(arg0)
			return webElements;
		}
		catch (TimeoutException e) {
			// TODO: handle exception
			log.info("查找页面元素超时");
			e.printStackTrace();
			Assertion.assertInfolList.add("failed,超时找不到元素：["+locator.getBy()+":"+locator.getElement()+"等待:"+locator.getWaitSec());
			noSuchElementExceptions.add(e);
			Assertion.messageList.add("超时找不到所需页面元素["+locator.getElement()+"]:failed");
			ScreenShot screenShot=new ScreenShot(driver);
			//设置截图名字
			Date nowDate=new Date();
			screenShot.setscreenName(this.formatDate(nowDate));
			screenShot.takeScreenshot();
			//Assertion.assertInfolList.add("&lt;a href=\"snapshot/"+this.formatDate(nowDate)+".jpg\" &gt;&lt;img height=\"100\" width=\"100\" src=\"snapshot/"+this.formatDate(nowDate)+".jpg\"&gt;&lt;/img&gt;&lt;/a>&lt;br/&gt;"+"&lt;a href=\"snapshot/"+this.formatDate(nowDate)+".jpg\" &gt;点击查看大图&lt;/a&gt;\n");
			Assertion.messageList.add("&lt;a class=\"clickbox\" href=\"#url\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"100\" width=\"100\" alt=\"\" /&gt;\n"
					+ "&lt;b class=\"lightbox\"&gt;\n"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;\n"
					+ "&lt;b class=\"box\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;\n"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面.&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/a&gt;\n"
					+ "&lt;br class=\"clear\" /&gt;\n"
					+"&lt;a class=\"clickbox\" href=\"#url\"&gt;"
					+ "点击查看大图"
					+ "&lt;b class=\"lightbox\"&gt;"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;"
					+ "&lt;b class=\"box\"&gt;&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面."
					+ "&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;"
					+ "&lt;/b&gt;"
					+ "&lt;/b&gt;"
					+ " &lt;/a&gt;\n&lt;/br&gt;"
					+ "&lt;div id=\"close\"&gt;&lt;/div&gt;\n");
			log.info(this.formatDate(nowDate));
			//Assertion.assertInfolList.add(arg0)
			return webElements;
		}
		catch (ElementNotVisibleException e) {
			// TODO: handle exception
			log.info("查找页面元素超时");
			e.printStackTrace();
			Assertion.assertInfolList.add("failed,页面元素不可视：["+locator.getBy()+":"+locator.getElement()+"等待:"+locator.getWaitSec());
			noSuchElementExceptions.add(e);
			Assertion.messageList.add("超时页面元素不可视["+locator.getElement()+"]:failed");
			ScreenShot screenShot=new ScreenShot(driver);
			//设置截图名字
			Date nowDate=new Date();
			screenShot.setscreenName(this.formatDate(nowDate));
			screenShot.takeScreenshot();
			//Assertion.assertInfolList.add("&lt;a href=\"snapshot/"+this.formatDate(nowDate)+".jpg\" &gt;&lt;img height=\"100\" width=\"100\" src=\"snapshot/"+this.formatDate(nowDate)+".jpg\"&gt;&lt;/img&gt;&lt;/a>&lt;br/&gt;"+"&lt;a href=\"snapshot/"+this.formatDate(nowDate)+".jpg\" &gt;点击查看大图&lt;/a&gt;\n");
			Assertion.messageList.add("&lt;a class=\"clickbox\" href=\"#url\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"100\" width=\"100\" alt=\"\" /&gt;\n"
					+ "&lt;b class=\"lightbox\"&gt;\n"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;\n"
					+ "&lt;b class=\"box\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;\n"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面.&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/a&gt;\n"
					+ "&lt;br class=\"clear\" /&gt;\n"
					+"&lt;a class=\"clickbox\" href=\"#url\"&gt;"
					+ "点击查看大图"
					+ "&lt;b class=\"lightbox\"&gt;"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;"
					+ "&lt;b class=\"box\"&gt;&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面."
					+ "&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;"
					+ "&lt;/b&gt;"
					+ "&lt;/b&gt;"
					+ " &lt;/a&gt;\n&lt;/br&gt;"
					+ "&lt;div id=\"close\"&gt;&lt;/div&gt;\n");
			log.info(this.formatDate(nowDate));
			//Assertion.assertInfolList.add(arg0)
			return webElements;
		}

	}
	public WebElement findElement( final Locator locator)
	{
		/**
		 * 查找某个元素等待几秒
		 */
		//Waitformax(Integer.valueOf(locator.getWaitSec()));
		WebElement webElement=null;
		try {
			webElement=(new WebDriverWait(driver, 20)).until(
					new ExpectedCondition<WebElement>() {

						@Override
						public WebElement apply(WebDriver driver) {
							// TODO 自动生成的方法存根
							WebElement element=null;
							element=getElement(locator);
							return element;
						}
					});
			return webElement;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			log.info("无法定位页面元素");
			e.printStackTrace();
			Assertion.assertInfolList.add("failed,找不到元素：["+locator.getBy()+":"+locator.getElement()+"等待:"+locator.getWaitSec());
			noSuchElementExceptions.add(e);
			Assertion.messageList.add("找不到所需页面元素["+locator.getElement()+"]:failed");
			ScreenShot screenShot=new ScreenShot(driver);
			//设置截图名字
			Date nowDate=new Date();
			screenShot.setscreenName(this.formatDate(nowDate));
			screenShot.takeScreenshot();
			Assertion.messageList.add("&lt;a class=\"clickbox\" href=\"#url\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"100\" width=\"100\" alt=\"\" /&gt;\n"
					+ "&lt;b class=\"lightbox\"&gt;\n"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;\n"
					+ "&lt;b class=\"box\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;\n"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面.&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/a&gt;\n"
					+ "&lt;br class=\"clear\" /&gt;\n"
					+"&lt;a class=\"clickbox\" href=\"#url\"&gt;"
					+ "点击查看大图"
					+ "&lt;b class=\"lightbox\"&gt;"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;"
					+ "&lt;b class=\"box\"&gt;&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面."
					+ "&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;"
					+ "&lt;/b&gt;"
					+ "&lt;/b&gt;"
					+ " &lt;/a&gt;\n&lt;/br&gt;"
					+ "&lt;div id=\"close\"&gt;&lt;/div&gt;\n");
			log.info(this.formatDate(nowDate));
			return webElement;
		}
		catch (TimeoutException e) {
			// TODO: handle exception
			log.info("超时无法定位页面元素");
			e.printStackTrace();
			Assertion.assertInfolList.add("failed,超时找不到元素：["+locator.getBy()+":"+locator.getElement()+"等待:"+locator.getWaitSec());
			noSuchElementExceptions.add(e);
			Assertion.messageList.add("超时找不到所需页面元素["+locator.getElement()+"]:failed");
			ScreenShot screenShot=new ScreenShot(driver);
			//设置截图名字
			Date nowDate=new Date();
			screenShot.setscreenName(this.formatDate(nowDate));
			screenShot.takeScreenshot();
			Assertion.messageList.add("&lt;a class=\"clickbox\" href=\"#url\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"100\" width=\"100\" alt=\"\" /&gt;\n"
					+ "&lt;b class=\"lightbox\"&gt;\n"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;\n"
					+ "&lt;b class=\"box\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;\n"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面.&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/a&gt;\n"
					+ "&lt;br class=\"clear\" /&gt;\n"
					+"&lt;a class=\"clickbox\" href=\"#url\"&gt;"
					+ "点击查看大图"
					+ "&lt;b class=\"lightbox\"&gt;"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;"
					+ "&lt;b class=\"box\"&gt;&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面."
					+ "&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;"
					+ "&lt;/b&gt;"
					+ "&lt;/b&gt;"
					+ " &lt;/a&gt;\n&lt;/br&gt;"
					+ "&lt;div id=\"close\"&gt;&lt;/div&gt;\n");
			log.info(this.formatDate(nowDate));
			return webElement;
		}
		catch (ElementNotVisibleException e) {
			// TODO: handle exception
			log.info("超时无法定位页面元素");
			e.printStackTrace();
			Assertion.assertInfolList.add("failed,超时找不到元素：["+locator.getBy()+":"+locator.getElement()+"等待:"+locator.getWaitSec());
			noSuchElementExceptions.add(e);
			Assertion.messageList.add("超时页面元素不可视["+locator.getElement()+"]:failed");
			ScreenShot screenShot=new ScreenShot(driver);
			//设置截图名字
			Date nowDate=new Date();
			screenShot.setscreenName(this.formatDate(nowDate));
			screenShot.takeScreenshot();
			Assertion.messageList.add("&lt;a class=\"clickbox\" href=\"#url\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"100\" width=\"100\" alt=\"\" /&gt;\n"
					+ "&lt;b class=\"lightbox\"&gt;\n"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;\n"
					+ "&lt;b class=\"box\"&gt;\n"
					+ "&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;\n"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面.&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/b&gt;\n"
					+ "&lt;/a&gt;\n"
					+ "&lt;br class=\"clear\" /&gt;\n"
					+"&lt;a class=\"clickbox\" href=\"#url\"&gt;"
					+ "点击查看大图"
					+ "&lt;b class=\"lightbox\"&gt;"
					+ "&lt;b class=\"light\"&gt;&lt;/b&gt;"
					+ "&lt;b class=\"box\"&gt;&lt;img src=\"snapshot/"
					+ this.formatDate(nowDate)
					+ ".jpg\" height=\"530\" width=\"1024\" onmousewheel=\"return bigimg(this)\" alt=\"\" /&gt;"
					+ "&lt;span&gt;滚动鼠标缩放大小,点击X关闭当前图片，返回报表界面."
					+ "&lt;br /&gt;&lt;i&gt;&lt;/i&gt;&lt;/span&gt;"
					+ "&lt;/b&gt;"
					+ "&lt;/b&gt;"
					+ " &lt;/a&gt;\n&lt;/br&gt;"
					+ "&lt;div id=\"close\"&gt;&lt;/div&gt;\n");
			log.info(this.formatDate(nowDate));
			return webElement;
		}
	}

	/**
	 * 通过定位信息获取元素
	 * @param locator  元素locator
	 * @return 返回WebElement
	 * @throws NoSuchElementException 找不到元素异常
	 */
	public WebElement getElement(Locator locator)
	{

		/**
		 * locator.getElement(),获取对象库对象定位信息
		 */
		log.info("查找元素："+locator.getLocalorName()+"方式"+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
		WebElement webElement;
		switch (locator.getBy())
		{
			case xpath :
				webElement=driver.findElement(By.xpath(locator.getElement()));
				break;
			case id:
				webElement=driver.findElement(By.id(locator.getElement()));
				break;
			case cssSelector:
				webElement=driver.findElement(By.cssSelector(locator.getElement()));
				break;
			case name:
				webElement=driver.findElement(By.name(locator.getElement()));
				break;
			case className:
				webElement=driver.findElement(By.className(locator.getElement()));
				break;
			case linkText:
				webElement=driver.findElement(By.linkText(locator.getElement()));
				break;
			case partialLinkText:
				webElement=driver.findElement(By.partialLinkText(locator.getElement()));
				break;
			case tagName:
				webElement=driver.findElement(By.tagName(locator.getElement()));
				break;
			default :
				webElement=driver.findElement(By.xpath(locator.getElement()));
				break;

		}
		return webElement;
	}
	/**
	 * 通过定位信息获取一组元素
	 * @param locator  元素locator
	 * @return 返回WebElement
	 * @throws NoSuchElementException 找不到元素异常
	 */
	public List<WebElement> getElements(Locator locator)
	{
		/**
		 * locator.getElement(),获取对象库对象定位信息
		 */
		//locator=getLocator(locatorMap.get(key));
		log.info("查找一组元素："+locator.getLocalorName()+" 方式"+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
		List<WebElement> webElements;
		switch (locator.getBy())
		{
			case xpath :
				//log.info("find element By xpath");
				webElements=driver.findElements(By.xpath(locator.getElement()));
				/**
				 * 出现找不到元素的时候，记录日志文件
				 */
				break;
			case id:
				//log.info("find element By xpath");
				webElements=driver.findElements(By.id(locator.getElement()));
				break;
			case cssSelector:
				//log.info("find element By cssSelector");
				webElements=driver.findElements(By.cssSelector(locator.getElement()));
				break;
			case name:
				//log.info("find element By name");
				webElements=driver.findElements(By.name(locator.getElement()));
				break;
			case className:
				//log.info("find element By className");
				webElements=driver.findElements(By.className(locator.getElement()));
				break;
			case linkText:
				//log.info("find element By linkText");
				webElements=driver.findElements(By.linkText(locator.getElement()));
				break;
			case partialLinkText:
				//log.info("find element By partialLinkText");
				webElements=driver.findElements(By.partialLinkText(locator.getElement()));
				break;
			case tagName:
				//log.info("find element By tagName");
				webElements=driver.findElements(By.partialLinkText(locator.getElement()));
				break;
			default :
				//log.info("find element By xpath");
				webElements=driver.findElements(By.xpath(locator.getElement()));
				break;

		}
		return webElements;
	}
	/**
	 * 文本框输入操作
	 * @param locator  元素locator
	 * @param value 输入值
	 */
	public void type(Locator locator,String value)
	{
		try {
			WebElement webElement=findElement(locator);
			webElement.sendKeys(value);
			log.info("input输入："+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"value:"+value+"]");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			log.error("找不到元素，input输入失败:"+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
			e.printStackTrace();
			//throw e;
			//Assertion.flag=false;
		}

	}
	public void type_action(Locator locator,String value)
	{
		Actions actions =new Actions(driver);
		WebElement weElement=findElement(locator);
		actions.sendKeys(weElement, value);
	}
	/**
	 * 普通单击操作
	 * @param locator  元素locator
	 */
	public  void click(Locator locator)
	{
		try {
			WebElement webElement=findElement(locator);
			webElement.click();
			log.info("click元素："+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]成功！");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			log.error("找不到元素，click失败:"+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
			e.printStackTrace();
			throw e;
		}

	}
	/**
	 * 选择下拉框操作
	 * @param locator  元素locator
	 * @param text 选择下拉值
	 */
	public  void selectByText(Locator locator,String text)
	{
		try {
			WebElement webElement=findElement(locator);
			Select select=new Select(webElement);
			log.info("选择select标签："+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
			try {
				//select.selectByValue(value);
				select.selectByVisibleText(text);
				log.info("选择下拉列表项：" + text);

			} catch (NoSuchElementException notByValue) {
				// TODO: handle exception
				log.info("找不到下拉值，选择下拉列表项失败 " + text);
				throw notByValue;
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			log.error("找不到元素，选择select标签失败:"+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
			throw e;
		}
	}

	/**
	 * 选择下拉框操作
	 * @param locator  元素locator
	 * @param value 选择下拉value
	 */
	public  void selectByValue(Locator locator,String value)
	{
		Select select;
		try {
			WebElement webElement=findElement(locator);
			select=new Select(webElement);
			log.info("选择select标签:"+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			log.error("找不到元素，选择select标签失败:"+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
			throw e;
		}
		try {
			select.selectByValue(value);
			log.info("选择下拉列表项：" + value);

		} catch (NoSuchElementException notByValue) {
			// TODO: handle exception
			log.info("找不到下拉值，选择下拉列表项失败 " + value);
			throw notByValue;
		}
	}
	/**
	 * 通过下拉列表的index选择元素
	 * @param locator
	 * @param index
	 */
	public void selectByIndex(Locator locator, int index) {
		// TODO 自动生成的方法存根
		Select select;
		try {
			WebElement webElement=findElement(locator);
			select=new Select(webElement);
			log.info("选择select标签:"+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			log.error("找不到元素，选择select标签失败"+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
			throw e;
		}
		try {
			//select.selectByValue(value);
			select.selectByIndex(index);
			log.info("选择下拉列表项：" + index);

		} catch (NoSuchElementException notByindex) {
			// TODO: handle exception
			log.info("找不到下拉值，选择下拉列表项失败 " + index);
			throw notByindex;
		}
	}
	/**
	 * 获取下拉列表的value属性值
	 * @param selectLocator 下拉列表 select标签定位信息
	 * @param optinValue 下拉列表文本值
	 * @return 返回String
	 */
	public String  getSelectOptionValue(Locator selectLocator,String optinText)
	{
		WebElement webElement=driver.findElement(By.xpath(selectLocator.getElement()+"//option[text()='"
				+ optinText
				+ "']"));
		return webElement.getAttribute("value");
	}
	public String getSelectOptionText(Locator selectLocator,String optinValue)
	{
		WebElement webElement=driver.findElement(By.xpath(selectLocator.getElement()+"//option[text()='"
				+ optinValue
				+ "']"));
		return webElement.getText();
	}
	/**
	 * 点击确认按钮
	 */
	public void alertConfirm()
	{
		Alert alert=driver.switchTo().alert();
		try {
			alert.accept();
			log.info("点击确认按钮");
		} catch (NoAlertPresentException notFindAlert) {
			// TODO: handle exception
			//throw notFindAlert;
			log.error("找不到确认按钮");
			throw notFindAlert;
		}
	}
	/**
	 * 点击取消按钮
	 */
	public  void alertDismiss()
	{
		Alert alert= driver.switchTo().alert();
		try {
			alert.dismiss();
			log.info("点击取消按钮");
		} catch (NoAlertPresentException notFindAlert) {
			// TODO: handle exception
			//throw notFindAlert;
			log.error("找不到取消按钮");
			throw notFindAlert;
		}
	}
	/**
	 * 获取对话框文本
	 * @return 返回String
	 */
	public String getAlertText()
	{
		Alert alert=driver.switchTo().alert();
		try {
			String text=alert.getText().toString();
			log.info("获取对话框文本："+text);
			return text;
		} catch (NoAlertPresentException notFindAlert) {
			// TODO: handle exception
			log.error("找不到对话框");
			//return "找不到对话框";
			throw notFindAlert;

		}
	}
	/**
	 * 鼠标悬停操作
	 * @param locator  元素locator
	 */
	public void clickAndHold(Locator locator)
	{
		WebElement webElement=findElement(locator);
		Actions actions=new Actions(driver);
		actions.clickAndHold(webElement).perform();
	}
	/**
	 * 鼠标左键单击
	 * @param locator  元素locator
	 */
	public void click_left(Locator locator)
	{
		WebElement webElement=findElement(locator);
		Actions actions =new Actions(driver);
		actions.click(webElement).perform();
		//actions.perform();
	}
	/**
	 * 鼠标右键操作
	 * @param locator  元素locator
	 */
	public void click_right(Locator locator)
	{
		WebElement webElement=findElement(locator);
		Actions actions=new Actions(driver);
		actions.contextClick(webElement).perform();
		//actions.perform();
	}
	/**
	 * 鼠标双击操作
	 * @param locator  元素locator
	 */
	public void click_double(Locator locator)
	{
		WebElement webElement=findElement(locator);
		Actions actions=new Actions(driver);
		actions.doubleClick(webElement).perform();
		//actions.perform();

	}
	/**
	 * 清除文本框内容
	 * @param locator  元素locator
	 */
	public void clear(Locator locator)
	{
		try {
			WebElement webElement=findElement(locator);
			webElement.clear();
			log.info("清除input值:"+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("清除input值失败:"+locator.getLocalorName()+"["+"By."+locator.getBy()+":"+locator.getElement()+"]");
			throw e;

		}

	}
	/**
	 * 切换frame/iframe框架
	 * @param locator  元素locator
	 */
	public void switchToFrame(Locator locator)
	{
		WebElement frameElement=findElement(locator);
		driver.switchTo().frame(frameElement);
	}
	/**
	 * 切回默认窗口框架
	 */
	public void switchToDefaultFrame()
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * 多窗口切换
	 * @param i 第几个窗口
	 */
	public void switchToWindow(int i)
	{
		String[] handls=new String[driver.getWindowHandles().size()];
		driver.getWindowHandles().toArray(handls);
		driver.switchTo().window(handls[i]);
	}
	/**
	 * 隐式等待
	 * @param  driver 浏览器driver
	 * @param  t  最大等待时间，秒为单位
	 **/
	public void Waitformax(int t)
	{
		driver.manage().timeouts().implicitlyWait(t,TimeUnit.SECONDS);
	}
	/**
	 * 获取元素文本
	 * @param locator  元素locator
	 */
	public String getText(Locator locator)
	{
		WebElement webElement=findElement(locator);
		String text=webElement.getText();
		return text;

	}
	/**
	 * 获取元素某属性的值
	 * @param locator  元素locator
	 * @param attributeName
	 * @return 返回String
	 */
	public String getAttribute(Locator locator,String attributeName)
	{
		WebElement webElement=findElement(locator);
		String value= webElement.getAttribute(attributeName);
		return value;
	}
	/**
	 * 获取当前url
	 * @return
	 */
	public String getUrl()
	{
		String url=driver.getCurrentUrl();
		return url;
	}
	/**
	 * 获取当前网页标题
	 * @return 返回String
	 */
	public String getTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	/**
	 * 截屏方法
	 * @param FileDriver  文件保存路径
	 * @param Filename  文件名
	 * @throws Exception  抛出Exception异常
	 */
	public void Snapshot(String FileDriver,String Filename) throws Exception
	{
		File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(scrFile, new File(FileDriver+Filename));
			System.out.println("错误截图："+FileDriver+Filename);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * 显式等待，程序休眠暂停
	 * @param time 以秒为单位
	 */
	public void sleep(long time)
	{
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/**
	 * 显式等待 判断页面是否完全加载完成
	 * @param time 已秒为单位
	 */
	public void pagefoload(long time)
	{
		ExpectedCondition<Boolean> pageLoad= new
				ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
					}
				};
		WebDriverWait wait = new WebDriverWait(driver, time*1000);
		wait.until(pageLoad);
	}
	public void executeJS(String js) {
		((JavascriptExecutor) driver).executeScript(js);
		System.out.println("执行JS脚本："+js);

	}
	/**
	 * 判断医组元素是否存在
	 * @param locator 一组元素定位信息
	 * @param timeOut 超时时间 秒
	 * @return 返回boolean true存在，false不存在
	 * @throws InterruptedException
	 */
	public  boolean isElementsPresent(Locator locator, int timeOut) throws InterruptedException
	{
		log.info("等待"+timeOut+"秒判断元素："+locator.getElement()+"是否存在");
		boolean isPresent = false;
		Thread.sleep(timeOut * 1000);
		List<WebElement> we =findElements(locator);
		if (we.size() != 0) {
			isPresent = true;
		}
		log.info("判断结果为："+isPresent);
		return isPresent;
	}
	/**
	 * 判断元素是否显示
	 * @param locator 元素定位信息
	 * @return  返回boolean true显示，false隐藏
	 */
	public boolean isElementDisplayed(Locator locator)
	{
		ElementAction action =new ElementAction();
		WebElement webElement=action.findElement(locator);
		webElement.isEnabled();
		log.info("元素显示状态为："+ webElement.isDisplayed());
		return webElement.isDisplayed();
	}
	/**
	 * 等待30秒让元素可见
	 * @param locator
	 */
	public void DisplayElement(Locator locator)
	{
		ElementAction action =new ElementAction();
		WebDriverWait webDriverWait=new WebDriverWait(driver, 30);
		webDriverWait.until(ExpectedConditions.visibilityOf(action.findElement(locator))).isDisplayed();

	}

}
