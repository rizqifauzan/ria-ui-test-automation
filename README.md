# UI Test Automation Framework

## Tujuan Proyek
Proyek ini bertujuan untuk membuat kerangka kerja otomatisasi pengujian UI Web menggunakan:

- Java
- Gradle
- Selenium WebDriver
- Cucumber (BDD)
- JUnit 5
- Dengan pola desain **Page Object Model (POM)**

---

## Struktur Direktori

```
src
├── test
│   ├── java
│   │   ├── pages               # Halaman POM (LoginPage.java)
│   │   ├── stepdefinitions     # Langkah-langkah Cucumber
│   │   └── runners             # Test runner JUnit
│   └── resources
│       └── features            # File .feature (Login.feature)
build.gradle
README.md
```

---

## Penyiapan & Konfigurasi

### Syarat:
- Java JDK 17+
- IntelliJ IDEA (atau IDE lain)
- Chrome + ChromeDriver (sesuai versi browser)

### Install dependensi:
```bash
./gradlew clean build
```

---

## Cara Menjalankan Pengujian

### 1. Via Terminal
```bash
./gradlew test
```

### 2. Via IntelliJ IDEA
- Klik kanan pada `TestRunner.java`
- Pilih `Run 'TestRunner'`

---

## Contoh Skenario (Login.feature)
```gherkin
Feature: Login Page

Scenario: Successful login with valid credentials
    Given User opens the login page
    When User inputs valid username and password
    And User clicks the login button
    Then User should be redirected to the dashboard

  Scenario: Login with invalid credentials
    Given User opens the login page
    When User inputs invalid username and password
    And User clicks the login button
    Then User should see an error message
```

---

## Dependencies (build.gradle)

```groovy
dependencies {
    implementation 'org.seleniumhq.selenium:selenium-java:4.20.0'
    testImplementation 'io.cucumber:cucumber-java:7.15.0'
    testImplementation 'io.cucumber:cucumber-junit-platform-engine:7.15.0'
    testImplementation 'org.junit.platform:junit-platform-suite:1.10.0'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.10.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.10.0'
}
```

---

## Pengumpulan
Link repositori GitHub :  
👉 https://github.com/aiR2729/ui-test-automation

