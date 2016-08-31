package org.webdriver.patatiumwebui.pageObject;
import java.io.IOException;
import java.io.InputStream;
import org.webdriver.patatiumwebui.utils.BaseAction;
import org.webdriver.patatiumwebui.utils.Locator;
import org.webdriver.patatiumwebui.pageObjectConfig.PageObjectAutoCode;//账号注册页面_对象库类
public class AccountMangerPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/org/webdriver/patatiumwebui/pageObjectConfig/UILibrary.xml";
 public   AccountMangerPage()
 {
    //工程内读取对象库文件
	setXmlObjectPath(path);
    getLocatorMap();
 }
/***
* 按主账号姓名查询
* @return
* @throws IOException
*/
public Locator queryForName() throws IOException
 {
   Locator locator=getLocator("queryForName");
   return locator;
 }

/***
* 按主账号手机查询
* @return
* @throws IOException
*/
public Locator queryForMobilePhone() throws IOException
 {
   Locator locator=getLocator("queryForMobilePhone");
   return locator;
 }

/***
* 按身份证号查询
* @return
* @throws IOException
*/
public Locator queryForIdentityCard() throws IOException
 {
   Locator locator=getLocator("queryForIdentityCard");
   return locator;
 }

/***
* 查询按钮
* @return
* @throws IOException
*/
public Locator queryButton() throws IOException
 {
   Locator locator=getLocator("queryButton");
   return locator;
 }

/***
* 查询结果表格
* @return
* @throws IOException
*/
public Locator queryResultTable() throws IOException
 {
   Locator locator=getLocator("queryResultTable");
   return locator;
 }

/***
* 账号注册按钮
* @return
* @throws IOException
*/
public Locator registerButton() throws IOException
 {
   Locator locator=getLocator("registerButton");
   return locator;
 }

/***
* 注册内容——电话号码输入
* @return
* @throws IOException
*/
public Locator register_tel() throws IOException
 {
   Locator locator=getLocator("register_tel");
   return locator;
 }

/***
* 账号注册--姓名
* @return
* @throws IOException
*/
public Locator register_patientName() throws IOException
 {
   Locator locator=getLocator("register_patientName");
   return locator;
 }

/***
* 账号注册-证件类型选
* @return
* @throws IOException
*/
public Locator register_identityCardType() throws IOException
 {
   Locator locator=getLocator("register_identityCardType");
   return locator;
 }

/***
* 账号注册-身份证号吗
* @return
* @throws IOException
*/
public Locator register_identityCardNumber() throws IOException
 {
   Locator locator=getLocator("register_identityCardNumber");
   return locator;
 }

/***
* 账号注册-保存
* @return
* @throws IOException
*/
public Locator register_save() throws IOException
 {
   Locator locator=getLocator("register_save");
   return locator;
 }

/***
* 账号注册-保存成功确定按钮
* @return
* @throws IOException
*/
public Locator register_confirm() throws IOException
 {
   Locator locator=getLocator("register_confirm");
   return locator;
 }

/***
* 新增就诊人
* @return
* @throws IOException
*/
public Locator add_paitent() throws IOException
 {
   Locator locator=getLocator("add_paitent");
   return locator;
 }

/***
* 新增就诊人-姓名
* @return
* @throws IOException
*/
public Locator add_paitent_name() throws IOException
 {
   Locator locator=getLocator("add_paitent_name");
   return locator;
 }

/***
* 新增就诊人-保存
* @return
* @throws IOException
*/
public Locator add_paitent_save() throws IOException
 {
   Locator locator=getLocator("add_paitent_save");
   return locator;
 }
}