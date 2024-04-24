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
}