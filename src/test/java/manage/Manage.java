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
    private String list_the_unique_id = "SELECT user_id, count(user_id)=1 from u168183796_qabuysell.support_tickets where reference_no like '%-%' group by user_id;";
    private String list_the_unique_id_not_contains = "SELECT user_id, count(user_id)=1 from u168183796_qabuysell.support_tickets where reference_no NOT like '%-%' group by user_id;";
    private String ps_cities_veri_ekleme = "INSERT INTO cities (name, state_id, status, created_at) VALUES (?, ?, ?, ?);";
    private String bank_account_insert_data="Insert Into bank_accounts (id,bank_name,branch_name,account_name,account_number,opening_balance,description,status) Values(?,?,?,?,?,?,?,?)";
    private String cities_veri_ekleme = "INSERT INTO cities (name, state_id, status, created_at) VALUES (?, ?, ?, ?);";
    private String  refund_reasons_null  ="SELECT * FROM refund_reasons where reason is null;";
    private String  calculate_grand_total_average  ="SELECT AVG(grand_total) AS 'Ortalama grand_total' from u168183796_qabuysell.orders where is_paid=1;";
    private String sum_of_the_total_price ="select SUM(total_price) as sum_total_price from u168183796_qabuysell.carts where created_at <'2024-03-30' and is_buy_now=1;";

    private String verify_seller_products = "SELECT * FROM u168183796_qabuysell.seller_products where discount = 0 limit 3;";

    private String customerCouponStoresAndUsers  = "SELECT users.*, customer_coupon_stores.* FROM customer_coupon_stores LEFT JOIN users ON customer_coupon_stores.id = users.id LIMIT 3;";



 public String getList_the_unique_id_not_contains() {return list_the_unique_id_not_contains;}
    public String getSum_of_the_total_price() {return sum_of_the_total_price;}
    public String getCalculate_grand_total_average() {return calculate_grand_total_average;}
    public String getList_the_unique_id() {return list_the_unique_id;}
    public String getVerify_the_name_value_of_categories() {return verify_the_name_value_of_categories;}
    public String getBank_account_insert_data() { return bank_account_insert_data; }
    public String getps_cities_veri_ekleme() {return ps_cities_veri_ekleme;}
    public String getCities_veri_ekleme() {return cities_veri_ekleme;}
    public String getRefund_reasons_null() {return refund_reasons_null;}

    public String getVerify_seller_products() { return verify_seller_products; }

    public String getCustomerCouponStoresAndUsers() { return customerCouponStoresAndUsers; }






    }

    private String digital_gift_cards_Add_Data_And_Then_Delete_That_Data = "INSERT INTO digital_gift_cards (id,gift_name,descriptionOne,thumbnail_image_one,thumbnail_image_two,created_at) VALUES (143759, 'Lıghting', 'Mcquen', 'http://lorempixel.com/g/640/350/food/', 'http://lorempixel.com/640/480/nature/',  '2024-04-06 19:14:03');";

    public String getDigital_gift_cards_Add_Data_And_Then_Delete_That_Data() {
  return digital_gift_cards_Add_Data_And_Then_Delete_That_Data;
 }


}