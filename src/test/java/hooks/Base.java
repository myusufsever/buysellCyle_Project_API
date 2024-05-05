package hooks;

import com.github.javafaker.Faker;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import manage.Manage;
import org.json.JSONObject;
import pojos.Pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Base {

    public static int id, DeletedId, deletedId, lastItemId, sonuc, numborOfOrdersById, rowCount;
    public static String exceptionMesaj, fullPath, email_class_level, postId, postId2, addedItemId, updatedId;
    public static Response response, response2;
    public static List<String> bank_names = new ArrayList<>();
    public static Connection connection;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    public static Faker faker=new Faker();
    public static int[] result;
    public  String query;
    public JsonPath jsonPath;
    public Pojo requestPojo;
    public JSONObject requestBody = new JSONObject();
    public HashMap<String, Object> reqBody = new HashMap<>();
    public Manage manage = new Manage();
    public Instant instant = Instant.now();
}
