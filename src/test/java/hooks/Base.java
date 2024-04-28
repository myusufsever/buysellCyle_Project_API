package hooks;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import manage.Manage;
import org.json.JSONObject;
import pojos.Pojo;

import java.time.Instant;
import java.util.HashMap;

public class Base {

    public static int id, DeletedId, deletedId, lastItemId, sonuc, numborOfOrdersById, rowCount;
    public static String exceptionMesaj, fullPath, email_class_level, postId, postId2, addedItemId, updatedId;
    public static Response response, response2;
    public JsonPath jsonPath;
    public Pojo requestPojo;
    public Faker faker = new Faker();
    public JSONObject requestBody = new JSONObject();
    public HashMap<String, Object> reqBody = new HashMap<>();
    public Manage manage = new Manage();
    public Instant instant = Instant.now();

}
