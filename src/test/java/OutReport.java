import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class OutReport {
	@BeforeTest
	public void outReport()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://127.0.0.1");
	}

}
