const { defineConfig } = require("cypress");
module.exports = defineConfig({
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
