$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/PlaceHolder.feature");
formatter.feature({
  "line": 1,
  "name": "Testing",
  "description": "",
  "id": "testing",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 3,
      "value": "#multiple line and uncomment - ctrl +/"
    },
    {
      "line": 5,
      "value": "#Scenario Outline: Automating Ecommerce Website"
    },
    {
      "line": 6,
      "value": "#\tGiven The guest user Launches the application URL \"\u003cURL\u003e\""
    },
    {
      "line": 7,
      "value": "#\tWhen The user goes on Registration page, enter registration details as \"\u003cRegistrationDetails\u003e\" on \"\u003cMarket\u003e\""
    },
    {
      "line": 8,
      "value": "#\tThen The user verify has registered with application"
    },
    {
      "line": 9,
      "value": "#\tExamples:"
    },
    {
      "line": 10,
      "value": "#\t\t|URL|RegistrationDetails|Market|"
    },
    {
      "line": 11,
      "value": "#\t\t|http://automationpractice.com/index.php|mr,Tom,Alter,admin@1234,4,June,1990,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331|global|"
    }
  ],
  "line": 13,
  "name": "Place the Order as Guest User",
  "description": "",
  "id": "testing;place-the-order-as-guest-user",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "The guest user Launches the application URL \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "The user searches for the product \"\u003cProductName\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "The Product page for product \"\u003cProductName\u003e\" is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "The user choose the product size as \"\u003cProduct Size\u003e\" and quantity as \"\u003cProduct Quantity\u003e\" and Color as \"\u003cProduct Color\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "User selects Add to bag",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User selects View bag",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "The Cart page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Product \"\u003cProductName\u003e\" is displayed in cartPage",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "The user clicks on the Checkout Button",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "The user goes on Registration page, enter registration details as \"\u003cRegistrationDetails\u003e\" on \"\u003cMarket\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "The user clicks on the Checkout Button",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "The delivery page is displayed to the user",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "The user enters the delivery details \"\u003cDelivery Data\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "The Address page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "The user choose the delivery address as \"\u003cDelivery Address\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "The user clicks on the Checkout Button",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "The Shipping page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "The user clicks on the Checkout Button",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "The Payment page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "The user choose the payment method as \"\u003cPayment Method\u003e\"",
  "keyword": "When "
});
formatter.examples({
  "line": 35,
  "name": "",
  "description": "",
  "id": "testing;place-the-order-as-guest-user;",
  "rows": [
    {
      "cells": [
        "URL",
        "ProductName",
        "Product Size",
        "Product Quantity",
        "Product Color",
        "RegistrationDetails",
        "Delivery Data",
        "Delivery Address",
        "Payment Method"
      ],
      "line": 36,
      "id": "testing;place-the-order-as-guest-user;;1"
    },
    {
      "cells": [
        "http://automationpractice.com/index.php",
        "Printed Chiffon Dress",
        "L",
        "2",
        "Green",
        "mr,Tom,Alter,admin@1234,4,June,1990,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331",
        "Tom,Alter,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331,Shipping Address",
        "Shipping Address",
        "Pay by check"
      ],
      "line": 37,
      "id": "testing;place-the-order-as-guest-user;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 25534048200,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "Place the Order as Guest User",
  "description": "",
  "id": "testing;place-the-order-as-guest-user;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 14,
  "name": "The guest user Launches the application URL \"http://automationpractice.com/index.php\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "The user searches for the product \"Printed Chiffon Dress\"",
  "matchedColumns": [
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "The Product page for product \"Printed Chiffon Dress\" is displayed",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "The user choose the product size as \"L\" and quantity as \"2\" and Color as \"Green\"",
  "matchedColumns": [
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "User selects Add to bag",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User selects View bag",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "The Cart page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Product \"Printed Chiffon Dress\" is displayed in cartPage",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "The user clicks on the Checkout Button",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "The user goes on Registration page, enter registration details as \"mr,Tom,Alter,admin@1234,4,June,1990,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331\" on \"\u003cMarket\u003e\"",
  "matchedColumns": [
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "The user clicks on the Checkout Button",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "The delivery page is displayed to the user",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "The user enters the delivery details \"Tom,Alter,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331,Shipping Address\"",
  "matchedColumns": [
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "The Address page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "The user choose the delivery address as \"Shipping Address\"",
  "matchedColumns": [
    7
  ],
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "The user clicks on the Checkout Button",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "The Shipping page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "The user clicks on the Checkout Button",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "The Payment page is displayed",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "The user choose the payment method as \"Pay by check\"",
  "matchedColumns": [
    8
  ],
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "http://automationpractice.com/index.php",
      "offset": 45
    }
  ],
  "location": "GivenSteps.theGuestUserLaunchesTheApplication(String)"
});
formatter.result({
  "duration": 12210481700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Printed Chiffon Dress",
      "offset": 35
    }
  ],
  "location": "HeaderAndFooterSteps.theUserSearchesForTheProduct(String)"
});
formatter.result({
  "duration": 6913074600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Printed Chiffon Dress",
      "offset": 30
    }
  ],
  "location": "ProductSteps.theProductPageForProductIsDisplayed(String)"
});
formatter.result({
  "duration": 34581300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "L",
      "offset": 37
    },
    {
      "val": "2",
      "offset": 57
    },
    {
      "val": "Green",
      "offset": 74
    }
  ],
  "location": "ProductSteps.theUserChooseTheProductSizeAsAndQuantityAsAndColor(String,String,String)"
});
formatter.result({
  "duration": 6419932900,
  "status": "passed"
});
formatter.match({
  "location": "ProductSteps.userSelectsAddTobag()"
});
formatter.result({
  "duration": 115133300,
  "status": "passed"
});
formatter.match({
  "location": "ProductSteps.andViewBag()"
});
formatter.result({
  "duration": 2510405400,
  "status": "passed"
});
formatter.match({
  "location": "CartSteps.theCarPageIsDisplayed()"
});
formatter.result({
  "duration": 326887000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Printed Chiffon Dress",
      "offset": 9
    }
  ],
  "location": "CartSteps.productIsDisplayedInCartPage(String)"
});
formatter.result({
  "duration": 26632600,
  "status": "passed"
});
formatter.match({
  "location": "CartSteps.theUserClicksOnTheCheckOutButton()"
});
formatter.result({
  "duration": 2422701600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "mr,Tom,Alter,admin@1234,4,June,1990,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331",
      "offset": 67
    },
    {
      "val": "\u003cMarket\u003e",
      "offset": 186
    }
  ],
  "location": "RegistrationSteps.theUserEnterRegistrationDetailsAs(String,String)"
});
formatter.result({
  "duration": 26517842800,
  "status": "passed"
});
formatter.match({
  "location": "CartSteps.theUserClicksOnTheCheckOutButton()"
});
formatter.result({
  "duration": 1719494100,
  "status": "passed"
});
formatter.match({
  "location": "DeliverySteps.theDeliveryPageIsDisplayedToTheUser()"
});
formatter.result({
  "duration": 22612400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Tom,Alter,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331,Shipping Address",
      "offset": 38
    }
  ],
  "location": "DeliverySteps.theUserEntersTheDeliveryDetails(String)"
});
formatter.result({
  "duration": 16434299000,
  "status": "passed"
});
formatter.match({
  "location": "AddressSteps.the_address_page_is_displayed()"
});
formatter.result({
  "duration": 67635500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Shipping Address",
      "offset": 41
    }
  ],
  "location": "AddressSteps.the_user_choose_the_delivery_address_as_something(String)"
});
formatter.result({
  "duration": 1687221000,
  "status": "passed"
});
formatter.match({
  "location": "CartSteps.theUserClicksOnTheCheckOutButton()"
});
formatter.result({
  "duration": 2208960900,
  "status": "passed"
});
formatter.match({
  "location": "ShippingSteps.the_shipping_page_is_displayed()"
});
formatter.result({
  "duration": 900965100,
  "status": "passed"
});
formatter.match({
  "location": "CartSteps.theUserClicksOnTheCheckOutButton()"
});
formatter.result({
  "duration": 2021012600,
  "status": "passed"
});
formatter.match({
  "location": "PaymentSteps.the_payment_page_is_displayed()"
});
formatter.result({
  "duration": 64701200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Pay by check",
      "offset": 39
    }
  ],
  "location": "PaymentSteps.the_user_choose_the_payment_method(String)"
});
formatter.result({
  "duration": 6857528400,
  "status": "passed"
});
formatter.after({
  "duration": 943942700,
  "status": "passed"
});
formatter.uri("features/PlaceHolder2.feature");
formatter.feature({
  "line": 1,
  "name": "Testing",
  "description": "",
  "id": "testing",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 3,
      "value": "#multiple line and uncomment - ctrl + /"
    },
    {
      "line": 5,
      "value": "#Scenario Outline: Automating Ecommerce Website"
    },
    {
      "line": 6,
      "value": "#\tGiven The guest user Launches the application URL \"\u003cURL\u003e\""
    },
    {
      "line": 7,
      "value": "#\tWhen The user goes on Registration page, enter registration details as \"\u003cRegistrationDetails\u003e\" on \"\u003cMarket\u003e\""
    },
    {
      "line": 8,
      "value": "#\tThen The user verify has registered with application"
    },
    {
      "line": 9,
      "value": "#\tExamples:"
    },
    {
      "line": 10,
      "value": "#\t\t|URL|RegistrationDetails|Market|"
    },
    {
      "line": 11,
      "value": "#\t\t|http://automationpractice.com/index.php|mr,Tom,Alter,admin@1234,4,June,1990,amazon,2345 Crystal Drive,Arlington,Virginia,22202,United States,888-280-4331|global|"
    },
    {
      "line": 13,
      "value": "#Scenario Outline: Place the Order as Guest User"
    },
    {
      "line": 14,
      "value": "#Given The guest user Launches the application URL \"\u003cURL\u003e\""
    },
    {
      "line": 15,
      "value": "#When The user searches for the product \"\u003cProductName\u003e\""
    },
    {
      "line": 16,
      "value": "#Then The Product page for product \"\u003cProductName\u003e\" is displayed"
    },
    {
      "line": 17,
      "value": "#Examples:"
    },
    {
      "line": 18,
      "value": "#|URL|ProductName|"
    },
    {
      "line": 19,
      "value": "#|http://automationpractice.com/index.php|Printed Chiffon Dress|"
    }
  ],
  "line": 21,
  "name": "Browser dresses as Guest User",
  "description": "",
  "id": "testing;browser-dresses-as-guest-user",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "The guest user Launches the application URL \"\u003cURL\u003e\"",
  "keyword": "Given "
});
formatter.examples({
  "comments": [
    {
      "line": 23,
      "value": "#When The guest user hovers above the link \"\u003cLink\u003e\" and clicks the sublinks"
    }
  ],
  "line": 24,
  "name": "",
  "description": "",
  "id": "testing;browser-dresses-as-guest-user;",
  "rows": [
    {
      "cells": [
        "URL",
        "Link"
      ],
      "line": 25,
      "id": "testing;browser-dresses-as-guest-user;;1"
    },
    {
      "cells": [
        "http://automationpractice.com/index.php",
        "dresses"
      ],
      "line": 26,
      "id": "testing;browser-dresses-as-guest-user;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 10183728400,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "Browser dresses as Guest User",
  "description": "",
  "id": "testing;browser-dresses-as-guest-user;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 22,
  "name": "The guest user Launches the application URL \"http://automationpractice.com/index.php\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "http://automationpractice.com/index.php",
      "offset": 45
    }
  ],
  "location": "GivenSteps.theGuestUserLaunchesTheApplication(String)"
});
formatter.result({
  "duration": 6230633500,
  "status": "passed"
});
formatter.after({
  "duration": 404757000,
  "status": "passed"
});
});