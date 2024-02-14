const { defineConfig } = require("cypress");

module.exports = defineConfig({
  reporter: 'cypress-mochawesome-reporter',
  e2e: {
    watchForFileChanges:false,
    video: true,
    videosFolder: 'cypress/videos',
    defaultCommandTimeout: 4000,
    requestTimeout: 6000,
    responseTimeout: 10000,
    "env":
    {
      "url": "https://demo.nopcommerce.com/"
    },
    setupNodeEvents(on, config) {
      // implement node event listeners here
      require('cypress-mochawesome-reporter/plugin')(on);
    }
   
  }
});
