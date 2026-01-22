import { test, expect } from '@playwright/test';
test('Register User', async ({ page }) => {

    //Launch browser

    await page.goto('https://automationexercise.com/');
    const PageTitele = await page.title();

    //Verify that home page is visible successfully
    await expect(PageTitele).toBe('Automation Exercise');


    //Click on 'Signup / Login' button
    await page.getByText(' Signup / Login').click();

    //erify 'New User Signup!' is visible
    const signupText = await page.getByText('New User Signup!').isVisible();
    console.log('SignupText is displayed?', signupText);
    await expect(await page.getByText('New User Signup!').textContent()).toBe('New User Signup!');


    //Enter name and email address

    await page.getByPlaceholder('Name').fill('Debasmita');
    await page.locator("input[data-qa= 'signup-email']").fill('debsmita11900@gmail.com');
    //Click 'Signup' button
    await page.locator("button[data-qa='signup-button']").click();

    //Verify that 'ENTER ACCOUNT INFORMATION' is visible
    const SignupText2 = await page.getByText('Enter Account Information').isVisible();
    console.log(SignupText2);
    expect(SignupText2).toBe(true);

    //Fill details: Title, Name, Email, Password, Date of birth
    await page.locator("label[for='id_gender1']").check();
    await page.locator('#password').fill('sambit@1991');
    await page.locator('#days').selectOption({value : '10'});
    await page.locator('#months').selectOption({value :'4'});
    await page.locator('#years').selectOption({value : '1996'});

    // Select checkbox 'Sign up for our newsletter!'
    await page.locator("label[for='newsletter']").check();
    //Select checkbox 'Receive special offers from our partners!'
    await page.locator("label[for='optin']").check();

    // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

    await page.fill('#first_name', 'debasmita');
    await page.fill('#last_name', 'Satapathy');
    await page.fill('#company', 'Deloitte');
    await page.fill('#address1', 'At - Samlpur,Po-Balia,Dist- Balasore');
    await page.fill('#address2', 'pin-756056,India');
    await page.fill('#state', 'Odisha');
    await page.fill('#city', 'Balasore');
    await page.fill('#zipcode', '756056');
    await page.fill('#mobile_number', '7681828953');

    //Click 'Continue' button
    await page.click("button[data-qa='create-account']");

    //Verify that 'ACCOUNT CREATED!' is visible
    const acountCreated = await page.locator("h2[class='title text-center'] b").isVisible();
    console.log('Account creted test is Visisble?', acountCreated);
    
    // Click 'Continue' button
    await page.click('.btn.btn-primary');
    //Verify that 'Logged in as username' is visible
    await page.locator("li:nth-child(10) a:nth-child(1)").isVisible();
    //Click 'Delete Account' button
    await page.locator("a[href='/delete_account']").click();
    //Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    await page.locator("h2[class='title text-center'] b").isVisible();




});