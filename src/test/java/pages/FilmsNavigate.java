package pages;

import org.openqa.selenium.By;


public class FilmsNavigate {
//Верхнее окно параметров поиска
    //list Страна и Жанр
    public static By country = By.xpath("//div[@id = 'countryListTitle']");
    public static By genre = By.xpath("//div[@id = 'genreListTitle']");
    public static By datesMin = By.xpath("//select[@class='narrow year_select_interval'][contains(@name,'[min]')]");
    public static By datesMax = By.xpath("//select[@class='narrow year_select_interval'][contains(@name,'[max]')]");
    //Рейтинги
    public static By ratingMin = By.xpath("//input[@id = 'rating_min']");
    public static By ratingMax = By.xpath("//input[@id = 'rating_max']");
    public static By IMDbMin = By.xpath("//input[@id = 'ex_rating_min']");
    public static By IMDbMax = By.xpath("//input[@id = 'ex_rating_max']");
    public static By CriticMin = By.xpath("//input[@id = 'tomat_rating_min']");
    public static By CriticMax = By.xpath("//input[@id = 'tomat_rating_max']");
    public static By RatingPositiveReviewsMin = By.xpath("//input[@id = 'review_procent_min']");
    public static By RatingPositiveReviewsMax = By.xpath("//input[@id = 'review_procent_max']");
    //Ползунок
    public static By AmountVotesSlider = By.xpath("//div[@id=\"num_voterange\"]/a[@class=\"ui-slider-handle ui-state-default ui-corner-all\"]");
    //Доп параметры
    public static By MPAArating = By.xpath("//div[@class='mpaaRating']/select");
    public static By age = By.xpath("//div[@class='restrictionRating']/select");
    //Нижнее окно
    public static By budgetMin = By.xpath("//select[contains(@name,'[budget][min]')]");
    public static By budgetMax = By.xpath("//select[contains(@name,'[budget][max]')]");

    public static By CassMin = By.xpath("//select[contains(@name,'[gross][min]')]");
    public static By CassMax = By.xpath("//select[contains(@name,'[gross][max]')]");
    public static By CassCountry = By.xpath("//select[contains(@name,'[gross_type]')]");

    public static By showFilmButton = By.xpath("//input[@value = 'поиск']");
}
