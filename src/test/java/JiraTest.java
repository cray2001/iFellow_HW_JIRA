import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertTrue;

public class JiraTest extends BaseTest {


    @Test
    public void jiraTest() {


        open("https://edujira.ifellow.ru/");
        WebDriverRunner.getWebDriver().manage().window().maximize();


        StartPage startPage = new StartPage();
        startPage.autorization();   //Step 1

        MainPage mainPage = new MainPage();

        mainPage.avatar.shouldBe(Condition.visible);
        assertTrue(mainPage.avatar.exists(), "Авторизация не удалась");

        mainPage.getProject();      //Step 2
        //assertTrue(TasksListPage.pageName.isDisplayed(), "Не удалось выбрать проект 'Test (TEST)'");

        TasksListPage tasksListPage = new TasksListPage();
        System.out.println(tasksListPage.getTasksCount());   //Step 3

        tasksListPage.getTaskStatusAndVersion("TestSelenium");   //Step 4

        mainPage.createTask();   //Step 5
        CreateTaskPage.pageHeader.shouldBe(Condition.visible);
        assertTrue(CreateTaskPage.pageHeader.exists(), "Окно создания задачи не открылось");

        CreateTaskPage createTaskPage = new CreateTaskPage();
        createTaskPage.fillTaskFields();
        tasksListPage.findTaskInList("Тестовый баг").shouldBe(Condition.exist, Duration.ofSeconds(30));
        assertTrue(!tasksListPage.findTaskInList("Тестовый баг").equals(null), "Баг не создан");

        mainPage.openTask();
        createTaskPage.closeTask();


    }


}
