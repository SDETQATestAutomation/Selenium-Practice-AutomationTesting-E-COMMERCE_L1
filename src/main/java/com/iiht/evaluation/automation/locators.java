package com.iiht.evaluation.automation;

import java.util.HashMap;
import java.util.Map;

public class locators {
    public static final Map<String, String> arrival_add_to_basket_items_element = new HashMap<>();

    static {
        arrival_add_to_basket_items_element.put("shop_menu_link", "//li[contains(@id,'menu-item')]/a[text()='Shop']");
        arrival_add_to_basket_items_element.put("shop_page_nav", "//div[@id='content']/nav");
        arrival_add_to_basket_items_element.put("home_menu_link", "//div[@id='content']/nav/a[text()='Home']");
        arrival_add_to_basket_items_element.put("new_arrival_div", "//h2[text()='new arrivals']/ancestor::div[contains(@class,'first tb-column')]");
        arrival_add_to_basket_items_element.put("new_arrival_product_ul_list", "//h2[text()='new arrivals']/ancestor::div[contains(@class,'first tb-column')]/descendant::ul[@class='products']");
        arrival_add_to_basket_items_element.put("new_arrival_product_h3_text", "//h2[text()='new arrivals']/ancestor::div[contains(@class,'first tb-column')]/descendant::ul[@class='products']/descendant::h3[text()='$(product_name)']");
        arrival_add_to_basket_items_element.put("new_arrival_product_h3_text_link", "//h2[text()='new arrivals']/ancestor::div[contains(@class,'first tb-column')]/descendant::ul[@class='products']/descendant::h3[text()='$(product_name)']/parent::a");
        arrival_add_to_basket_items_element.put("new_arrival_product_page_nav", "//div[@id='content']/nav");
        arrival_add_to_basket_items_element.put("new_arrival_product_summary_name_text", "//div[contains(@class,'summary')]/h1[text()='$(product_name)']");
        arrival_add_to_basket_items_element.put("new_arrival_product_summary_price_text", "//div[contains(@class,'summary')]/h1[text()='$(product_name)']/following-sibling::div/p[contains(.,'$(price_text)')]");
        arrival_add_to_basket_items_element.put("new_arrival_product_summary_add_to_basket_button", "//button[text()='Add to basket']");
        arrival_add_to_basket_items_element.put("new_arrival_product_summary_add_to_basket_message", "//div[@id='content']/descendant::div[contains(@class,'message')]");
        arrival_add_to_basket_items_element.put("new_arrival_product_summary_item_count_number", "//form[@class='cart']/descendant::input[@type='number']");
        arrival_add_to_basket_items_element.put("new_arrival_product_summary_cart_item_detail_link", "//li[@id='wpmenucartli']/a");
        arrival_add_to_basket_items_element.put("new_arrival_product_summary_cart_item_detail_no_of_item_span", "//li[@id='wpmenucartli']/a/descendant::span[1]");
        arrival_add_to_basket_items_element.put("new_arrival_product_summary_content_container", "//div[@class='pp_content_container']");
        arrival_add_to_basket_items_element.put("new_arrival_product_summary_content_container_close_link", "//div[@class='pp_content_container']/descendant::a[contains(.,'Close')]");
        arrival_add_to_basket_items_element.put("view_your_shopping_cart_link", "//a[@title='View your shopping cart']");
        arrival_add_to_basket_items_element.put("shopping_cart_coupon_button", "//div[@class='coupon']/descendant::input[@type='submit']");
        arrival_add_to_basket_items_element.put("shopping_cart_product_price", "//td[@data-title='Product' and contains(.,'$(product_name)')]/following-sibling::td[@data-title='Price']");
        arrival_add_to_basket_items_element.put("shopping_cart_product_quantity", "//td[@data-title='Product' and contains(.,'$(product_name)')]/following-sibling::td[@data-title='Quantity']/descendant::input");
        arrival_add_to_basket_items_element.put("shopping_cart_product_total", "//td[@data-title='Product' and contains(.,'$(product_name)')]/following-sibling::td[@data-title='Total']");


    }
}
