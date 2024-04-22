@US_32
Feature: As a user, I want to view the addresses in my profile via the API connection.

  Scenario: When a GET request body containing valid authorization information is sent to the /api/profile/address-list endpoint,
  the returned status code should be 200, and the message information in the response should be verified as "success".

    * The api user constructs the base url with the "customer" token
    * The api user sets "api/profile/address-list" path parameters
    * The api user sends the "get" request and saves the "Response"
    * The api user verifies that for "get" request type the status code is 200 and the message information in the response body is "success"

  Scenario Outline: When a GET request body containing valid authorization information is sent to the /api/profile/address-list endpoint,
  the response body for the address with ID 'x' should be verified to contain the following information:
  customer_id, name, email, phone, address, city, state, country, postal_code, is_shipping_default, is_billing_default, created_at, updated_at.

    * The api user constructs the base url with the "customer" token
    * The api user sets "api/profile/address-list" path parameters
    * The api user sends the "get" request and saves the "Response"
    * The api user validates the <customer_id> "<name>" "<email>" "<phone>" "<address>" "<city>" "<state>" "<country>" "<postal_code>" <is_shipping_default> <is_billing_default> "<created_at>" "<updated_at>" of the response body with index <idIndex>.
    Examples:
      | idIndex | customer_id | name  | email       | phone    | address | city     | state           | country | postal_code | is_shipping_default | is_billing_default | created_at                  | updated_at                  |
      | 2       | 96         | zehra | zehra@zd.zd | 55555555 | Günesli | Istanbul | Istanbul Avrupa | Turkey  | 34212       | 0                   | 0                  | 2024-04-18T22:27:51.000000Z | 2024-04-18T22:27:51.000000Z |


  Scenario:When a GET request body containing invalid authorization information is sent to the /api/profile/address-list endpoint,
  the returned status code should be 401, and the message information in the response should be verified as "Unauthenticated.".

    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/profile/address-list" path parameters
    * The api user verifies that for "get" request type the status code is 401 and the message information in the response body is "Unauthenticated"