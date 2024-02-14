
import homePage from '../../pageObjects/homePage'
import registrationPage from '../../pageObjects/registrationPage';


const homeObject = new homePage();
const regObject = new registrationPage();

describe('Scenario 2: Invalid Signup Attempt', ()=>
{   
   const testData = require("../../fixtures/invalidData.json");
   testData.forEach((data) => {
    it('Invalid Registration',()=>{
      homeObject.clickOnRegister();
     regObject.enterInvalidRegistrationDetails(data.invalidEmail, data.invalidPassword);
     regObject.clickOnRegisterButtonForInvalidData();
    })
   })
   
 
 })
 