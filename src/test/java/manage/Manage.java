package manage;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import pojos.Pojo;

import java.util.HashMap;

public class Manage {
   //********************************** API Test Variables and Parameters **************************************************************************
                             //************************** From Stepdefinitions Class **************************//
    public static Response response2;
    public static int id;
    public static String fullPath;
    public JSONObject requestBody = new JSONObject();
    public JsonPath jsonPath;
    public HashMap<String, Object> reqBody = new HashMap<>();
    public Pojo requestPojo;
    public Faker faker = new Faker();
    public static String email_class_level;
    public static String postId;
    public static String postId2;
    public static String addedItemId;
    public static String updatedId;
    public static int DeletedId;
    public static int deletedId;
                             //************************** From Stepdefinitions Class **************************//

        //********************************** API Test Variables and Parameters **************************************************************************

    private String verify_the_name_value_of_categories="Select  name from categories Where slug='fashion';";
    private String list_the_unique_id = "SELECT user_id, count(user_id)=1 from u168183796_qabuysell.support_tickets where reference_no like '%-%' or reference_no not like '%-%' group by user_id;";
    private String ps_cities_veri_ekleme = "INSERT INTO cities (name, state_id, status, created_at) VALUES (?, ?, ?, ?);";
    private String bank_account_insert_data="Insert Into bank_accounts (id,bank_name,branch_name,account_name,account_number,opening_balance,description,status) Values(?,?,?,?,?,?,?,?)";
    private String cities_veri_ekleme = "INSERT INTO cities (name, state_id, status, created_at) VALUES (?, ?, ?, ?);";
    private String  refund_reasons_null  ="SELECT * FROM refund_reasons where reason is null;";
    public String getList_the_unique_id() {
        return list_the_unique_id;
    }

    public String getVerify_the_name_value_of_categories() {return verify_the_name_value_of_categories;}
    public String getBank_account_insert_data() { return bank_account_insert_data; }
    public String getps_cities_veri_ekleme() {return ps_cities_veri_ekleme;}
    public String getCities_veri_ekleme() {return cities_veri_ekleme;}
    public String getRefund_reasons_null() {return refund_reasons_null;}

    private String verify_seller_products = "SELECT * FROM u168183796_qabuysell.seller_products where discount = 0 limit 3;";
    public String getVerify_seller_products() { return verify_seller_products; }

    private String customerCouponStoresAndUsers  = "SELECT users.*, customer_coupon_stores.* FROM customer_coupon_stores LEFT JOIN users ON customer_coupon_stores.id = users.id LIMIT 3;";
    public String getCustomerCouponStoresAndUsers() { return customerCouponStoresAndUsers; }





}