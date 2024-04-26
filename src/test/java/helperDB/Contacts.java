package helperDB;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Contacts {

    // US_04 _ contacts tablosunda (id,name,email,query_type,message) bilgileri iceren bir veri ekleyip,
    //         message bilgisini update ediniz.
    static Faker faker = new Faker();
    // INSERT INTO contacts (id, name, email, query_type, message, created_at, updated_at, others) VALUES (?,?,?,?,?,?,?,?)
    private static int id;
    private static String  name;
    private static String email;
    private static String query_type;
    private static String message;
    //created_at - > preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
    //updated_at - > preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
    private static String others;

    public static int getId() {return id;}
    public static String getName() {return name;}
    public static String getEmail() {return email;}
    public static String getQuery_type() {return query_type;}
    public static String getMessage() {return message;}
    public static String getOthers() {return others;}

    public Contacts(int id, String name, String email, String query_type, String message, String others) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.query_type = query_type;
        this.message = message;
        this.others = others;
    }
    public static List<Contacts> contactsInfo (int count){
        List<Contacts> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Contacts contactIcerik = new Contacts(
                    (int) faker.number().numberBetween(70,100),
                    faker.name().firstName(),
                    faker.internet().emailAddress(),
                    faker.lorem().word(),
                    faker.lorem().word(),
                    faker.lordOfTheRings().character());
            contacts.add(contactIcerik);
        }
        return contacts;
    }
}
