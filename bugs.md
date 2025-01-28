# Examples of bug reports

FE: [CartPage] The selected product is not displayed correctly

Environment

MacOS Sonoma 14.6.1

Chrome version 130.0.6723.93

Screen res 13.3"/2560x1600 px.

Description

Instead of the Philadelphia Original product selected in the product category [HomePage], when going to the CART [CartPage] the product Rump Steak is displayed

1. Open React Redux App

2. Click on the authorization logo in the header

3. On the [HomePage] page, in the product category, add the Philadelphia Original product to the cart and go to the CART by clicking on the "Cart Icon"

Expected result: Product Philadelphia Original in CART

Actual result: Product Rump Steak in CART

---

FE: [RegistrationPage] FirstName input accepts JavaScript code

Environment

MacOS Sonoma 14.6.1

Chrome version 130.0.6723.93

Screen res 13.3"/2560x1600 px.

Description

FirstName input accepts numeric characters (value: "alert('XSS');")

Open React Redux App

Click on the authorization logo in the header

Click on the link "register"

Expected result: error

Actual result: success

---
FE: [RegistrationPage] LastName input accepts numeric characters

Environment

MacOS Sonoma 14.6.1

Chrome version 130.0.6723.93

Screen res 13.3"/2560x1600 px.

Description

LastName input accepts numeric characters (value: 123)

Open https://oyster-app-hck73.ondigitalocean.app/#/registration

Click on the authorization logo in the header

Click on the link "register"

Expected result: error

Actual result: success

---

FE: [RegistrationPage] The E-mail field allows an email of less than 8 characters

Environment

MacOS Sonoma 14.6.1

Chrome version 130.0.6723.93

Screen res 13.3"/2560x1600 px.

Description

The E-mail field allows an email of less than 8 characters (value: d@t.de)

Open React Redux App

Click on the authorization logo in the header

Click on the link "register"

Expected result: error

Actual result: success

---

FE: [RegistrationPage] The "Password" field allows spaces as a valid value

Environment

MacOS Sonoma 14.6.1

Chrome version 130.0.6723.93

Screen res 13.3"/2560x1600 px.

Description

The "Password" field allows spaces as a valid value (value: “        “)

Open React Redux App

Click on the authorization logo in the header

Click on the link "register"

Expected result: error

Actual result: success

---

FE: [RegistrationPage] The Phone Number field accepts values without a country code

Environment

MacOS Sonoma 14.6.1

Chrome version 130.0.6723.93

Screen res 13.3"/2560x1600 px.

Description

The Phone Number field accepts values ​​without a country code. (value: 1758971423)

Open React Redux App

Click on the authorization logo in the header

Click on the link "register"

Expected result: error

Actual result: success

---
