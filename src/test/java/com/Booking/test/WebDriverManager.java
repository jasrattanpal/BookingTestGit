package com.Booking.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

    public class WebDriverManager {


        private WebDriver driver;


        public void start() {


            String driverFilePath = Booking_Tests.class
                    .getClassLoader()
                    .getResource("geckodriver.exe").getFile();

            System.setProperty("webdriver.gecko.driver", driverFilePath);

            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        }

        public void quit() {

            driver.quit();

        }

        public WebDriver getDriver() {return driver;}

    }

