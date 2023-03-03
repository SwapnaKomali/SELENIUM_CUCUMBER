Feature: Place Order: Register before Checkout 

@Testplaceorder
Scenario: User is able to place the order
    Given user is able to open the URL
    And Verify that home page is visible successfully
    And user is click on  sign up button
    Then Fill all details in Signup and create account
    And Verify ACCOUNT CREATED! and click Continue button
    Then Verify Logged in as username at top
    When click on Products button and verify "ALL PRODUCTS" page is visible
    Then Hover over first product and click Add to cart
    And Click Continue Shopping button
    Then Hover over second product and click Add to cart
    And Click View Cart button
    Then and Click Proceed To Checkout
    And Verify that the delivery address is same address filled at the time registration of account
    And Verify that the billing address is same address filled at the time registration of account
    Then Enter description in comment text area and click Place Order
    And  Enter payment details
    And Click Pay and Confirm Order button 
    Then Verify success message Your order has been placed successfully!
    Then Click Delete Account button
    And Verify ACCOUNT DELETED!and click Continue button