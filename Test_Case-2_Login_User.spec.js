import { test, expect } from '@playwright/test';
test('Login With correct user ', async ({ page }) => {

    //Launch browser
    await page.goto('https://automationexercise.com/');

    // Verify that home page is visible successfully

    await expect(await page.title()).toBe('Automation Exercise');

    // Click on 'Signup / Login' button
    await page.locator("a[href='/login']").click();

    //Verify 'Login to your account' is visible
    const logintext = await page.locator("div[class='login-form'] h2").textContent()
    await expect(logintext).toBe('Login to your account');

    //Enter correct email address and password
    await page.fill("input[data-qa='login-email']", 'debsmita11900@gmail.com');
    await page.fill("input[placeholder='Password']", 'sambit@1991');

    //Click 'login' button
    await page.click("button[data-qa='login-button']");

    //Verify that incorrect user Inline error dipslayed is visible
    const InlineErrorText = await page.locator('div.login-form p').textContent();
    console.log('Invalid user inline error is : ', InlineErrorText);
    await expect(InlineErrorText).toBe('Your email or password is incorrect!');

});