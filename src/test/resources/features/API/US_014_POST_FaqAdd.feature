Feature: As an administrator, I want to be able to create a new FAQ record via API connection.

  Scenario: When a POST request containing valid authorization credentials and necessary information
  (title, description) is sent to the /api/faqsAdd endpoint, the expected status code returned should be 201,
  and the message in the response body should confirm: "Faqs added successfully".

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/faqsAdd" path parameters
    * The api user adds a key field "title" with the value "newFaqTitle" to the request body
    * The api user adds a key field "description" with the value "newFaqDescription" to the request body
    * The api user sends the "post" request and saves the "Response"
    * The api user verifies that for "post" request type the status code is 201 and the message information in the response body is "Faqs added successfully"




  Scenario: The creation of the new FAQ record via the API should be verified through the API itself by sending a GET
  request to the /api/faqsDetails endpoint with the added_item_id returned in the response body.

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/faqsDetails" path parameters
    * The api user adds a key field "id" with the value "added_item_id" to the request body
    * The api user sends the "get" request and saves the "Response"
    * The api user verifies that "added_item_id" returned in the response body by sending a GET request to the "faqsDetails" endpoint


#    * The api user adds a key field "added_item_id" with a value "1" to the request body
#    * The api user sends the "get" request and saves the "Response"
#    * The api user verifies the content of the data id in the response body
#    * The api user prepares a GET request containing "added item" <id> to send to the api "faqsDetails" endpoint.
#    * The api user sends the "getbody" request and saves the "response"
#    * The api user validates the "<title>", "<description>" of the response body.
#    Examples:
#      | id |   title   |   description    |
#      | 96 |  FaqTitle |  FaqDescription  |



  Scenario: When a POST request containing invalid authorization credentials and necessary information (title,
  description) is sent to the /api/faqsAdd endpoint, the expected status code returned should be 401, and the message
  in the response body should confirm: "Unauthenticated.".

    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/faqsAdd" path parameters
    * The api user adds a key field "title" with the value "newFaqTitle" to the request body
    * The api user adds a key field "description" with the value "newFaqDescription" to the request body
    * The api user sends the "post" request and saves the "Response"
    * The api user verifies that for "post" request type the status code is 401 and the message information in the response body is "Unauthorized"

#    Examples:
#      |    title    | description |
#      | registerApi |   TestApi   |