package com.oee.controller;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class TaxPortalPDFDownloader {

    public static void main(String[] args) {
        // Set download directory
        String downloadFilepath = "C:\\Downloads\\TaxNotices";
        File file = new File(downloadFilepath);
        if (!file.exists()) file.mkdirs();

        // Set Chrome preferences for automatic download
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        chromePrefs.put("plugins.always_open_pdf_externally", true); // Avoid opening in browser

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Open the tax portal login page
            driver.get("https://eportal.incometax.gov.in/iec/foservices/#/login");

            // Login - Replace these selectors with actual ones
         //   driver.findElement(By.id("panAdhaarUserId")).sendKeys("ALOPQ4340B");
        
          //  driver.findElement(By.className("marTop16")).click();
            
            
			/*
			 * driver.findElement(By.id("password")).sendKeys("keshav123");
			 * 
			 * // passwordCheckBox-input
			 * 
			 * driver.findElement(By.id("adminLoginAction-js-login")).click();
			 * 
			 * // Navigate to notices/downloads
			 * driver.findElement(By.linkText("Notices")).click();
			 * 
			 * // Locate download link/button WebElement downloadBtn =
			 * driver.findElement(By.xpath("//a[contains(text(), 'Download PDF')]"));
			 * downloadBtn.click(); // Triggers PDF download
			 * 
			 * // Wait for download to complete (naive way)
			 */          
            
            Thread.sleep(500000);

            System.out.println("PDF Downloaded to: " + downloadFilepath);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
