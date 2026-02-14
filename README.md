# Automation Exercise Test Framework

## Project Overview
This is an end-to-end test automation framework for the [Automation Exercise](https://automationexercise.com) website, covering both UI and API testing.

## Team Members
- **Giorgi Malkhaziani** - Complete framework implementation

## Technology Stack
- **Language**: Java 11
- **Build Tool**: Maven
- **UI Automation**: Selenium WebDriver
- **API Automation**: RestAssured
- **Test Framework**: TestNG
- **Reporting**: Allure Reports
- **Design Pattern**: Page Object Model (POM)

## Test Coverage

### UI Tests (10 test cases)
| Test Case | Description |
|-----------|-------------|
| TC-1 | Register User |
| TC-2 | Login User with correct credentials |
| TC-3 | Login User with incorrect credentials |
| TC-4 | Logout User |
| TC-5 | Register User with existing email |
| TC-6 | Contact Us Form |
| TC-7 | Verify All Products |
| TC-8 | Search Product |
| TC-9 | Verify Product Details |
| TC-10 | Add Products in Cart |

### API Tests (10 test cases)
| Test Case | Description |
|-----------|-------------|
| API-1 | Get All Products List |
| API-2 | POST To All Products List |
| API-3 | Get All Brands List |
| API-4 | PUT To All Brands List |
| API-5 | POST To Search Product |
| API-6 | POST To Search Product without parameter |
| API-7 | POST To Verify Login with valid details |
| API-8 | POST To Verify Login without email |
| API-9 | DELETE To Verify Login |
| API-10 | POST To Create User Account |

## Project Structure
```
automation-framework/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/           # Page Object classes
│   │       └── utils/           # Utility classes
│   └── test/
│       ├── java/
│       │   ├── ui/              # UI test classes
│       │   └── api/             # API test classes
│       └── resources/
│           └── testng.xml       # TestNG configuration
├── pom.xml                      # Maven dependencies
└── README.md
```

## Prerequisites
Before running the tests, make sure you have:
1. **Java JDK 11** or higher installed
2. **Maven** installed
3. **Google Chrome** browser installed
4. **Allure** command-line tool installed (optional, for viewing reports)

## Installation Steps

### 1. Install Java
Download and install Java JDK 11 from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use OpenJDK.

Verify installation:
```bash
java -version
```

### 2. Install Maven
Download Maven from [Apache Maven](https://maven.apache.org/download.cgi) and add it to your PATH.

Verify installation:
```bash
mvn -version
```

### 3. Install Allure (Optional)
For Windows (using Scoop):
```bash
scoop install allure
```

For Mac (using Homebrew):
```bash
brew install allure
```

Verify installation:
```bash
allure --version
```

## Running the Tests

### 1. Clone the repository
```bash
git clone <repository-url>
cd automation-framework
```

### 2. Install dependencies
```bash
mvn clean install -DskipTests
```

### 3. Run all tests
```bash
mvn clean test
```

### 4. Run specific test suite
Run only UI tests:
```bash
mvn test -Dtest=ui.*
```

Run only API tests:
```bash
mvn test -Dtest=api.*
```

### 5. Generate Allure report
After running tests, generate the Allure report:
```bash
mvn allure:report
```

View the report:
```bash
mvn allure:serve
```

This will automatically open the report in your default browser.

## Framework Features

### 1. Page Object Model (POM)
- Clean separation between test logic and page elements
- Reusable page classes for better maintainability
- All page objects extend BasePage for common operations

### 2. Explicit Waits
- No hard-coded Thread.sleep() calls
- WebDriverWait with ExpectedConditions for reliable element interactions
- Configurable timeout periods

### 3. Parallel Execution
- Tests can run in parallel using TestNG
- Configured for 2 parallel threads
- Thread-safe WebDriver management

### 4. Comprehensive Reporting
- Allure reports with detailed test steps
- Screenshots automatically captured on test failures
- API request/response logging
- Test execution history and trends

### 5. Test Listeners
- Custom TestListener for enhanced logging
- Automatic screenshot capture on UI test failures
- Test execution tracking

## Configuration
- **Base URL**: https://automationexercise.com
- **Browser**: Chrome (can be extended to support multiple browsers)
- **Timeout**: 15 seconds for explicit waits
- **Parallel Execution**: 2 threads

## Troubleshooting

### Issue: ChromeDriver not found
**Solution**: Make sure Chrome browser is installed. Maven will automatically download the appropriate ChromeDriver.

### Issue: Tests failing due to timeout
**Solution**: Check your internet connection. The application requires internet access to reach automationexercise.com.

### Issue: Allure report not generating
**Solution**: Make sure Allure is installed and available in your PATH. Run `allure --version` to verify.
