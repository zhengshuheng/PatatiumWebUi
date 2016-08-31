package org.webdriver.patatiumwebui.pageObject;
import java.io.IOException;
import java.io.InputStream;
import org.webdriver.patatiumwebui.utils.BaseAction;
import org.webdriver.patatiumwebui.utils.Locator;
import org.webdriver.patatiumwebui.pageObjectConfig.PageObjectAutoCode;//预约明细页面_对象库类
public class AppointmentDetailPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/org/webdriver/patatiumwebui/pageObjectConfig/UILibrary.xml";
 public   AppointmentDetailPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 患者姓名
* @return
* @throws IOException
*/
public Locator familyMemberName() throws IOException
 {
   Locator locator=getLocator("familyMemberName");
   return locator;
 }

/***
* 电话号码
* @return
* @throws IOException
*/
public Locator telephone() throws IOException
 {
   Locator locator=getLocator("telephone");
   return locator;
 }

/***
* 身份证号码
* @return
* @throws IOException
*/
public Locator identityCardNumber() throws IOException
 {
   Locator locator=getLocator("identityCardNumber");
   return locator;
 }

/***
* 预约号码
* @return
* @throws IOException
*/
public Locator appiont_num() throws IOException
 {
   Locator locator=getLocator("appiont_num");
   return locator;
 }

/***
* 查询按钮
* @return
* @throws IOException
*/
public Locator query_button() throws IOException
 {
   Locator locator=getLocator("query_button");
   return locator;
 }

/***
* 查询结果表格
* @return
* @throws IOException
*/
public Locator query_table() throws IOException
 {
   Locator locator=getLocator("query_table");
   return locator;
 }

/***
* 取消订单确认按钮
* @return
* @throws IOException
*/
public Locator dismissAppiontconfirm() throws IOException
 {
   Locator locator=getLocator("dismissAppiontconfirm");
   return locator;
 }

/***
* 待就诊状态值
* @return
* @throws IOException
*/
public Locator order_state_treatment() throws IOException
 {
   Locator locator=getLocator("order_state_treatment");
   return locator;
 }

/***
* 取消订单按钮
* @return
* @throws IOException
*/
public Locator dismissAppiont() throws IOException
 {
   Locator locator=getLocator("dismissAppiont");
   return locator;
 }
}