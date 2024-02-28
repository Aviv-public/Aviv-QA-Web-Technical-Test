import Register from "../pages/registerPage";
import { faker } from "@faker-js/faker";
const register = new Register();

describe("Scenario 2 - Invalid Signup Attempt", () => {
  beforeEach(() => {
    cy.visit("https://demo.nopcommerce.com/");
  });

  it("Should not register when all fields are empty", () => {
    register.navigateToRegisterPage();
    register.clickRegisterButton();
    register.validateTheRequiredFieldsOnEmptyForm();
  });
  it("Should not register when account for an email already exists", () => {
    register.registerNewUser({
      firstName: "Ayesha",
      lastName: "Raheed",
      email: "ayesha@gmail.com",
      password: "ayeshamysis2",
      confirmPassword: "ayeshamysis2",
    });
    register.validateEmailAlreadyExists();
  });

  it("Should not register when passwords dont match", () => {
    register.registerNewUser({
      firstName: faker.name.firstName(),
      lastName: faker.name.lastName(),
      email: faker.internet.email(),
      password: faker.internet.password(),
      confirmPassword: faker.internet.password(),
    });
    register.validatePasswordDontMatchMessage();
  });
});