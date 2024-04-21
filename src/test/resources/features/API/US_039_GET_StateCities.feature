Feature: As an administrator, I want to be able to access the city information
registered in the system with the specified state_id via the API connection.

  @HS
  Scenario Outline: When a GET request body containing valid authorization credentials and the desired state_id
  to access city information is sent to the /api/profile/stateCities endpoint, the returned status code should be
  validated as 200, and the message information in the response body should confirm as "success".

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/profile/stateCities" path parameters
    * The API user sends a GET request and records the response .

    Examples:
      | id |
      | 3669 |

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
  Scenario Outline: When a GET request body containing valid authorization credentials and an incorrect
  (not found in the system) state_id is sent to the /api/profile/stateCities endpoint, the returned status code
  should be validated as 404, and the message information in the response body should confirm as "address not found".

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/profile/stateCities" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed
    * The API user sends a GET request and records the response .
    * The api user verifies that for "getbody" request type the status code is 404 and the message information in the response body is "Unauthorized"


    Examples:
      | id |
      | 369 |


#  @HS
  Scenario Outline: When a GET request body containing invalid authorization credentials and the desired state_id
  to access city information is sent to the /api/profile/stateCities endpoint, the returned status code should be
  validated as 401, and the message information in the response body should confirm as "Unauthenticated.".

    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/profile/stateCities" path parameters

    Examples:
      | id |
      | 2222 |