package automation_Exericies;

import com.microsoft.playwright.*;

public class Test_Case_8_Verify_All_Products_and_product_detail_page {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        //. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        Page page = context.newPage();
        page.navigate("https://automationexercise.com/");
        System.out.println("Home Page Title : " + page.title());

        //Click on 'Products' button
        page.locator("a:has-text(' Products')").click();
        System.out.println(" Verify user is navigated to ALL PRODUCTS page successfully " + page.title());
        //The products list is visible
        Locator ProductList = page.locator("div.features_items div.col-sm-4");
        int ProductCount = ProductList.count();
        System.out.println("Total product of the page is : " + ProductCount);
        //Print The products list is visible
        for (int i = 0; i < ProductCount; i++) {
            String ProductText = ProductList.nth(i).textContent().trim();
            System.out.println(" Product name : " + ProductText);

        }
        // Click on 'View Product' of first product
        page.locator("a[href='/product_details/1']").click();

        //Verify that detail is visible: product name, category, price, availability, condition, brand
        Locator Product1 = page.locator(" div.product-information");
        String Product1Details = Product1.textContent().trim();
        System.out.println(" product details ::: " + Product1Details);

        context.close();
        playwright.close();


    }
}
