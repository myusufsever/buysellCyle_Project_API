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
    public static String DeletedId;
    public static int deletedId;

 //************************** From API_Methods Class **************************//


    //********************************** API Test Variables and Parameters **************************************************************************

    private String verify_the_name_value_of_categories="Select  name from categories Where slug='fashion';";

    public String getVerify_the_name_value_of_categories() {
        return verify_the_name_value_of_categories;

    }

    public String getBank_account_insert_data() {
        return bank_account_insert_data;
    }

    private String bank_account_insert_data="Insert Into bank_accounts (id,bank_name,branch_name,account_name,account_number,opening_balance,description,status) Values(?,?,?,?,?,?,?,?)";



    private String cities_veri_ekleme = "INSERT INTO cities (name, state_id, status, created_at) VALUES (?, ?, ?, ?);";

    public String getCities_veri_ekleme() {
        return cities_veri_ekleme;


    }

    private String digital_gift_cards_Add_Data_And_Then_Delete_That_Data = "INSERT INTO digital_gift_cards (id,gift_name,descriptionOne,thumbnail_image_one,thumbnail_image_two,created_at) VALUES (143759, 'Lıghting', 'Mcquen', 'http://lorempixel.com/g/640/350/food/', 'http://lorempixel.com/640/480/nature/',  '2024-04-06 19:14:03');";

    public String getDigital_gift_cards_Add_Data_And_Then_Delete_That_Data() {
  return digital_gift_cards_Add_Data_And_Then_Delete_That_Data;
 }
}