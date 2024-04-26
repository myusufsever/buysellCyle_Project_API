package stepdefinitions;

import config_Requirements.ConfigReader;
import helperDB.BankAccount;
import helperDB.Cities;
import io.cucumber.java.en.Given;
import manage.Manage;
import org.junit.Assert;
import utilities.DB_Utilities.DBUtils;

import java.sql.Array;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helperDB.BankAccount.generateBankAccount;
import static helperDB.Cities.generateCities;
import static helperDB.JDBC_Cons.*;
import static helperDB.JDBC_Structure_Methods.*;
import static helperDB.JDBC_Structure_Methods.getPraperedStatement;
import static org.junit.Assert.*;


public class DB_Stepdefinitions {

    Manage manage = new Manage();
    //prepared statement timestamp instant döndürür.
    Instant instant = Instant.now();
    int sonuc;

    @Given("Database connection is established.")
    public void database_connection_is_established() {
        createConnection();
    }

    @Given("Verify the name value of a categorie Query is prepared and executed.")
    public void verify_the_name_value_of_a_categorie_query_is_prepared_and_executed() throws SQLException {
        query = manage.getVerify_the_name_value_of_categories();
        resultSet = getStatement().executeQuery(query);
    }

    @Given("Verify the {string} information Results are obtained.")
    public void verify_the_information_results_are_obtained(String categoryName) throws SQLException {
        resultSet.next();
        categoryName = resultSet.getString(categoryName);
        String expectedName = ConfigReader.getProperty("categoryName", "db");
        assertEquals(categoryName, expectedName);

    }

    @Given("Database connection is closed")
    public void database_connection_is_closed() {
        closeConnection();
    }

    @Given("Prepare a query that adds {int} data to the bank_accounts table in bulk.")
    public void prepare_a_query_that_adds_data_to_the_bank_accounts_table_in_bulk(Integer count) throws SQLException {
        query = manage.getBank_account_insert_data();
        preparedStatement = getPraperedStatement(query);
        List<BankAccount> accounts = generateBankAccount(count);
        int flag = 0;
        for (BankAccount bankAccount : accounts) {
            preparedStatement.setInt(1, accounts.get(flag).getBank_account_id());
            preparedStatement.setString(2, accounts.get(flag).getBank_name());
            preparedStatement.setString(3, accounts.get(flag).getBranch_name());
            preparedStatement.setString(4, accounts.get(flag).getAccount_name());
            preparedStatement.setString(5, accounts.get(flag).getAccount_number());
            preparedStatement.setDouble(6, accounts.get(flag).getOpening_balance());
            preparedStatement.setString(7, accounts.get(flag).getDescription());
            preparedStatement.setInt(8, accounts.get(flag).getStatus());
            preparedStatement.addBatch();
            flag++;
            if (flag == accounts.size()) {
                result = preparedStatement.executeBatch();
            }
        }
    }

    @Given("{int} Enter the data in bulk. Check that it is added to the table.")
    public void enter_the_data_in_bulk_check_that_it_is_added_to_the_table(int rowCount) {

        System.out.println("Inserted " + result.length + " records successfully.");
        System.out.println(Arrays.toString(result));
        assertEquals(rowCount, result.length);
    }
    /**
     * US018
     /**  addBatch() yöntemi ile her hazırlanan sorgu bu sorgu yığınına eklenir.
     *  Ardından executeBatch() yöntemi kullanılarak tüm sorguları çalıştırılır.
     */

    /** executeBatch() yöntemi, her sorgunun etkilenen satır sayısını içeren bir int dizisi döndürür.*/
    //-------------------------simge-------------------------------------------

    @Given("List the unique user_id information results are obtained.")
    public void list_the_unique_user_id_information_results_are_obtained() throws SQLException {
        while(resultSet.next()){
            if (resultSet.getLong("count(user_id)=1")==1) {
                System.out.println(resultSet.getLong("user_id"));
            }
        }
    }

    @Given("Verify the total cost value of paid orders in the orders table.")
    public void verify_the_total_cost_value_of_paid_orders_in_the_orders_table() throws SQLException {
        resultSet.next();
        Double expected_sum_total_price = Double.valueOf(9649);
        Double actual_sum_total_price = resultSet.getDouble("sum_total_price");
        Assert.assertEquals(expected_sum_total_price,actual_sum_total_price);
    }

    @Given("Verify the average grand_total value of paid orders \\(is_paid ={int}) in the orders table.")
    public void verify_the_average_grand_total_value_of_paid_orders_is_paid_in_the_orders_table(int is_paid) throws SQLException {
     resultSet.next();
     Double expected_avg_grand_total = 176420.36284403672;
     Double actual_avg_grand_total = resultSet.getDouble("Ortalama grand_total");
     assertEquals(expected_avg_grand_total,actual_avg_grand_total);
    }



//----------------------------simge_bitis------------------------------------------


    @Given("Prepare a query that adds {int} data to the cities table in bulk.")
    public void prepare_a_query_that_adds_data_to_the_cities_table_in_bulk(Integer count) throws SQLException {
        query = manage.getCities_veri_ekleme();
        preparedStatement = getPraperedStatement(query);
        List<Cities> city = generateCities(count);
        int flag = 0;
        for (Cities cities : city) {
            preparedStatement.setString(1, city.get(flag).getName());
            preparedStatement.setInt(2, city.get(flag).getState_id());
            preparedStatement.setInt(3, city.get(flag).getStatus());
            preparedStatement.setString(4, city.get(flag).getCreated_at());

            preparedStatement.addBatch();
            flag++;
            if (flag == city.size()) {
                result = preparedStatement.executeBatch();
            }

        }

    }




    @Given("cities tablosu uzerinden {int} adet verinin eklendigini dogrulayiniz.")
    public void cities_tablosu_uzerinden_adet_verinin_eklendigini_dogrulayiniz(int rowCount) {

        System.out.println("Inserted " + result.length + " records successfully.");
        System.out.println(Arrays.toString(result));
        assertEquals(rowCount, result.length);

    }
    //=================== US_15 ZD ============================

    @Given("List the first {int} data in the customer_coupon_stores table by bringing them from the users table.")
    public void list_the_first_data_in_the_customer_coupon_stores_table_by_bringing_them_from_the_users_table(int list) throws SQLException {
        // Beklenen sonuçları tutacak bir liste oluşturma
        List<String> expectedResults = new ArrayList<>();
        System.out.println("| id       | first_name | last_name | Username |role_id     | Email                 |\n"
                +           "|----------|------------|-----------|----------|------------|-----------------------|\n");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String username = resultSet.getString("username");
            int role_id = resultSet.getInt("role_id");
            String email = resultSet.getString("email");

            // Elde edilen sonucu bir string olarak oluşturma ve listeye ekleme
            expectedResults.add("| " + id + " | " + first_name + " | " + last_name + " | " + username + " | " + role_id + " | " + email + " |");
            // Kullanıcı bilgilerini yazdırma
        }
            for (String expectedResult : expectedResults) {
                System.out.println(expectedResult);
            }

    }

//=========================== US_014 ZD ===========================

    @Given("Verify whether there is data Query is prepared and executed.")
    public void verify_whether_there_is_data_query_is_prepared_and_executed() throws SQLException {
        //query = manage.getRefund_reasons_null();
        resultSet = getStatement().executeQuery(query);
    }


    @Given("Verify the {string} information result are obtained.")
    public void verify_the_information_result_are_obtained(String reason) throws SQLException {
        resultSet.next();
        reason = resultSet.getString(reason);
        assertNull(reason);

    }
//========================== US_013 ZD ============================

    @Given("List and verify {int} items without coupons.")
    public void list_and_verify_items_without_coupons(int list) throws SQLException {
        // Beklenen sonuçları tutacak bir liste oluşturma
        List<String> expectedResults = new ArrayList<>();
        expectedResults.add("1166, 1, 1268, 50, 1, 1");
        expectedResults.add("1167, 1, 1269, 50, 1, 1");
        expectedResults.add("1168, 1, 1270, 50, 1, 1");
        int index = 0;
        while (resultSet.next()) {
            // İlgili sütunlardan veriyi al
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt("user_id");
            int productId = resultSet.getInt("product_id");
            int tax = resultSet.getInt("tax");
            String taxType = resultSet.getString("tax_type");
            String discountType = resultSet.getString("discount_type");
            // Elde edilen sonucu bir string olarak oluşturma
            String result = id + ", " +userId+", " + productId + ", " + tax + ", " + taxType+", " +discountType;

            // Beklenen sonuçlarla elde edilen sonuçları karşılaştırma
            Assert.assertEquals(expectedResults.get(index), result);

            // Veriyi kullanma
            System.out.println("id: "+id +", user id: "+userId+",Product ID: " + productId + ", tax: " + tax+", tax_type: "+ taxType+", discount_type: "+ discountType);

            index++;
        }
    }




    @Given("{string} query is prepared and executed.")
    public void query_is_prepared_and_executed(String queryName) throws SQLException {
        switch (queryName)
        {
            case "Update the opening_balance with a negative value" :
                query = manage.getVerify_opening_balance_updated_with_negative_value();
                sonuc=getStatement().executeUpdate(query);
                statement=getStatement();
                break;
            case "List_the_unique_ID_notContains":
                query = manage.getList_the_unique_id_not_contains();
                resultSet = getStatement().executeQuery(query);
                break;
            case "List_the_unique_ID_contains":
                query = manage.getList_the_unique_id();
                resultSet = getStatement().executeQuery(query);
                break;
            case "coupon_products_group_by":
                query = manage.getCouponProductsGroup();
                resultSet = getStatement().executeQuery(query);
                break;
            case "Refund_reasons_null":
                query = manage.getRefund_reasons_null();
                resultSet = getStatement().executeQuery(query);
                break;
            case "Verify_seller_products":
                query = manage.getVerify_seller_products();
                resultSet = getStatement().executeQuery(query);
                break;
            case "CustomerCouponStoresAndUsers":
                query = manage.getCustomerCouponStoresAndUsers();
                resultSet = getStatement().executeQuery(query);
                break;
            case "Update":
                manage.setUpdate(updateTable + setField + whereCondition+";");
                query = manage.getUpdate();
                sonuc = getStatement().executeUpdate(query);
                System.out.println("sonuç: "+sonuc);
                break;
            case "Calculate_the_total_cost": query = manage.getSum_of_the_total_price(); break;
            case "Calculate_the_average_grand_total": query=manage.getCalculate_grand_total_average();break;


        }


    }

    // ================================BEYTULLAH========================================
    @Given("Verify order_address_details Query is prepared and executed.")
    public void verify_order_address_details_query_is_prepared_and_executed() throws SQLException {
        query = manage.getList_ids_with_shipping_address();
        resultSet = getStatement().executeQuery(query);
        resultSet.next();

    }
    @Given("Verify the id information results are listed with shipping_address using order_address_details table")
    public void verify_the_id_information_results_are_listed_with_shipping_address_using_order_address_details_table() throws SQLException {


        int[] expectedIds = {2, 188, 189, 556};
        int[] actualIds = new int[4];

        for (int i = 0; i < 4; i++) {
            actualIds[i] = resultSet.getInt("id");
            resultSet.next();
            System.out.println("actualIds"+i+" = " + actualIds[i]);
        }

        Assert.assertArrayEquals(expectedIds, actualIds);
    }
    @Given("Verify delete Query from cities table is prepared and executed.")
    public void verify_delete_query_from_cities_table_is_prepared_and_executed() throws SQLException {
        query = manage.getDelete_the_data_in_the_cities_table();

        preparedStatement= DBUtils.getPraperedStatement(query);
        preparedStatement.executeUpdate();

    }
    @Given("Verify that it has been deleted.")
    public void verify_that_it_has_been_deleted() throws SQLException {





/*
        SQLWarning warning = statement.getWarnings();
        if (warning != null) {
            System.out.println("SQL Warning:");
            while (warning != null) {
                System.out.println("Message: " + warning.getMessage());
                warning = warning.getNextWarning();
            }
        } else {
            System.out.println("No SQL warnings.");
        }

 */
    }
    @Given("Verify users with attendances users Query is prepared and executed.")
    public void verify_users_with_attendances_users_query_is_prepared_and_executed() throws SQLException {
        query=manage.getEmail_address_from_the_attendances();
        resultSet = getStatement().executeQuery(query);
        resultSet.next();
    }
    @Given("Verify the email address from the information of the data in the users with attendances table.")
    public void verify_the_email_address_from_the_information_of_the_data_in_the_users_with_attendances_table() throws SQLException {

        String expectedEmail="ra_email@gmail.com";
        String actualEmail=resultSet.getString("0");
        System.out.println("actualEmail = " + actualEmail);
        Assert.assertEquals(expectedEmail,actualEmail);

    }



    // ================================BEYTULLAH========================================



    //===================================US_06 ZD =========================

    @Given("List how many products there are for each coupon, grouped by coupon_id")
    public void list_how_many_products_there_are_for_each_coupon_grouped_by_coupon_id() throws SQLException {
        while (resultSet.next()) {
            int couponId = resultSet.getInt("coupon_id");
            int productCount = resultSet.getInt("product_count");

            // Sonuçları yazdırma
            System.out.println("Coupon ID: " + couponId + ", Product Count: " + productCount);
        }
    }
    public static String updateTable;
    public static String setField;
    public static String whereCondition;
    public static String selectField;
    public static String fromTable;
    @Given("UPDATE {string}")
    public void updateTable(String table) {
        updateTable = "UPDATE "+ table +" ";
    }

    @Given("SET {string} = {string}")
    public void setField(String field, String value) {
        setField = "SET "+ field +" = "+value +" ";
    }

    @Given("WHERE {string} {string} {string}")
    public void whereCondition(String field, String condition, String value) {
        whereCondition = "WHERE "+ field+condition+value +" ";
    }
    @Given("SELECT {string}")
    public void select(String field) {
        selectField = "SELECT "+ field+" ";
    }

    @Given("FROM {string}")
    public void from(String table) {
        fromTable = "FROM "+ table+" ";
    }
    @Given("Verify that {string} is positive")
    public void verify(String field) throws SQLException {
        resultSet.next();
        int opening_balance = resultSet.getInt(field);
        assertTrue(opening_balance >= 0);

    }


    @Given("Verify the shipping_address and billing_address are not the same in the order_address_ Query is prepared and executed.")
    public void verify_the_shipping_address_and_billing_address_are_not_the_same_in_the_order_address_query_is_prepared_and_executed() throws SQLException {
        query = manage.getShipping_address();
        resultSet = getStatement().executeQuery(query);



    }

    @Given("Verify the number of users whose shipping_address and billing_address count equals {int}.")
    public void verify_the_number_of_users_whose_shipping_address_and_billing_address_count_equals(int user_count) throws SQLException {

        resultSet.next();
        user_count = resultSet.getInt("user_count");
        System.out.println(user_count);
        int expectedsayi=2;
        assertEquals(expectedsayi,user_count);

    }

    @Given("Verify Calculate the sum of the amount values of the data with type=Referral and id between ten and twenty in the wallet_balances table")
    public void verify_calculate_the_sum_of_the_amount_values_of_the_data_with_type_and_between_ten_and_twenty_in_the_wallet_balances_table() throws SQLException {

        query = manage.getWallet_balances();
        resultSet = getStatement().executeQuery(query);


    }

    @Given("Verify Calculate the sum of the amount values of the data with type=Referral and id between ten and twenty in the wallet_balances table {int}")
    public void verify_calculate_the_sum_of_the_amount_values_of_the_data_with_type_and_between_ten_and_twenty_in_the_wallet_balances_table(int total_amount) throws SQLException {

        resultSet.next();

        total_amount= resultSet.getInt("total_amount");
        double expectedsayi=10.0;
        double delta = 0.1;
        assertEquals(expectedsayi,(double)(total_amount),delta);

    }

    @Given("List the unique notes in the attendances table, separated by days.")
    public void list_the_unique_notes_in_the_attendances_table_separated_by_days() throws SQLException {
        query = manage.getAttendances();
        resultSet = getStatement().executeQuery(query);

    }
    @Given("Verify list the unique {int} in the attendances table, separated by days.")
    public void verify_list_the_unique_in_the_attendances_table_separated_by_days(int row) throws SQLException {


        //--------------------
        resultSet.next();

        row = resultSet.getRow();
        int expectedrow=1;


        assertEquals(row, expectedrow);


    }

}







