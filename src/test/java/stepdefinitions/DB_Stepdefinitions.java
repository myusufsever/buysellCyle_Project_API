package stepdefinitions;

import config_Requirements.ConfigReader;
import helperDB.BankAccount;
import helperDB.Cities;
import io.cucumber.java.en.Given;
import manage.Manage;
import org.junit.Assert;

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
    @Given("List the unique user_ids query is prepared and executed.")
    public void list_the_unique_user_ids_query_is_prepared_and_executed() throws SQLException {
        query = manage.getList_the_unique_id();
        resultSet = getStatement().executeQuery(query);
    }
    @Given("List the unique user_id information results are obtained.")
    public void list_the_unique_user_id_information_results_are_obtained() throws SQLException {
        while(resultSet.next()){
            if (resultSet.getLong("count(user_id)=1")==1) {
                System.out.println(resultSet.getLong("user_id"));
            }
        }
    }
    @Given("Calculate the total cost of products query is prepared and executed.")
    public void calculate_the_total_cost_of_products_query_is_prepared_and_executed() throws SQLException {
        query = manage.getSum_of_the_total_price();
        resultSet = getStatement().executeQuery(query);
    }
    @Given("Verify the total cost value of paid orders in the orders table.")
    public void verify_the_total_cost_value_of_paid_orders_in_the_orders_table() throws SQLException {
        resultSet.next();
        Double expected_sum_total_price = Double.valueOf(9649);
        Double actual_sum_total_price = resultSet.getDouble("sum_total_price");
        Assert.assertEquals(expected_sum_total_price,actual_sum_total_price);
    }
    @Given("Calculate the average grand total query is prepared and executed.")
    public void calculate_the_average_grand_total_query_is_prepared_and_executed() throws SQLException {
        query = manage.getCalculate_grand_total_average();
        resultSet = getStatement().executeQuery(query);
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

//=========================== US_014 ZD ===========================

    @Given("Verify whether there is data Query is prepared and executed.")
    public void verify_whether_there_is_data_query_is_prepared_and_executed() throws SQLException {
        query = manage.getRefund_reasons_null();
        resultSet = getStatement().executeQuery(query);
    }
    @Given("Verify the {string} information result are obtained.")
    public void verify_the_information_result_are_obtained(String reason) throws SQLException {
        resultSet.next();
        reason = resultSet.getString(reason);
        assertNull(reason);

    }


}