@app
Feature: App feature

  Scenario: Creating an order from the mobile application
    Given etsy app opens on phone
    Then Choose Continue as guest option
    Then Choose Maybe Later option
    Then Click the searchbox and type "leather wallet" then search
    And Choose the first product from the results
    And Add to cart after selects size from the edit item section
    Then Makes payment from the proceed to checkout section