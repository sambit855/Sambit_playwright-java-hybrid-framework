import {test,expect} from '@playwright/test';

test('checkbox' , async({page})=>{

await page.goto ('https://testautomationpractice.blogspot.com/');

//multi checkbox
 const DaysCheckBox = [

         '#sunday',
        '#monday',
        '#tuesday',
        '#friday'
 ];

for(const days of DaysCheckBox)
{
await page.locator(days).click();
}


});