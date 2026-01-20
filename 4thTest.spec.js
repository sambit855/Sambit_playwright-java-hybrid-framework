import { test, expect } from '@playwright/test';
test('textbox', async ({ page }) => {

    //Launch browser
    await page.goto('https://automationexercise.com/');

    //veryfy home page is displayed correctly
    await expect(await page.title()).toBe('Automation Exercise');

    //Click on 'Signup / Login' button
    await page.getByText('Signup / Login').click();

    //Verify 'New User Signup!' is visible
    const UserText = await page.getByText('New User Signup!', { exact: true }).isVisible();
    console.log('Resgister user test is displayed ', UserText);

    //Enter name and already registered email address
    await page.getByPlaceholder('Name').fill('sambit');
    await page.locator("input[data-qa='signup-email']").fill('sambit11@gmail.com');
    await page.click("button[data-qa = 'signup-button']");

    //Verify error 'Email Address already exist!' is visible
    const InlineError = await page.locator("//p[normalize-space()='Email Address already exist!']").isVisible();
    console.log('Inline error for resgisre user is displayed : ', InlineError);

 //   await page.close();



});