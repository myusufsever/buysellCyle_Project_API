Feature: As an administrator, I want to be able to access the city information
registered in the system with the specified state_id via the API connection.

  @HS
  Scenario Outline: When a GET request body containing valid authorization credentials and the desired state_id
  to access city information is sent to the /api/profile/stateCities endpoint, the returned status code should be
  validated as 200, and the message information in the response body should confirm as "success".

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/profile/stateCities" path parameters
    * The api user prepares a GET request containing the <id> for which details are to be accessed.
    * The api user verifies that the status code is 200 and the message information in the response body is "success".

    Examples:
      | id |
      | 223 |

  @HS
  Scenario Outline: point, the data returned in the response body (id, year, name, type, date, created_at, updated_at) should be validated.

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/profile/stateCities" path parameters
    * The api user sends the "get" request and saves the "Response"
    * The api user verifies the content of the data "<first_name>", "<last_name>", "<email>" in the response body

    Examples:

      |id  | first_name               |last_name  |     email                           |
      |96  |Muhammed Yusuf SEVER     |  null      | customer.muhammed@buysellcycle.com  |


  @HS
  Scenario Outline: When a GET request containing valid authorization credentials and an incorrect (non-existent in the system)
  holiday id is sent to the /api/holidayDetails endpoint, the expected status code returned should be 404,
  and the message in the response body should confirm: "holiday not found".

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/holidayDetails" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed
    * The API user records the response , verifying that the status code is '404' and message coupon not found.

    Examples:
      | id |
      | 222222 |


  @HS
  Scenario Outline: When a GET request body containing invalid authorization information and the coupon ID to access details is sent to the /api/coupon/couponDetails endpoint, the returned status code should be 401, and the message information should be verified as "Unauthenticated.".

    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/holidayDetails" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed
    * The API user records the response , confirming that the status code is '401' and the message is Unauthorized.

    Examples:
      | id |
      | 2 |