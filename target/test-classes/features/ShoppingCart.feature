Feature: Shopping Cart Functionality on Amazon

  Scenario: Adding a Monitor to Cart and Verifying Price and Subtotal
    Given user is on Amazon website
    When user types "Monitor" in the search field and presses Enter
    And user selects the 1st item from the list
    And user adds the item to the cart
    And user opens the cart
    Then verify that the price on the cart page matches the product page
    And verify that the subtotal on the cart page matches the product page


  Scenario: Adding a Monitor to Cart and Verifying Price and Subtotal
    Given user is on Amazon website
    When user types "Laptop" in the search field and presses Enter
    And user selects the 2nd item from the list
    And user adds the item to the cart
    And user opens the cart
    Then verify that the price on the cart page matches the product page
    And verify that the subtotal on the cart page matches the product page

  Scenario: Adding Headphones and Keyboard to Cart and Verifying Totals

    Given user is on Amazon website
    When user types "Headphones" in the search field and presses Enter
    And user selects the 1st item from the list
    And user adds the item to the cart
    And user types "Keyboard" in the search field and presses Enter
    And user selects the 1st item from the list
    And user adds the item to the cart
    And user opens the cart
    Then verify each item total price is correct
    And verify that the subtotal is calculated correctly