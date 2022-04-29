import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CreateTaskPage {

    public static SelenideElement pageHeader = $x("//h2[@title='Создание задачи']");

    public static SelenideElement taskTypeSelector = $x("//input[@id='issuetype-field']");

    public static SelenideElement issueType = $x("//input[@id='issuetype']");

    public static SelenideElement taskTypeBug = $x("//li[@class='aui-list-item aui-list-item-li-ошибка']");

    public static SelenideElement taskSummary = $x("//input[@id='summary']");

    public static SelenideElement descriptionFrame = $x("(//iFrame)[1]");

    public static SelenideElement taskDescription = $x("//p");

    public static SelenideElement createButton = $x("//input[@id='create-issue-submit']");

    public static SelenideElement businessProcess = $x("//span[text()='Бизнес-процесс']");

    public static SelenideElement taskDone = $x("//span[text()='Выполнено']");


    public void closeTask() {

        businessProcess.shouldBe(Condition.visible).click();
        taskDone.shouldBe(Condition.visible).click();
    }

    public void fillTaskFields() {

        System.out.println();
        System.out.println(issueType.getValue().toString());
        System.out.println(!issueType.getValue().toString().equals("10102"));

        if (!issueType.getValue().toString().equals("10102")) {

            System.out.println("Условие выполнено, выбираем пункт 'Ошибка' из списка");

            taskTypeSelector.shouldBe(Condition.visible).click();
            taskTypeBug.shouldBe(Condition.visible).click();
            sleep(5000);
        }

        taskSummary.setValue("Тестовый баг");

        switchTo().frame(descriptionFrame);
        taskDescription.setValue("К работе с фреймами жизнь меня не готовила...");
        switchTo().defaultContent();

        createButton.shouldBe(Condition.enabled).click();

    }

}
