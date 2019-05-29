package step_definitions;

import Utils.DriverUtil;
import Utils.WebElementUtill;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.CheckFilms;
import pages.FilmsNavigate;
import pages.loginpage;
import pages.Homepage;
//import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static Utils.WebElementUtill.ClickElement;
import static Utils.WebElementUtill.SelectFromList;
import static pages.Homepage.CheckTitle;
//import static Utils.WebElementUtill.takeScreenShot;

public class MyStepdefs {
    public static WebDriver driver;


    @Before("@withdrawal")
    public void prepareData() {
        //подготовить данные
        System.out.println("The beginning");
    }

    @After("@withdrawal")
    public void clearData(Scenario scenario) {
        if (scenario.isFailed()) {
            //takeScreenShot(driver);
        }
        driver.quit();
    }

    /*
    1.	Зайти на сайт  https://www.kinopoisk.ru/ ;
    2.	Проверить корректность входа на нужную страницу; (навык проверки страницы по title);
    3.	Залогиниться на сайте под своей тестовой учетной записью; (навык работы с элементами внутри фрейма,
     т.к. окно логина это фрейм, работа с assert)
    4.	Проверить корректность входа по имени аккаунта (навык работы с методом .moveToElement класса Actions,
     т.к. имя акканута будет видно только после наведения мышкой на картинку «человека» в меню, работа с assert);
    5.	Перейти в Фильмы/Навигатор по фильмам (навык работы с методом .moveToElement класса Actions,
    т.к. кликнуть подраздел «Навигатор по фильмам» можно только после наведения мышкой на раздел меню «Фильмы»);
    6.	Проверить корректность перехода в раздел «Навигатор по фильмам» (навык проверки страницы по title);
    7.	Найти все фильмы в жанре «комедии» снятые в США в интервале годов с 1998 по 2000 с ретингом > 7,
    рейтингом IMDb > 7, рейтингом кинокритиков > 80, рейтингом положительных рецензий  от 90 до 95.
    Передвинуть ползунок «Минимальное количество оценок» на 2000 используя либо drag and drop класса Actions,
    либо используя класс Robot. Рейтинг MPAA – любой. Возраст – 12+. Бюджет фильма от 50 до 100 миллионов $.
    Кассовые сборы от 25 млн $ в США (работа с текстовыми полями, выпадающими списками, маркированными списками,
    чекбоксами) ;
    8.	В появившемся в окне тексте «Найдено: <количество фильмов> фильма» с помощью регулярного выражения
    проверить текст «<количество фильмов> фильма(ов)»  (навык работы с рег. выражениями, ожиданиями и assert’ами);
    9.	Нажать кнопку «показать фильмы»;
    10.	Проверить, что в результатах поиска отображен массив фильмов снятых в США в жанре «комедия» с рейтингом
    у каждого >7 (навык работы с массивами элементов, преобразования строки с рейтингом в число и сравнении
    этого числа с условием assert’а) и рейтингом IMDb > 7 (навык работы с массивами элементов, навык
    вытягивания строки числа из общего текста «IMDb: 7.00» с помощью регулярного выражения, навык
    работы с преобразованием этой строки в числовое значение и дальнейшего сравнения с условием assert’а);
    11.	Произвести выход из профиля;
    12.	Проверить, что выход из профиля осуществлен корректно (проверка наличия кнопки «Войти»).
    */
    @Given("^user opens the site \"([^\"]*)\"$")
    public void UserOpensSite(String arg1) throws Throwable {
        driver = DriverUtil.startCromeDriver();
        driver.get(arg1);
    }

    @Then("^check title \"([^\"]*)\"$")
    public void Checktitle(String arg1) throws Throwable {
        (new WebDriverWait(driver, 5, 1000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//head/title")));
        String element = driver.getTitle();
        System.out.println("---------------Title check---------------\n"
                + "Real title: " + arg1 + "\n" + "Received title: " + element);
        CheckTitle(element, arg1);
    }

    @Then("^Login on the site$")
    public void loginOnTheSite() throws Throwable {
        try {
            WebElement element = driver.findElement(Homepage.EnterButton);
            element.click();
            loginpage login = new loginpage();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            element = driver.findElement(login.login);
            element.sendKeys("BRAKnaZAVODE");
            element = driver.findElement(login.buttonEnter);
            element.click();
            element = (new WebDriverWait(driver, 1, 1000)).until(ExpectedConditions.elementToBeClickable(login.password));
            element = driver.findElement(login.password);
            element.sendKeys("naZAVODEBRAK");
            element = driver.findElement(login.buttonEnter);
            element.click();
        } catch (TimeoutException e) {
            System.out.println(driver.getCurrentUrl());
            e.printStackTrace();
        }
    }

    @Then("^check user$")
    public void checkuser() throws Throwable {
        Homepage homepage = new Homepage();
        WebElement element = driver.findElement(homepage.avatar);
        element.click();
        String text = driver.findElement(homepage.userName).getText();
        System.out.println("-----Validation name check-----\n" + "Real name: BRAKnaZAVODE" + "\n" + "Received name: " + text);

        if (text.equals("BRAKnaZAVODE")) {
            System.out.println("Result: Valid User");
        } else {
            System.out.println("Result: login by account name isn't correct");
        }
    }

    @Then("^Go to Movies then Movie Navigator$")
    public void GotoMoviesthenMovieNavigator() throws Throwable {
        Homepage homepage = new Homepage();
        Actions action = new Actions(driver);
        WebElement element = (new WebDriverWait(driver, 3, 1000)).until(ExpectedConditions.elementToBeClickable(homepage.FilmsButton));
        action.moveToElement(element).build().perform();
        element = (new WebDriverWait(driver, 3, 1000)).until(ExpectedConditions.elementToBeClickable(homepage.NavigateFilms));
        element.click();
    }

    @Then("^Fill in the search parameters$")
    public void FillInTheSearchParameters(DataTable arg1) throws Throwable {
        //FilmsNavigate filmsNavigate = new FilmsNavigate();
        System.out.println("1 <Start>");
            List<Map<String, String>> list = arg1.asMaps(String.class, String.class);
            String a1,a2;
        System.out.println("2 <country>");
            ClickElement(driver, FilmsNavigate.country);
            SelectFromList(driver,list.get(1).get("Namelink"),list.get(1).get("value"));
        System.out.println("3 <janre>");
            //ИСПРАВИТЬ Удалить ненужные переменные а1 а2 и подставить их значения в SelectFromList()
            a1 = list.get(0).get("Namelink");
            a2 = list.get(0).get("value");
            ClickElement(driver, FilmsNavigate.genre);
            SelectFromList(driver,a1,a2);                  //<-----------------------------------Сюда
        System.out.println("4 <FROM years TO>");
            //ИСПРАВИТЬ СТРОКУ НИЖЕ : вместо "1998" добавить            list.get(2).get("value")
            driver.findElement(FilmsNavigate.datesMin).sendKeys("1998");
            driver.findElement(FilmsNavigate.datesMax).sendKeys(list.get(3).get("value"));
        System.out.println("5 <Rating>");
            WebElementUtill.sendKeys(driver, FilmsNavigate.ratingMax,list.get(5).get("value") );
            WebElementUtill.sendKeys(driver, FilmsNavigate.ratingMin,list.get(4).get("value") );
            WebElementUtill.sendKeys(driver, FilmsNavigate.IMDbMax,list.get(7).get("value") );
            WebElementUtill.sendKeys(driver, FilmsNavigate.IMDbMin,list.get(6).get("value") );
            WebElementUtill.sendKeys(driver, FilmsNavigate.CriticMax,list.get(9).get("value") );
            WebElementUtill.sendKeys(driver, FilmsNavigate.CriticMin,list.get(8).get("value") );
            WebElementUtill.sendKeys(driver, FilmsNavigate.RatingPositiveReviewsMax,list.get(11).get("value") );
            WebElementUtill.sendKeys(driver, FilmsNavigate.RatingPositiveReviewsMin,list.get(10).get("value") );
        System.out.println("6 <Rating Slider>");
            WebElement slider = driver.findElement(FilmsNavigate.AmountVotesSlider);
            Actions move = new Actions(driver);
            Action action = (Action) move.dragAndDropBy(slider, 143, 0).build();
            action.perform();
        System.out.println("7 <Rating MPAA and Age control>");
            driver.findElement(FilmsNavigate.MPAArating).sendKeys(list.get(13).get("value"));
            driver.findElement(FilmsNavigate.age).sendKeys(list.get(14).get("value"));
        System.out.println("8 <Budget>");
            driver.findElement(FilmsNavigate.budgetMin).sendKeys(list.get(15).get("value"));
            driver.findElement(FilmsNavigate.budgetMax).sendKeys(list.get(16).get("value"));
        System.out.println("8 <Cash fees>");
            driver.findElement(FilmsNavigate.CassMin).sendKeys(list.get(17).get("value"));
            driver.findElement(FilmsNavigate.CassMax).sendKeys(list.get(18).get("value"));
            driver.findElement(FilmsNavigate.CassCountry).sendKeys(list.get(19).get("Namelink"));
        System.out.println("<end>");
        //Thread.sleep(10000);
    }

    @Then("^Check for the number of films \"([^\"]*)\" in the popup window$")
    public void Check_for_the_number_of_films_in_the_popup_window(String arg1) throws Throwable {
        Thread.sleep(3000);
        //CheckFilms checkFilms = new CheckFilms();
        String AmountFilms = WebElementUtill.getText(driver,CheckFilms.NumberFilmSearch);
        String AmountTest = (arg1+" фильм");

        System.out.println(AmountFilms);
        System.out.println(AmountTest);
       // Assert.assertEquals(AmountFilms,AmountTest);
    }


}
