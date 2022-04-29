import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeTest;



public class BaseTest {

    @BeforeTest
    public void config(){


        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen=true;
    }
}
