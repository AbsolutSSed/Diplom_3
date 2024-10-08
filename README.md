# Diplom_3

## Описание проекта

Этот проект представляет собой набор автоматизированных тестов для веб-приложения "Stellar Burgers". Проект разработан с использованием Java, Selenium WebDriver, JUnit и Allure для создания отчетов. Тесты охватывают ключевые функции приложения, такие как регистрация, вход в систему, выход из системы и навигация по страницам.

## Структура проекта

- **src/main/java/page_object**: Пакет содержит классы Page Object, каждый из которых соответствует определенной странице приложения.
- **src/main/java/user**: Пакет содержит классы для управления пользователями, генерации данных и взаимодействия с API.
- **src/main/java/util**: Пакет содержит утилитарные классы, такие как конфигурация браузера и настройка запросов.
- **src/test/java**: Пакет содержит тестовые классы, организованные по функциональным разделам (например, тесты регистрации, тесты входа и т.д.).

## Требования

- Java 11
- Maven 3.6+
- ChromeDriver и GeckoDriver (управляются через WebDriverManager)

## Запуск тестов
Вы можете запускать тесты в различных браузерах, используя системное свойство browser. Например:

Запуск тестов в Chrome:
mvn test -Dbrowser=chrome

Запуск тестов в Firefox:
mvn test -Dbrowser=firefox

## Генерация Allure-отчета

После завершения тестов вы можете сгенерировать Allure-отчет:
mvn allure:serve
