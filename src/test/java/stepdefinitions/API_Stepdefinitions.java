package stepdefinitions;

import config_Requirements.ConfigReader;
import hooks.HooksAPI;
import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.API_Utilities.API_Methods;

import java.util.Arrays;

import static hooks.HooksAPI.spec;
import static org.hamcrest.Matchers.equalTo;

public class API_Stepdefinitions {

    public static int id;
    public static String fullPath;
    JSONObject requestBody;
    JsonPath jsonPath;

    @Given("The api user sets {string} path parameters")
    public void the_api_user_sets_path_parameters(String rawPaths) {
        String[] paths = rawPaths.split("/"); // [api, refundReasonList]

        System.out.println(Arrays.toString(paths));

        StringBuilder tempPath = new StringBuilder("/{");


        for (int i = 0; i < paths.length; i++) {

            String key = "pp" + i;
            String value = paths[i].trim();

            spec.pathParam(key, value);

            tempPath.append(key + "}/{");

            if (value.matches("\\d+")) {  // value.matches("\\d+") burada value rakam iceriyorsa dedik
                id = Integer.parseInt(value);
            }
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));

        fullPath = tempPath.toString();
        System.out.println("fullPath = " + fullPath); // /{pp0}/{pp1}
        System.out.println("id : " + id);
    }

    @Given("The api user constructs the base url with the {string} token.")
    public void the_api_user_constructs_the_base_url_with_the_token(String token) {
        HooksAPI.setUpApi(token);
    }

    @Given("The API user sends a GET request and records the response from the api refundReasonList endpoint.")
    public void the_apı_user_sends_a_get_request_and_records_the_response_from_the_api_refund_reason_list_endpoint() {
        API_Methods.getResponse();
    }
    @Given("The API user sends a GET request and records the response .")
    public void the_apı_user_sends_a_get_request_and_records_the_response() {
        API_Methods.getResponse();
    }

    @Given("The api user verifies that the status code is {int}")
    public void the_api_user_verifies_that_the_status_code_is(int code) {
        API_Methods.statusCodeAssert(code);
    }

    @Given("The api user verifies that the message information in the response body is {string}")
    public void the_api_user_verifies_that_the_message_information_in_the_response_body_is(String message) {
        API_Methods.messageAssert(message);
    }

    @Given("The api user validates the {string} of the response body with index {int}.")
    public void the_api_user_validates_the_of_the_response_body_with_index(String reason, int dataIndex) {

        API_Methods.response.then()
                .assertThat()
                .body("refundReason[" + dataIndex + "].reason", equalTo(reason));
    }

    @Given("The API user records the response from the api refundReasonList endpoint, confirming that the status code is '401' and the reason phrase is Unauthorized.")
    public void the_apı_user_records_the_response_from_the_api_refund_reason_list_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_unauthorized() {
        Assert.assertTrue(API_Methods.tryCatchGet().equals(ConfigReader.getProperty("unauthorizedExceptionMessage", "api")));
    }

    @Given("The api user prepares a GET request containing the refund reason {int} for which details are to be accessed, to send to the api refundReasonDetails endpoint.")
    public void the_api_user_prepares_a_get_request_containing_the_refund_reason_for_which_details_are_to_be_accessed_to_send_to_the_api_refund_reason_details_endpoint(int id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }

    @Given("The api user sends a GET request and saves the response returned from the api refundReasonDetails endpoint.")
    public void the_api_user_sends_a_get_request_and_saves_the_response_returned_from_the_api_refund_reason_details_endpoint() {
        API_Methods.getBodyResponse(requestBody.toString());
    }

    @Given("The api user verifies the content of the data {int}, {string}, {string}, {string} in the response body.")
    public void the_api_user_verifies_the_content_of_the_data_in_the_response_body(int id, String reason, String created_at, String updated_at) {
        jsonPath = API_Methods.response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("refundReasonDetails[0].id"));
        Assert.assertEquals(reason, jsonPath.getString("refundReasonDetails[0].reason"));
        Assert.assertEquals(created_at, jsonPath.getString("refundReasonDetails[0].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("refundReasonDetails[0].updated_at"));
    }
    @Given("The API user records the response from the api refundReasonDetails endpoint, verifying that the status code is '404' and the reason phrase is Not Found.")
    public void the_apı_user_records_the_response_from_the_api_refund_reason_details_endpoint_verifying_that_the_status_code_is_and_the_reason_phrase_is_not_found() {
        Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("notFoundExceptionMessage", "api")));
    }
    @Given("The API user records the response from the api refundReasonDetails endpoint, confirming that the status code is '401' and the reason phrase is Unauthorized.")
    public void the_apı_user_records_the_response_from_the_api_refund_reason_details_endpoint_confirming_that_the_status_code_is_and_the_reason_phrase_is_unauthorized() {
        Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("unauthorizedExceptionMessage", "api")));
    }
    // ================================= US_05 GET =============================

    @Given("The API user records the response , confirming that the status code is '401' and the message is Unauthenticated.")
    public void the_apı_user_records_the_response_confirming_that_the_status_code_is_and_the_message_is_Unauthenticated() {
      //  Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("unauthorizedExceptionMessage", "api")));
     API_Methods.statusCodeAssert(401);
     API_Methods.messageAssert("Unauthenticated");
    }
    @Given("The api user validates the {int}, {string}, {string}, {string}, {string} of the response body with index {int}.")
    public void the_api_user_validates_the_of_the_response_body_with_index(int id,String first_name,String username,String email,String name, int dataIndex) {
//The api user validates the <id> "<first_name>" "<username>" "<email>" "<phone>" "<name>"of the response body with index <dataIndex>.
        jsonPath = API_Methods.response.jsonPath();

        Assert.assertEquals(id, jsonPath.getInt("user["+dataIndex+"].id"));
        Assert.assertEquals(first_name, jsonPath.getString("user["+dataIndex+"].first_name"));
        Assert.assertEquals(username, jsonPath.getString("user["+dataIndex+"].username"));
        Assert.assertEquals(email, jsonPath.getString("user["+dataIndex+"].email"));
        Assert.assertNull(jsonPath.get("user["+dataIndex+"].phone"));
        Assert.assertEquals(name, jsonPath.getString("user["+dataIndex+"].name"));
    }




    @Given("The API user records the response , confirming that the status code is '401' and the message is Unauthorized.")
    public void the_apı_user_records_the_response__confirming_that_the_status_code_is_and_the_message_is_unauthorized() {
        Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("unauthorizedExceptionMessage", "api")));
    }

    //========================== US28 GET =========================

    @Given("The api user validates the {int}, {string}, {string}, {int}, {string}, {string}, {int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}, {string}, {string} of the response body .")
    public void the_api_user_validates_the_of_the_response_body(int id, String title, String coupon_code, int coupon_type, String start_date, String end_date, int discount, int discount_type, int minimum_shopping, int maximum_discount, int created_by, int updated_by, int is_expire, int is_multiple_buy, String created_at, String updated_at) {
        jsonPath = API_Methods.response.jsonPath();
// * The api user validates the <id>, "<title>", "<coupon_code>", <coupon_type>, "<start_date>", "<end_date>", <discount>, <discount_type>, <minimum_shopping>, <maximum_discount>, <created_by>, <updated_by>, <is_expire>, <is_multiple_buy>, "<created_at>", "<updated_at>" of the response body .

        Assert.assertEquals(id, jsonPath.getInt("couponDetails[0].id"));
        Assert.assertEquals(title, jsonPath.getString("couponDetails[0].title"));
        Assert.assertEquals(coupon_code, jsonPath.getString("couponDetails[0].coupon_code"));
        Assert.assertEquals(coupon_type, jsonPath.getInt("couponDetails[0].coupon_type"));
        Assert.assertEquals(start_date, jsonPath.getString("couponDetails[0].start_date"));
        Assert.assertEquals(end_date, jsonPath.getString("couponDetails[0].end_date"));
        Assert.assertEquals(discount, jsonPath.getInt("couponDetails[0].discount"));
        Assert.assertEquals(discount_type, jsonPath.getInt("couponDetails[0].discount_type"));
        Assert.assertEquals(minimum_shopping, jsonPath.getInt("couponDetails[0].minimum_shopping"));
        Assert.assertEquals(maximum_discount, jsonPath.getInt("couponDetails[0].maximum_discount"));
        Assert.assertEquals(created_by, jsonPath.getInt("couponDetails[0].created_by"));
        Assert.assertEquals(updated_by, jsonPath.getInt("couponDetails[0].updated_by"));
        Assert.assertEquals(is_expire, jsonPath.getInt("couponDetails[0].is_expire"));
        Assert.assertEquals(is_multiple_buy, jsonPath.getInt("couponDetails[0].is_multiple_buy"));
        Assert.assertEquals(created_at, jsonPath.getString("couponDetails[0].created_at"));
        Assert.assertEquals(updated_at, jsonPath.getString("couponDetails[0].updated_at"));
    }
    @Given("The api user prepares a GET request containing the  {int} for which details are to be accessed.")
    public void the_api_user_prepares_a_get_request_containing_the_for_which_details_are_to_be_accessed(int id) {
        requestBody = new JSONObject();
        requestBody.put("id", id);
    }
    @Given("The API user records the response , verifying that the status code is '404' and message coupon not found.")
    public void the_apı_user_records_the_response_verifying_that_the_status_code_is_and_message_coupon_not_found() {
        Assert.assertTrue(API_Methods.tryCatchGetBody(requestBody.toString()).equals(ConfigReader.getProperty("notFoundExceptionMessage", "api")));

    }
//============================= US_37 GET ==================


    @Given("The api user validates the  confirm that the country with an ID of '223' has the following attributes: code: TR and name: Turkey.")
    public void the_api_user_validates_the_confirm_that_the_country_with_an_ıd_of_has_the_following_attributes_and() {
        jsonPath = API_Methods.response.jsonPath();

       // Assert.assertEquals("TR",jsonPath.getString());
    }


}
