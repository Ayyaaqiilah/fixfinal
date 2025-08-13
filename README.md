# Automation Test Framework (API + Web)

## Teknologi
- Java 17
- Gradle
- Cucumber (Gherkin)
- Selenium WebDriver (Chrome)
- RestAssured (API)
- WebDriverManager
- GitHub Actions

## Struktur Project
src
├── main
│ ├── java
│ │ └── com.example
│ │ └── Main.java
│ └── resources
├── test
│ ├── java
│ │ ├── api
│ │ │ ├── hooks
│ │ │ │ └── ApiHooks.java
│ │ │ ├── requests
│ │ │ │ ├── BaseApi.java
│ │ │ │ └── UserApi.java
│ │ │ ├── runners
│ │ │ │ └── ApiTestRunner.java
│ │ │ └── steps
│ │ │ └── ApiSteps.java
│ │ ├── web
│ │ │ ├── hooks
│ │ │ │ └── WebHooks.java
│ │ │ ├── pages
│ │ │ │ ├── LoginPage.java
│ │ │ │ └── ProductsPage.java
│ │ │ ├── runners
│ │ │ │ └── WebTestRunner.java
│ │ │ ├── steps
│ │ │ │ └── WebSteps.java
│ │ │ └── utils
│ │ │ └── WebDriverFactory.java
│ └── resources
│ └── features
│ ├── api
│ │ └── api.feature
│ └── web
│ └── login.feature
├── build.gradle
├── settings.gradle
├── gradlew
├── gradlew.bat
├── .gitignore
└── README.md

## Menjalankan Test
- API:
./gradlew apiTest
Web UI:
./gradlew webTest
Semua test sekaligus:
./gradlew allTests