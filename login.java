package Practices;

import com.microsoft.playwright.*;

public class login {

    public static void main(String[] args) throws Inter
    uptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context1 =  browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
        Page page  = context1.newPage();
        page.navigate("https://www.facebook.com/");
        System.out.println( "Page title is  " + page.title());

        //print all the links
        Locator links = page.locator("a");
        int linkCount = links.count();
        System.out.println("Total links count : " + linkCount );

        //Print all links text
         for(int i = 0 ; i < linkCount ; i ++){
            String LinkText = links.nth(i).textContent().trim();
             System.out.println(LinkText);
        }


        //Get the header Text
        Locator HeaderText = page.locator("h2._8eso");
        String ScreenText  = HeaderText.textContent().trim();
        System.out.println("HeaderText is   : " + ScreenText );
        if (ScreenText.equals("Facebook helps you connect and share with the people in your life.")){ // check the text is displayed correct
            System.out.println("This Header text is correct as per design");
        }
        else{
            System.out.println("incorrect Txt Display");
        }
        //Fill the login form

        page.locator("input[id = 'email']").fill("sambit855@gmail.com");
        page.locator("input[id = 'pass']").fill("sambit1122");
        page.locator("button[data-testid = 'royal-login-button']").click();
        Thread.sleep(3000);

        //dose the inline error incorrect password ?
        boolean IncorrectPassword =  page.locator("div[class ='_9ay7']").isVisible();
        System.out.println("inline error displayed ? : " + IncorrectPassword);
        //Get the inline error password
        if(IncorrectPassword){
           String errorText =  page.locator("div[class ='_9ay7']").innerText().trim();
            System.out.println(" Error Text is : " + errorText);
        }



        context1.close();
        playwright.close();






    }
}
