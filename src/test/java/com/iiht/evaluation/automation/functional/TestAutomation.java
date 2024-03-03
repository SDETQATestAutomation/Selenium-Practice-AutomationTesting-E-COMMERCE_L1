package com.iiht.evaluation.automation.functional;


import com.iiht.evaluation.automation.Activities;
import com.iiht.evaluation.automation.App;
import com.iiht.evaluation.automation.testutils.MasterData;
import com.iiht.evaluation.automation.testutils.xls.Xls_Utils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAutomation extends App {

    @Test(priority = 1)
    public void tc_001_test_arrival_add_to_basket_items_click_on_shop_menu() throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_shop_menu_succeed = Activities.click_shop_menu(driver);
            System.out.println("click_shop_menu_succeed " + click_shop_menu_succeed);
            if (!click_shop_menu_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test(priority = 2)
    public void tc_002_test_check_click_on_shopping_cart_if_no_item_added() throws IOException {
        boolean testcase_status = true;
        try {
            boolean check_click_on_shopping_cart_if_no_item_added_succeed = Activities.check_click_on_shopping_cart_if_no_item_added(driver);
            System.out.println("check_click_on_shopping_cart_if_no_item_added_succeed " + check_click_on_shopping_cart_if_no_item_added_succeed);
            if (!check_click_on_shopping_cart_if_no_item_added_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test(priority = 3)
    public void tc_003_test_check_shopping_cart_display_zero_item_if_no_item_added() throws IOException {
        boolean testcase_status = true;
        try {
            boolean check_shopping_cart_display_zero_item_if_no_item_added_succeed = Activities.check_shopping_cart_display_zero_item_if_no_item_added(driver);
            System.out.println("check_shopping_cart_display_zero_item_if_no_item_added_succeed " + check_shopping_cart_display_zero_item_if_no_item_added_succeed);
            if (!check_shopping_cart_display_zero_item_if_no_item_added_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test(priority = 4)
    public void tc_004_test_arrival_add_to_basket_items_click_home_menu_button() throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_home_menu_button_succeed = Activities.click_home_menu_button(driver);
            System.out.println("click_home_menu_button_succeed " + click_home_menu_button_succeed);
            if (!click_home_menu_button_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test(priority = 5)
    public void tc_005_test_check_home_page_has_three_arrivals() throws IOException {
        boolean testcase_status = true;
        try {
            boolean check_home_page_has_three_arrivals_succeed = Activities.check_home_page_has_three_arrivals(driver);
            System.out.println("check_home_page_has_three_arrivals_succeed " + check_home_page_has_three_arrivals_succeed);
            if (!check_home_page_has_three_arrivals_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test(priority = 6,dataProvider = "getTestData")
    public void tc_006_test_click_image_in_arrival(String product_name) throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_image_in_arrival_succeed = Activities.click_product_product_image_in_arrival(driver, product_name);
            System.out.println("click_image_in_arrival_succeed " + click_image_in_arrival_succeed);
            if (!click_image_in_arrival_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test(priority = 7)
    public void tc_007_test_click_add_to_basket_button_product_detail_page() throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_add_to_basket_button_product_detail_page_succeed = Activities.click_add_to_basket_button_product_detail_page(driver);
            System.out.println("click_add_to_basket_button_product_detail_page_succeed " + click_add_to_basket_button_product_detail_page_succeed);
            if (!click_add_to_basket_button_product_detail_page_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test(priority = 8)
    public void tc_008_test_check_product_added_message_product_detail_page() throws IOException {
        String product_name = MasterData.test_arrival_add_to_basket_items_master_data.get("product_name");
        boolean testcase_status = true;
        try {
            boolean check_product_added_message_product_detail_page_succeed = Activities.check_product_added_message_product_detail_page(driver, product_name);
            System.out.println("check_product_added_message_product_detail_page_succeed " + check_product_added_message_product_detail_page_succeed);
            if (!check_product_added_message_product_detail_page_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    public void test_click_item_detail_menu() throws IOException {
        boolean testcase_status = true;
        try {
            boolean click_item_detail_menu_succeed = Activities.click_item_detail_menu(driver);
            System.out.println("click_item_detail_menu_succeed " + click_item_detail_menu_succeed);
            if (!click_item_detail_menu_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @Test
    public void test_check_product_total_checkout_page() throws IOException {
        String product_name = MasterData.test_arrival_add_to_basket_items_master_data.get("product_name");
        boolean testcase_status = true;
        try {
            boolean check_product_total_checkout_page_succeed = Activities.check_product_total_checkout_page(driver, product_name);
            System.out.println("check_product_total_checkout_page_succeed " + check_product_total_checkout_page_succeed);
            if (!check_product_total_checkout_page_succeed) {
                testcase_status = false;
            }
            System.out.println("testcase_status " + testcase_status);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        } catch (Exception ex) {
            System.out.println("ex " + ex);
//            yakshaAssert(currentTest(), testcase_status, businessTestFile);
        }
    }

    @DataProvider
    public Object[][] getTestData(){
        return Xls_Utils.getData(test_data_xls, "TC_006") ;
    }



}

