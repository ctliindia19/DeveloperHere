package com.developerhere.elementbase;

import org.openqa.selenium.WebDriver;

import com.developerhere.base.BaseClass;

public class BaseElements extends BaseClass {

    public void closeBrowser() {
        wait(5);
        driver.close();
    }

    public BaseElements(WebDriver driver) {
        BaseClass.driver = driver;
    }
}
