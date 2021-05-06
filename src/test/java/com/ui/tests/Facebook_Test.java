package com.ui.tests;

import org.testng.annotations.Test;
import util.ExcelReadNWrite;

import java.io.IOException;

public class Facebook_Test extends BaseTest {


    @Test(priority = 1)
    public void Facebook_Navigation1() throws InterruptedException, IOException {

        for (int i = 1; i <= 1; i++) {

            Facebook_Page facebook_page = new Facebook_Page(driver);

            ExcelReadNWrite excelDoc = new ExcelReadNWrite("data/Data.xlsx", "Sheet1");

            String excelColumn0 = null;
            int excelColumn1 = 0;

            //Get data from Excel
            excelColumn0 = excelDoc.getColumnStringValue(excelColumn0, 0, i);
            excelColumn1 = excelDoc.getColumnIntValue(excelColumn1, 1, i);

            //Write data to Excel
            excelDoc.setColumnValue("123123987", 2, i);

            System.out.println(excelColumn0);
            System.out.println(excelColumn1);

//        Thread.sleep(400000);

            driver.get("https://www.facebook.com/");
            facebook_page.enterUsername(excelColumn0);
            facebook_page.enterPassword(String.valueOf(excelColumn1));
            facebook_page.clickOnLogin();

            Thread.sleep(6000);


        }







/*
    @Test(priority=2)
    public void FaceFacebook_Navigation2() throws InterruptedException {
        Facebook_Page facebook_page = new Facebook_Page(driver);

    }
*/

    }
}
