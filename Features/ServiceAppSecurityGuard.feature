Feature: Service App Security Guard functionality
  
  In this feature file we are testing all the functionality for Security Guard

@login
  Scenario Outline: Login with Invalid credentails
    Given user on the login screen of the app
    When user enters the valid "<username>"
    And user click on signIn button
    And verify the toast "<message>" at y-axis Start <starty> and <endy>

    Examples: 
      | username         | message                                    | starty | endy |
      | N1234            | The user ID you have entered is incorrect. |     70 |  270 |
      | abcdefghijklmnop | The user ID you have entered is incorrect. |      0 |    0 |
      | abc              | The user ID you have entered is incorrect. |      0 |    0 |
      |                  | Please Enter User ID                       |      0 |    0 |
      | 10723SHAIL       | The user ID you have entered is incorrect. |     70 |  270 |


  #passed 24/10
 @login6  @UAT
  Scenario: Login with valid credentails and RemeberMe check
    Given user on the login screen of the app
    When user enters the valid "LAAL11979"
    And Click on Remeber Me CheckBox
    And user click on signIn button
    And Get the resend text 
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    And Enter the "Valid" OTP
    And Enter the Submit button
    And verify the toast "OTP verified Successfully" at y-axis Start 70 and 270
    And Click on logout button
    And Click on Confirm button
    And Click on Remeber Me CheckBox to ucheck
    Then Verify userID it showing "LAAL11979"
   

 
#: Passed 24/10
  @negativeFlow @UAT
  Scenario: Login with valid credentails and validate customer mobile number with Special characters, Alpahbates, more tha 10 digits
    Given user on the login screen of the app
    When user enters the valid "LAAL11979"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    And Enter the "Valid" OTP
    And Enter the Submit button
    And verify the toast "OTP verified successfully" at y-axis Start 70 and 200
    And verify it navigate to the TokenCreation page
    #Tsc 3.C: Tsc_1, Tsc4.B : Tsc_1
    And user click on Scan button and take picture of registration plate
    #Tsc4.B : Tsc_2
    And verify the toast "Please capture the image again" at y-axis Start 70 and 270
    And Click on No registration number link
    And Enter the customer mobile number as "@#$%%^&*()*&^%"
    And Click on BackBtn
    And Click on No registration number link
    And Enter the customer mobile number as "ABJBJBKBKL"
    And Click on BackBtn
    And Click on No registration number link
    And Enter the customer mobile number as "1234566777128"
    And Click on BackBtn
    And Click on No registration number link
    And Enter the customer mobile number as "917869169109"
    And Click on BackBtn
    Then Click on logout button
    And Click on Confirm button

 #passed  24/10
  @negativeFlow2 @UAT
  Scenario: Login with valid credentails, validate camera cancel button, Scan and Scan again functionality
    Given user on the login screen of the app
    When user enters the valid "LAAL11979"
    And user click on signIn button
    And User reaches to the OTP page
    And Enter the "Valid" OTP
    And Enter the Submit button
    And verify it navigate to the TokenCreation page
    And user click on Scan button, allow permission, Click cancel button and scan it again
    Then verify the toast "Please capture the image again" at y-axis Start 70 and 270
    And user click the scan again and take pic
    And verify the toast "Please capture the image again" at y-axis Start 70 and 270
    And Click on logout button
    And Click on Confirm button

#passed  24/10
  @OnlineBooking @UAT
  Scenario: Login with valid credentails and checking the online page
    Given user on the login screen of the app
    When user enters the valid "SG10015"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    And Enter the "Valid" OTP
    And Enter the Submit button
    And verify the toast "OTP verified successfully" at y-axis Start 70 and 200
    And Click on online booking footer
    And verify Online booking header
    And verify there is no booking message "Currently, there is no booking available for display"
    And Click on Booking logout button
    And Click on Confirm button

#passed  24/10
  @OnlineBooking1 @UAT
  Scenario: Login with valid credentails and checking the online page search box for different enteries
    Given user on the login screen of the app
    When user enters the valid "LAAL11979"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    And Enter the "Valid" OTP
    And Enter the Submit button
    And verify the toast "OTP verified successfully" at y-axis Start 70 and 200
    And Click on online booking footer
    And verify Online booking header
    And verify there is no booking message "Currently, there is no booking available for display"
    And Enter the "Satyapal" and verify it
    And Enter the "SatyapalPassion+" and verify it
    And Enter the "AS15S4616" and verify it
    And Enter the "8687897979" and verify it
    And Click on Booking logout button
    And Click on Confirm button

  #Passed 24/10
  @positiveFlow1 @UAT
  Scenario: Login with valid credentails with Owner mobile number
  For this we need to give everytime a new mobile number for which Ticket is not created
    Given user on the login screen of the app
    When user enters the valid "SG10015"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    And Enter the "Valid" OTP
    And Enter the Submit button
    And verify the toast "OTP verified successfully" at y-axis Start 70 and 200
    And verify it navigate to the TokenCreation page
    #Tsc 3.C: Tsc_1, Tsc4.B : Tsc_1
    And user click on Scan button and take picture of registration plate
    #Tsc4.B : Tsc_2
    And verify the toast "Please capture the image again" at y-axis Start 70 and 270
    And Click on No registration number link
    #7974730233, 6383527599, 6263626463, 9009510876, 7503496897, 9966214058,9649736363,
    And Enter the customer mobile number as "7503496897"
    And Click Next
    Then verify user ticket information
    And Select the ticket and Assign it
    And get the token information and Click ok

 #Passed
  @positiveFlow @UAT
  Scenario: Login with valid credentails and valid Vehicle registration number
  For this we need to give everytime a new registration number for which Ticket is not created
    Given user on the login screen of the app
    When user enters the valid "SG10015"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    And Enter the "Valid" OTP
    And Enter the Submit button
    And verify the toast "OTP verified successfully" at y-axis Start 70 and 200
    Then verify it navigate to the TokenCreation page
    #Tsc 3.C: Tsc_1, Tsc4.B : Tsc_1
    And user click on Scan button and take picture of registration plate
    #Tsc4.B : Tsc_2
    And verify the toast "Please capture the image again" at y-axis Start 70 and 270
    #
    And user enter the bike registration number "AP40D9231" and click Next
    And verify user ticket information
    And Select the ticket and Assign it
    And get the token information and Click ok
 
  #Passed 25/10
   @positiveFlow3 @UAT
  Scenario: Login with valid credentails and validate Todays Token info
  For this we need to give everytime a new registration number for which Ticket is not created
    Given user on the login screen of the app
    When user enters the valid "SG10015"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    And Enter the "Valid" OTP
    And Enter the Submit button
    And verify the toast "OTP verified successfully" at y-axis Start 70 and 200
    Then verify it navigate to the TokenCreation page
    And Get the todays token number
    And Click on Todays Token link and get todays information 
    And Click on todays token logout button
    And Click on Confirm button

  #---------------------------------------------------------------------------------------------------
  #: Functionality Not working as expected.
  @OTP1
  Scenario: Login with valid userid and invalid OTP, making 5 attempts to bolck userID
    Given user on the login screen of the app
    When user enters the valid "LAAL11979"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    And verify submit button is disable
    And Enter the Submit button
    #1
    And Enter the "Invalid" OTP
    And Enter the Submit button
    And verify invalid OTP message
    And verify the toast "Invalid OTP." at y-axis Start 70 and 270
    And verify submit button is disable
    #Tsc_2.G: TSC_1,2
    And Tap on back button
    And user enters the valid "LAAL11979"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    #2
    And Enter the "Invalid" OTP
    And Enter the Submit button
    And verify invalid OTP message
    And verify the toast "Invalid OTP." at y-axis Start 70 and 270
    And verify submit button is disable
    And Tap on back button
    And user enters the valid "LAAL11979"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    #3
    And Enter the "Invalid" OTP
    And Enter the Submit button
    Then verify invalid OTP message
    And verify the toast "Invalid OTP." at y-axis Start 70 and 270
    And verify submit button is disable
    And Tap on back button
    And user enters the valid "LAAL11979"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    #4
    And Enter the "Invalid" OTP
    And Enter the Submit button
    And verify invalid OTP message
    And verify the toast "Invalid OTP." at y-axis Start 70 and 270
    And verify submit button is disable
    And Tap on back button
    And user enters the valid "LAAL11979"
    And user click on signIn button
    And verify the toast "OTP Send Successfully" at y-axis Start 70 and 270
    And User reaches to the OTP page
    #5
    And Enter the "Invalid" OTP
    And Enter the Submit button
    Then verify invalid OTP message
    And verify the toast "Your account has been blocked." at y-axis Start 70 and 270
    And Tap on back button
    And user enters the valid "LAAL11979"
    And verify the toast "Your account has been blocked." at y-axis Start 70 and 270
