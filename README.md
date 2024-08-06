## java-developer
Задание java-разработки от Т-Банка

# # Описание

 **Translation Service** - это веб-приложение для перевода текста с одного языка на другой с использованием стороннего сервиса перевода. Приложение работает на Spring Boot и использует REST API для выполнения переводов.

## Требования
Java 22 (или выше)
## Установка
Клонируйте репозиторий:


```
git clone https://github.com/Nadineenik/java-developer
cd translation-service
```
Убедитесь, что у вас установлена JDK 22.

### Запуск приложения
Найдите файл JAR в каталоге target/, который был предоставлен в репозитории. Убедитесь, что он имеет название, например translation-service-1.0.0.jar.

Запустите приложение:

**Для Windows:**

Используйте файл run.bat:

Запустите run.bat, чтобы запустить приложение.

**Для Unix-подобных систем (Linux, macOS):**

Используйте файл run.sh:

*Сделайте файл исполняемым:*

`
chmod +x start.sh
`

Запустите run.sh, чтобы запустить приложение:

`
./start.sh
`

### Проверьте, что приложение работает, открыв веб-браузер или использовав curl для выполнения запроса:
`
curl -v "http://localhost:8080/translate?text=Hello%20world&sourceLang=en&targetLang=ru"
`

Вы должны получить ответ с переведенным текстом.

### Часто задаваемые вопросы
**Как изменить порт приложения?**

Измените значение server.port в файле application.properties (если файл настроек присутствует).

**Как изменить URL стороннего сервиса перевода?**

Измените значение translation.api.url в файле application.properties (если файл настроек присутствует).

**Как добавить новые функции?**

Измените соответствующие контроллеры и сервисы в каталоге src/main/java/com/example/translationservice (если вы имеете доступ к исходному коду).
