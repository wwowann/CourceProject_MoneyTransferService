## Курсовой проект "Сервис первода денег"

### Описание проекта
Разработано приложение — REST-сервис. Сервис представляет собой интерфейс для перевода денег с одной карты на другую по заранее описанной спецификации.

Заранее подготовленное веб-приложение (FRONT) подключается к разработанному сервису без доработок и его функционал используется для перевода денег.

Весь API FRONT описан в соответствии YAML файла по спецификации OpenAPI (подробнее по [ссылке 1](https://swagger.io/specification/) и [ссылке2](https://starkovden.github.io/introduction-openapi-and-swagger.html)).

### Требования к приложению
* сервис предоставляет REST-интерфейс для интеграции с FRONT.
* сервис реализовывает все методы перевода с одной банковской карты на другую, описанные в протоколе.
* все изменения записываются в файл — лог переводов в произвольном формате с указанием:
    - даты;
    - времени;
    - карты, с которой было списание;
    - карты зачисления;
    - суммы;
    - комиссии;
    - результата операции, если был.
### Требования в реализации
* приложение разработано с использованием Spring Boot.
* Использован сборщик пакетов gradle.
* код размещён на GitHub.

