const { defineConfig } = require("cypress");
module.exports = defineConfig({
  "reporter": "mochawesome",
  "reporterOptions": {
    "reportDir": "cypress/reports/mochawesome",
    "overwrite": false,
    "html": true,
    "json": true,
    "reportFilename": "mocha"
  },

  chromeWebSecurity: false,
  video: true,
  e2e: {
    "viewportWidth": 1400,
    "viewportHeight": 900,
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
  env: {
    URL: 'https://demo.nopcommerce.com/'
  }
});
