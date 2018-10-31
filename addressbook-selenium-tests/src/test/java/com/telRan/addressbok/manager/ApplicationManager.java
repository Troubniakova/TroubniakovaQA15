package com.telRan.addressbok.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    private  ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private String browser;

    public ApplicationManager(WebDriver wd) {
        contactHelper = new ContactHelper(wd);
    }

    public ApplicationManager() {

    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void start() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
        navigationHelper = new NavigationHelper(wd);
        navigationHelper.openSite("http://localhost/addressbook");
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        groupHelper = new GroupHelper(wd);

        sessionHelper.login("admin", "secret");

    }



    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
