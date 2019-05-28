package pages;

import org.openqa.selenium.By;


public class FilmsNavigate {

    //input[@data-name="комедия"]
    //list Страна и Жанр
    public static By country = By.xpath("//div[@id = 'countryListTitle']");
    public static By genre = By.xpath("//div[@id = 'genreListTitle']");
    //Рейтинги
    public static By ratingMin = By.xpath("//input[@id = 'rating_min']");
    public static By IMDbMin = By.xpath("//input[@id = 'ex_rating_min']");
    public static By CriticMin = By.xpath("//input[@id = 'tomat_rating_min']");

    public static By revieProcentMin = By.xpath("//input[@id = 'review_procent_min']");
    public static By revieProcentMax = By.xpath("//input[@id = 'review_procent_max']");

    //Ползунок
    public static By AmountVotesSlider = By.xpath("//div[@id=\"num_voterange\"]/a[@class=\"ui-slider-handle ui-state-default ui-corner-all\"]");

//    public static By age = By.xpath("//select[@name="m_act[restriction]"]");
//    public static By age = By.xpath("//div[@class="restrictionRating"]//select/option[@value="12+"]);
//
//            String text= driver.findElement(By.id("1VTB24_URL")).getAttribute("title");

    public static By budgetMin = By.xpath("//select[contains(@name,'[budget][min]')]");
    public static By budgetMax = By.xpath("//select[contains(@name,'[budget][max]')]");
    public static By CassMax = By.xpath("//select[@class=\"narrow gross_select\"]");
    public static By showFilmButton = By.xpath("//input[@value = 'поиск']");
}
