# FoodNow: Проект Тестирования

## Обзор Проекта

FoodNow – это веб-приложение для онлайн-заказа еды. Проект нацелен на всестороннее тестирование приложения FoodNow для обеспечения его качества и надежности. Тестирование началось с мануального тестирования функциональности регистрации с использованием различных техник Тест Дизайна, в первую очередь таких как и Тестирование граничных значений (Boundary Value) и техника разделения на эквивалентные классы (Equivalence Partitioning). Проект автоматизации тестирования использует Selenium, Cucumber, Postman, Newman, Testlink, REST Assured и Jenkins для различных видов тестирования, включая UI, API и интеграционное тестирование. В проекте реализовано логирование и создание скриншотов для удобства отслеживания и документирования багов.

## Ключевые Функции

Приложение FoodNow предлагает следующие функции:

* Регистрация и авторизация пользователей
* Просмотр и сортировка продуктов
* Добавление продуктов в корзину
* Оформление заказа
* Онлайн-оплата

## Используемые Технологии

* **Тестирование:** Selenium 4.25.0, Cucumber, Postman, Newman, TestLink, REST Assured, Jenkins, Jira
* **Язык программирования:** Java 17
* **Сборка:** Gradle
* **Логирование:** Logback Classic 1.5.9
* **Прочее:** WebDriverManager 5.9.2


## Структура Проекта

Проект включает логирование и создание скриншотов для облегчения отслеживания багов.  Ключевые аспекты структуры проекта:

* **`/src/main/java/com/foodnow/pages`**: Содержит Page Objects для взаимодействия с веб-приложением. Примеры:
  * `RegisterPage`:  Содержит метод `enterPersonalData()` для всестороннего тестирования полей регистрации.
  * `LoginPage`: Содержит метод `loginExistedUser()` для упрощенного тестирования входа в систему.
  * `AddProductPage`:  Предоставляет методы, такие как `clickFoodCategory()` и `clickAddSteakToCart()` для взаимодействия с категориями продуктов и добавления товаров в корзину.
  * `CartPage`:  Предлагает метод `addProductToCart()` для добавления продукта в корзину.
* **`/src/test/java/foodnow/tests`**: Содержит соответствующие тестовые классы.


## Установка и Настройка

### Необходимые компоненты
* **Java JDK (17 или выше):** Загрузите с [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) или используйте дистрибутив, например [Adoptium](https://adoptium.net/).
* **Gradle:**  Загрузите с [Gradle](https://gradle.org/install/)  или используйте менеджер пакетов (например, Homebrew, SDKMAN). Если проект включает Gradle Wrapper (`gradlew` и `gradlew.bat`),  вы можете использовать `./gradlew` напрямую.
* **Git:** Загрузите и установите с [Git](https://git-scm.com/downloads).


### Шаги

1. Клонируйте репозиторий: `git clone https://github.com/MicusHub/FoodNow.git`
2. Перейдите в директорию проекта: `cd FoodNow`
3. Соберите проект и установите зависимости: `./gradlew build` (или `gradlew build` в Windows)
4. Запустите тесты: `./gradlew test` (или `gradlew test` в Windows)


## Примеры Использования

Пример входа существующего пользователя:
<br/>public LoginPage loginExistedUser() { <br/>
clickIconAuthorization(); <br/>
clickLoginButton(); <br/>
enterPersonalData("login" , "password"); <br/>
clickSubmitLogin(); <br/>
return this; <br/>
}

## Известные Проблемы и Ограничения

* Изображения не отображаются корректно после нагрузочного тестирования, что
  потенциально может повлиять на некоторые тесты.

## Документация

* [Test Plan](https://docs.google.com/spreadsheets/d/1fhztzIxPEVHzE2q1KZDFKaFSvn-vgOVX/edit?usp=sharing&ouid=103276708346142431414&rtpof=true&sd=true)
* [User Stories](https://docs.google.com/spreadsheets/d/10Duvod2kNCm1BFMMsb8_6c7LdBQ680TrDdJd20p5FXc/edit#gid=0)
* [TestLink](https://testlink.ait-tr.de/index.php?caller=login&viewer=)
* [Jira Project](https://ait-learn.atlassian.net/jira/core/projects/Q3F/board)
* [Database Schema](https://drawsql.app/teams/vera-team/diagrams/order-food)
* [QA Project (Cucumber)](https://github.com/MicusHub?tab=repositories)
* [QA Project (Selenium)](https://github.com/MicusHub?tab=repositories)
* [Postman Test Run](https://drive.google.com/file/d/1V8IPwh7pYfbmQC2rEsfBjDsKVhlLnyFo/view?usp=sharing)
* [Use Cases](https://docs.google.com/document/d/1aBOmoolJJWEyk12gwnZOpHPtJZvVPdxo/edit?usp=sharing&ouid=103276708346142431414&rtpof=true&sd=true)

<!-- end list -->