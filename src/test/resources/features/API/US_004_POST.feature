Feature:As a user, I should be able to edit my user information via API connection.

  Scenario Outline:When a POST request with valid authorization credentials and correct data (old_password, password, password_confirmation) is sent to the /api/change-password endpoint, the expected status code returned should be 200, and the message
  in the response body should confirm: "password change successfully".

    * The api user constructs the base url with the "customer" token
    * The api user sets "api/change-password" path parameters
    * The api user prepares a POST request containing the "<old_password>" "<password>" "<password_confirmation>" information to send to the api holidayAdd endpoint.
    * The api user sends the POST request and saves the response returned from the api holidayAdd endpoint.
    * The api user verifies that the status code is 201
    * The api user verifies that the message information in the response body is "holiday added successfully"

    Examples:
      | old_password | password         | password_confirmation       |
      | 2024 | Bahar Tatili | 01-04-2024 |