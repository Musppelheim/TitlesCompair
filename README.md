# TitlesCompair
## Description
This repository contains an autotest script written in Java using the Selenide framework. The script is designed to test the functionality of a web application, specifically the login process for Microsoft Outlook Mail. The test case performs the following steps:

1. Open the Outlook Mail login page.
2. Enter the provided username and password.
3. Assert that the page title matches the expected title.
4. Check the visibility of all input fields on the page.

## Prerequisites
To run this autotest, you need to have the following installed:
- Java Development Kit (JDK) version 11 or later

## Test Data
The test uses predefined values for the username and password, which are stored in the MailCredentials class. Please ensure that the provided credentials are valid for the test to execute successfully.

`MailCredentials.java`:
```java
public class MailCredentials {
    public static final String USERNAME = "your_username";
    public static final String PASSWORD = "your_password";
    }
```
