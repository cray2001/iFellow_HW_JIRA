import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$x;

public class StartPage {

    public static SelenideElement login = $x("//input[@id='login-form-username']");
    public static SelenideElement password = $x("//input[@id='login-form-password']");
    public static SelenideElement enterButton = $x("//input[@id='login']");


    public void autorization() {


        login.shouldBe(Condition.visible);
        login.setValue("npolyakov");
        password.setValue("123Qwerty");
        enterButton.click();


    }

}
