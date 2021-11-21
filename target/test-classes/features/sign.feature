Feature: Login

  Background: Verify login with valid credentials
    Given Initialize the browser with chrome
    And Navigate to  "http://realty-real-estatem1.upskills.in/my-profile/" site
    And Click on Login link in home page to land on Secure sign in Page
    When I entered valid mohankrishna176@gmail.com and valid Secret@123&& logs in
    Then Click on signin button

  @Activity
  Scenario: Working Functionality of Activity Option
    Given User get the dashboard
    And tap on Activity
    And user obtain Some options
    When person tap on option
    Then Each option should be easily  reachable

  @Glance
  Scenario: Checking functionality of At a Glance
    Given User clicks on At a glance drapdown
    And User gets few options
    When User clicks on each option
    Then Each options available should be accessible

  @Quickdraft
  Scenario: Quick Draft Working Capability
    Given Entering text in Title box
    And Adding text to the content box
    Then hit on Save Draft button

  @WordPress
  Scenario: Check the working of WordPress Events and News
    Given user go to  WordPress Events and News
    When Options are available to the user
    Then Every choice will display some content

  @WoocommerceStatus
  Scenario: Verify the working functionality of Woocommerce Status
    Given user move to WooCommerce Status Options
    And Order Status of Woocommerce Should be appered
    Then click on Each option
    And It display the relavent content

 