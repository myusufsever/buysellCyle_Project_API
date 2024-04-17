Feature:When a GET request containing valid authorization credentials and the customer id data for the desired detailed information is sent to the /api/get-user endpoint, the expected status code returned should be 200, and the message in the response body should confirm: "success".




  @[US_006-TC_001]
  Scenario Outline:When a GET request containing valid authorization credentials and the customer id data for the desired detailed information is sent to the /api/get-user endpoint, the expected status code returned should be 200, and the message in the response body should confirm: "success".

    * The api user constructs the base url with the "admin" token.

    * The api user sets "api/get-user" path parameters

    * The api user prepares a GET request containing the  <id> for which details are to be accessed.


    * The API user sends a GET request and records the response .

    * The api user verifies that the status code is 200

    * The api user verifies that the message information in the response body is "success"





    Examples:
      | id |
      | 1 |

  @[US_006-TC_002]

Scenario Outline: When a GET request body containing valid authorization information and the coupon ID to access details is sent to the /api/coupon/couponDetails endpoint,
the data (id, title ,coupon_code, coupon_type, start_date, end_date, discount, discount_type, minimum_shopping, maximum_discount, created_by, updated_by, is_expire, is_multiple_buy, multiple_buy_limit, created_at, updated_at ) returned in the response body should be validated.


  * The api user constructs the base url with the "admin" token.

  * The api user sets "api/coupon/couponDetails" path parameters

  * The api user prepares a GET request containing the  <id> for which details are to be accessed.

  * The API user sends a GET request and records the response .

  * The api user validates the <id>, "<title>", "<coupon_code>", <coupon_type>, "<start_date>", "<end_date>", <discount>, <discount_type>, <minimum_shopping>, <maximum_discount>, <created_by>, <updated_by>, <is_expire>, <is_multiple_buy>, "<created_at>", "<updated_at>" of the response body .
  Examples:
    | id | first_name   | last_name   | role_id     | email      | is_verified   |  is_active | lang_code | currency_id | currency_code |  name |
    | 1 | Orderder     | ordered     | 2           | 2024-04-18 | 2024-04-20    | 10         | 0         | 1           |               |       |




