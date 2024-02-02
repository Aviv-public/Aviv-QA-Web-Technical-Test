const { defineConfig } = require("cypress");
const cucumber = require('cypress-cucumber-preprocessor').default

module.exports = defineConfig({
  reporter: 'cypress-mochawesome-reporter',
  reporterOptions: {
    reportDir: "reports",
    charts: true,
    reportPageTitle: 'AVIV Task QA Report',
    embeddedScreenshots: true,
    inlineAssets: true,
    saveAllAttempts: false,
    debug: true,
  },
  env: {
    baseUrl: 'https://demo.nopcommerce.com/',
  },
  e2e: {
    setupNodeEvents(on, config) {
      require('cypress-mochawesome-reporter/plugin')(on);
      on('file:preprocessor', cucumber())
    },
    specPattern: "cypress/integration/features/*.feature",
  },
  retries: {
      runMode: 2,
      openMode: 2
    },
});
