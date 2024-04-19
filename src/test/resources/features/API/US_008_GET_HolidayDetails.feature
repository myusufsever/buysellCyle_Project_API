Feature: When a GET request containing valid authorization credentials and the holiday id data
  for the desired detailed information is sent to the /api/holidayDetails endpoint,
  the expected status code returned should be 200, and the message in the response body should confirm: "success".

@HS
  Scenario Outline: When a GET request containing valid authorization credentials and the holiday id data
  for the desired detailed information is sent to the /api/holidayDetails endpoint,
  the expected status code returned should be 200, and the message in the response body should confirm: "success".

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/holidayDetails" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed.
    * The API user sends a GET request and records the response .
    * The api user verifies that the status code is 200
    * The api user verifies that the message information in the response body is "success"

    Examples:
      | id |
      | 2 |

  @HS
  Scenario Outline: When a GET request containing valid authorization credentials and the holiday id data
  for the desired detailed information is sent to the /api/holidayDetails endpoint,
  the data returned in the response body (id, year, name, type, date, created_at, updated_at) should be validated.

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/holidayDetails" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed.
    * The API user sends a GET request and records the response .
    * The api user validates the <id>, <year>, "<name>", <type>, "<date>", "<created_at>", "<updated_at>" of the response body.
    Examples:
      | id | year |              name                          | type |    date    |        created_at           |          updated_at         |
      | 2 | 2023 | 23 Nisan Ulusal Egemenlik ve Çocuk Bayramı |   0  | 2023-04-23 | 2024-03-12T15:32:02.000000Z | 2024-03-12T15:32:02.000000Z |


  @HS
  Scenario Outline: When a GET request containing valid authorization credentials and an incorrect (non-existent in the system)
  holiday id is sent to the /api/holidayDetails endpoint, the expected status code returned should be 404,
  and the message in the response body should confirm: "holiday not found".

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/holidayDetails" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed.
    * The API user records the response , verifying that the status code is '404' and message coupon not found.

    Examples:
      | id |
      | 222222 |


  @HS
  Scenario Outline: When a GET request body containing invalid authorization information and the coupon ID to access details is sent to the /api/coupon/couponDetails endpoint,
  the returned status code should be 401, and the message information should be verified as "Unauthenticated.".

    * The api user constructs the base url with the "invalid" token.
    * The api user sets "api/holidayDetails" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed.
    * The API user records the response , confirming that the status code is '401' and the message is Unauthorized.

    Examples:
      | id |
      | 2 |