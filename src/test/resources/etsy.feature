@etsy
Feature: The user adds a product to the cart from both the etsy web page and the mobile application and completes the shopping.


  Scenario: Creating an order from the web page
    Given User goes to "https://www.etsy.com/" web page
    Then Type "leather wallet" in the search box and search
    And Adds the first product in the search result to the cart
    And Selects size and color from the Edit item section
    And Makes payment from the Proceed to checkout section



