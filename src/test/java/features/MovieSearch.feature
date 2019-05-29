# language: en
@withdrawal
Feature:  Move to movie navigator and search movies by param

@success
Scenario: Move to movie navigator and search movies by param
  * user opens the site "https://www.kinopoisk.ru/"
  * Go to Movies then Movie Navigator
  * Fill in the search parameters
|№|Parameter                  |value|   Namelink|
| 0|жанр                       |комедия| genreList|
| 1|страна                     |США|     countryList|
| 2|снятые с                   |1998||
| 3|Снятые до                  |2000||
| 4|Рейтинг от                 |7||
| 5|Рейтинг до                 |10||
| 6|рейтинг IMDb от            |7||
| 7|рейтинг IMDb до            |10||
| 8|рейтинг кинокритиков от    |80||
| 9|рейтинг кинокритиков до    |100||
|10|рейтинг полож. рецензий от |90||
|11|рейтинг полож. рецензий до |95||
|12|кол-во оценок =            |2000||
|13|рейтинг MPAA               |любой||
|14|возраст                    |12+||
|15|бюджет фильма от           |50||
|16|бюджет фильма до           |100||
|17|кассовые сборы от          |25||
|18|кассовые сборы до          |-||
|19|страна для кассовых сборов |США|domestic|
  * Check for the number of films "1" in the popup window