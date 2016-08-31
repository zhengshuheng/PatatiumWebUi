package org.webdriver.patatiumwebui.pageObject;
import java.io.IOException;
import java.io.InputStream;
import org.webdriver.patatiumwebui.utils.BaseAction;
import org.webdriver.patatiumwebui.utils.Locator;
import org.webdriver.patatiumwebui.pageObjectConfig.PageObjectAutoCode;//预约挂号_对象库类
public class AppointmentPage extends BaseAction {
//用于eclipse工程内运行查找对象库文件路径
private String path="src/main/java/org/webdriver/patatiumwebui/pageObjectConfig/UILibrary.xml";
 public   AppointmentPage() {
//工程内读取对象库文件
	setXmlObjectPath(path);
getLocatorMap();
}
/***
* 地区选择
* @return
* @throws IOException
*/
public Locator districtId_select() throws IOException
 {
   Locator locator=getLocator("districtId_select");
   return locator;
 }

/***
* 医院名称输入
* @return
* @throws IOException
*/
public Locator hospitalPinyinOrName() throws IOException
 {
   Locator locator=getLocator("hospitalPinyinOrName");
   return locator;
 }

/***
* 科室选择
* @return
* @throws IOException
*/
public Locator departmentId_select() throws IOException
 {
   Locator locator=getLocator("departmentId_select");
   return locator;
 }

/***
* 查询
* @return
* @throws IOException
*/
public Locator hospital_list() throws IOException
 {
   Locator locator=getLocator("hospital_list");
   return locator;
 }

/***
* 查询
* @return
* @throws IOException
*/
public Locator appointment_query() throws IOException
 {
   Locator locator=getLocator("appointment_query");
   return locator;
 }

/***
* 可预约号
* @return
* @throws IOException
*/
public Locator SignalSources() throws IOException
 {
   Locator locator=getLocator("SignalSources");
   return locator;
 }

/***
* 具体时间段号源
* @return
* @throws IOException
*/
public Locator timeSignalSources() throws IOException
 {
   Locator locator=getLocator("timeSignalSources");
   return locator;
 }

/***
* 选择号源下一步
* @return
* @throws IOException
*/
public Locator nextsetepforfirst() throws IOException
 {
   Locator locator=getLocator("nextsetepforfirst");
   return locator;
 }

/***
* 预约挂号电话号码
* @return
* @throws IOException
*/
public Locator telephone() throws IOException
 {
   Locator locator=getLocator("telephone");
   return locator;
 }

/***
* 患者姓名
* @return
* @throws IOException
*/
public Locator patientName() throws IOException
 {
   Locator locator=getLocator("patientName");
   return locator;
 }

/***
* 证件号码
* @return
* @throws IOException
*/
public Locator identityCardNumber() throws IOException
 {
   Locator locator=getLocator("identityCardNumber");
   return locator;
 }

/***
* 返回成功信息对话框
* @return
* @throws IOException
*/
public Locator appintment_successs() throws IOException
 {
   Locator locator=getLocator("appintment_successs");
   return locator;
 }

/***
* 成功页面关闭按钮
* @return
* @throws IOException
*/
public Locator closebutton() throws IOException
 {
   Locator locator=getLocator("closebutton");
   return locator;
 }

/***
* 信息输入框关闭按钮
* @return
* @throws IOException
*/
public Locator patientInfo_closebutton() throws IOException
 {
   Locator locator=getLocator("patientInfo_closebutton");
   return locator;
 }

/***
* 预约失败的返回信息
* @return
* @throws IOException
*/
public Locator failed_message() throws IOException
 {
   Locator locator=getLocator("failed_message");
   return locator;
 }

/***
* 输入完账号信息后的下一步
* @return
* @throws IOException
*/
public Locator netstepforlast() throws IOException
 {
   Locator locator=getLocator("netstepforlast");
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

/***
* 预约挂号成功返回信息
* @return
* @throws IOException
*/
public Locator appoint_succes_info() throws IOException
 {
   Locator locator=getLocator("appoint_succes_info");
   return locator;
 }

/***
* 预约号码
* @return
* @throws IOException
*/
public Locator appoint_number() throws IOException
 {
   Locator locator=getLocator("appoint_number");
   return locator;
 }

/***
* 具体号源预约标题
* @return
* @throws IOException
*/
public Locator appointmentInfoTitle() throws IOException
 {
   Locator locator=getLocator("appointmentInfoTitle");
   return locator;
 }

/***
* 预约挂号选择号源关闭按钮
* @return
* @throws IOException
*/
public Locator appointmentInfo_close_button() throws IOException
 {
   Locator locator=getLocator("appointmentInfo_close_button");
   return locator;
 }
}