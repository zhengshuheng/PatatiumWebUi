package org.webdriver.patatiumwebui.pageObject;
import java.io.IOException;
import java.io.InputStream;
import org.webdriver.patatiumwebui.utils.BaseAction;
import org.webdriver.patatiumwebui.utils.Locator;
import org.webdriver.patatiumwebui.pageObjectConfig.PageObjectAutoCode;//客服后台主页_对象库类
public class HomePage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/org/webdriver/patatiumwebui/pageObjectConfig/UILibrary.xml";
 public   HomePage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 预约挂号
* @return
* @throws IOException
*/
public Locator appiont_memue() throws IOException
 {
   Locator locator=getLocator("appiont_memue");
   return locator;
 }

/***
* 账号信息管理
* @return
* @throws IOException
*/
public Locator account_management() throws IOException
 {
   Locator locator=getLocator("account_management");
   return locator;
 }

/***
* 预约明细
* @return
* @throws IOException
*/
public Locator AppointmentDetail() throws IOException
 {
   Locator locator=getLocator("AppointmentDetail");
   return locator;
 }

/***
* 咨询统计
* @return
* @throws IOException
*/
public Locator queryConsultation() throws IOException
 {
   Locator locator=getLocator("queryConsultation");
   return locator;
 }

/***
* 客服工作统计
* @return
* @throws IOException
*/
public Locator queryCustomerWork() throws IOException
 {
   Locator locator=getLocator("queryCustomerWork");
   return locator;
 }

/***
* 短信查询
* @return
* @throws IOException
*/
public Locator queryMessagePage() throws IOException
 {
   Locator locator=getLocator("queryMessagePage");
   return locator;
 }

/***
* 退出登录
* @return
* @throws IOException
*/
public Locator layout() throws IOException
 {
   Locator locator=getLocator("layout");
   return locator;
 }
}