package manage;

public class Manage {
    private String verify_the_name_value_of_categories="Select  name from categories Where slug='fashion';";
    public String getVerify_the_name_value_of_categories() {return verify_the_name_value_of_categories; }

    public String getBank_account_insert_data() { return bank_account_insert_data; }
    private String bank_account_insert_data="Insert Into bank_accounts (id,bank_name,branch_name,account_name,account_number,opening_balance,description,status) Values(?,?,?,?,?,?,?,?)";

    private String cities_veri_ekleme = "INSERT INTO cities (name, state_id, status, created_at) VALUES (?, ?, ?, ?);";
    public String getCities_veri_ekleme() {return cities_veri_ekleme;}

    private String  refund_reasons_null  ="SELECT * FROM refund_reasons where reason is null;";
    public String getRefund_reasons_null() {return refund_reasons_null;}

    private String verify_seller_products = "SELECT * FROM u168183796_qabuysell.seller_products where discount = 0 limit 3;";
    public String getVerify_seller_products() { return verify_seller_products; }

    private String customerCouponStoresAndUsers  = "SELECT users.*, customer_coupon_stores.* FROM customer_coupon_stores LEFT JOIN users ON customer_coupon_stores.id = users.id LIMIT 3;";
    public String getCustomerCouponStoresAndUsers() { return customerCouponStoresAndUsers; }





}