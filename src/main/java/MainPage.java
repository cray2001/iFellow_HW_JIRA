import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public static SelenideElement avatar = $x("//img[@alt='Пользовательский профиль для npolyakov']");
    public static SelenideElement projectMenu = $x("//a[@title='Просмотр недавних проектов или списка всех проектов']");
    public static SelenideElement givenProject = $x("//div[@id='project_current']//a[text()='Test (TEST)']");
    public static SelenideElement createMenu = $x("//li[@id='create-menu']//a[@id='create_link']");
    public static SelenideElement task = $x("//dd[@id='issuekey-val']//a");



    public void getProject(){

        projectMenu.shouldBe(Condition.visible).click();
        givenProject.shouldBe(Condition.visible).click();

    }

    public void createTask(){

        createMenu.shouldBe(Condition.visible).click();

    }

    public void openTask(){

        task.shouldBe(Condition.visible).click();

    }




}
