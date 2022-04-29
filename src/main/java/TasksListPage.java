import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static org.testng.Assert.assertTrue;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class TasksListPage {

    public static SelenideElement pageName = $x("//span[text()='Доска TEST']");
    public static SelenideElement tasksCounter = $x("//div[text()='Список задач']//following-sibling::div[@class='ghx-issue-count']");
    public static SelenideElement tasksListLeftMenu = $x("//div[@data-id='sidebar-navigation-panel']//span[@class='aui-icon aui-icon-large agile-icon-plan aui-iconfont-backlog']");
    public static SelenideElement showAllTasksLink = $x("//a[@title='Show All']");

    public static ElementsCollection tasksCollection = $$x("//div[@class='ghx-issue-content']//span[@class='ghx-inner']");

    public static SelenideElement statusValue = $x("//span[@id='status-val']//span");
    public static SelenideElement versionLink = $x("//span[@id='versions-field']//span");


    public String getTasksCount() {

        tasksListLeftMenu.shouldBe(Condition.visible).click();

        return tasksCounter.shouldBe(Condition.visible).getText();
    }

    public void getTaskStatusAndVersion(String taskName) {

        showAllTasksLink.shouldBe(Condition.visible).click();
        SelenideElement givenTask = findTaskInList(taskName);


        assertTrue(givenTask.exists(), "Задача с именем "+taskName+" не найдена");

        givenTask.click();

        System.out.println("Статус задачи: "+statusValue.text());
        System.out.println("Затронута в версии: "+versionLink.text());

    }

    public SelenideElement findTaskInList(String taskName){

        return tasksCollection.find(Condition.text(taskName));

    }


}
