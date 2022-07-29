package pageobjects;

import base.BaseClass;

public class ProductsListPage extends BaseClass {

    public String getCurUrl()
    {
       String productsListUrl = driver.getCurrentUrl();
       return productsListUrl;
    }


}
