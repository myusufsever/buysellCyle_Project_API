Feature: As a user/administrator, I should be able to create a new customer record in the system via API connection.
  @simge
  Scenario Outline: When a POST body consisting of valid data (first_name,last_name, email, password, password_confirmation, user_type, referral_code)
  is sent to the /api/register endpoint, the expected status code returned should be 201, and the response message should confirm: "Successfully registered".

    * The api user constructs the base url with the "customer" token
    * The api user sets "api/register" path parameters
    * The api user prepares a POST request containing the "<first_name>", "<last_name>", "<password>", "<password_confirmation>", "<user_type>", "<referral_code>" information to send to the api register endpoint.
    * The api user sends the "post" request and saves the "Response"
    * The api user verifies that for "post" request type the status code is 201 and the message information in the response body is "Successfully registered"

    Examples:
      | first_name  | last_name| password  | password_confirmation| user_type | referral_code |
      | registerApi | TestApi  | 123123123 | 123123123            | customer  | 0101010101    |
@simge2
  Scenario Outline: The creation of a customer via API should be verified to confirm whether the customer exists in the customer list using API connection.
  (The existence of a customer record can be confirmed by comparing the id returned in the response body of the /api/register endpoint with the customer records
  returned in the response body of the /api/get-users endpoint.)


    * The api user constructs the base url with the "admin" token
    * The api user sets "api/get-user" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed
    * The api user sends the "getbody" request and saves the "Response"
    * The api user verifies the content of the data <id> in the response body
 Examples:
  |id |
  |366|




