import invalidSignUpPage from '../../pages/invalidSignUp';
import signUpPage from '../../pages/signUpPage'

import signUpData from "../../fixtures/signUpData.json";

describe('User Registration', () => {
    beforeEach(() => {
        signUpPage.openUrl();
    });

    it('should display error messages for invalid registration', () => {
        signUpPage.clickRegister();

        
        invalidSignUpPage.fillInvalidRegistrationForm(signUpData.FirstName, signUpData.LastName, signUpData.Email, signUpData.Password, signUpData.ConfirmPasswrd);

        
        invalidSignUpPage.getErrorMessages();
    });
});