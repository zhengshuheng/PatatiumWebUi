package org.webdriver.patatiumwebui.pageObject;
import java.io.IOException;
import java.io.InputStream;
import org.webdriver.patatiumwebui.utils.BaseAction;
import org.webdriver.patatiumwebui.utils.Locator;
import org.webdriver.patatiumwebui.pageObjectConfig.PageObjectAutoCode;//运营后台账户管理_对象库类
public class OmsHomePage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/org/webdriver/patatiumwebui/pageObjectConfig/UILibrary.xml";
 public   OmsHomePage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 用户名
* @return
* @throws IOException
*/
public Locator username() throws IOException
 {
   Locator locator=getLocator("username");
   return locator;
 }

/***
* 密码
* @return
* @throws IOException
*/
public Locator password() throws IOException
 {
   Locator locator=getLocator("password");
   return locator;
 }

/***
* 登录
* @return
* @throws IOException
*/
public Locator loginbutton() throws IOException
 {
   Locator locator=getLocator("loginbutton");
   return locator;
 }

/***
* 会员管理
* @return
* @throws IOException
*/
public Locator vip_management() throws IOException
 {
   Locator locator=getLocator("vip_management");
   return locator;
 }

/***
* 账户管理
* @return
* @throws IOException
*/
public Locator account_management() throws IOException
 {
   Locator locator=getLocator("account_management");
   return locator;
 }

/***
* 账户手机
* @return
* @throws IOException
*/
public Locator account_MobilePhone() throws IOException
 {
   Locator locator=getLocator("account_MobilePhone");
   return locator;
 }

/***
* 查询
* @return
* @throws IOException
*/
public Locator account_query() throws IOException
 {
   Locator locator=getLocator("account_query");
   return locator;
 }

/***
* 查询结果表格
* @return
* @throws IOException
*/
public Locator account_query_table() throws IOException
 {
   Locator locator=getLocator("account_query_table");
   return locator;
 }

/***
* 账号注销按钮
* @return
* @throws IOException
*/
public Locator delete_account_button() throws IOException
 {
   Locator locator=getLocator("delete_account_button");
   return locator;
 }

/***
* 账号注销确认按钮
* @return
* @throws IOException
*/
public Locator delete_account_confirm_button() throws IOException
 {
   Locator locator=getLocator("delete_account_confirm_button");
   return locator;
 }

/***
* 删除成功确定按钮
* @return
* @throws IOException
*/
public Locator delete_account_success_button() throws IOException
 {
   Locator locator=getLocator("delete_account_success_button");
   return locator;
 }
}