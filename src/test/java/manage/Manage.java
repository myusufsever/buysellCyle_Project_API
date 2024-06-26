package manage;

import lombok.Getter;

@Getter
public class Manage {

    private String verify_opening_balance_updated_with_negative_value = "UPDATE bank_accounts SET opening_balance = -1000000000 where bank_name= 'banka1';";
    private String verify_the_name_value_of_categories="Select  name from categories Where slug='fashion';";
    private String list_the_unique_id = "SELECT user_id, count(user_id)=1 from u168183796_qabuysell.support_tickets where reference_no like '%-%' group by user_id;";
    private String list_the_unique_id_not_contains = "SELECT user_id, count(user_id)=1 from u168183796_qabuysell.support_tickets where reference_no NOT like '%-%' group by user_id;";
    private String ps_cities_veri_ekleme = "INSERT INTO cities (name, state_id, status, created_at) VALUES (?, ?, ?, ?);";
    private String bank_account_insert_data="Insert Into bank_accounts (id,bank_name,branch_name,account_name,account_number,opening_balance,description,status) Values(?,?,?,?,?,?,?,?)";
    private String cities_veri_ekleme = "INSERT INTO cities (name, state_id, status, created_at) VALUES (?, ?, ?, ?);";
    private String refund_reasons_null  ="SELECT * FROM refund_reasons where reason is null;";
    private String calculate_grand_total_average  ="SELECT AVG(grand_total) AS 'Ortalama grand_total' from u168183796_qabuysell.orders where is_paid=1;";
    private String sum_of_the_total_price ="select SUM(total_price) as sum_total_price from u168183796_qabuysell.carts where created_at <'2024-03-30' and is_buy_now=1;";
    private String verify_seller_products = "SELECT * FROM u168183796_qabuysell.seller_products where discount = 0 limit 3;";
    private String customerCouponStoresAndUsers  = "SELECT users.*, customer_coupon_stores.* FROM customer_coupon_stores LEFT JOIN users ON customer_coupon_stores.id = users.id LIMIT 3;";
    private String list_ids_with_shipping_address = "select id from order_address_details where shipping_address='Switzerland';";
    private String email_address_from_the_attendances = "select email from users where id IN (select id from attendances where year<2022 and id=5);";
    private String insert_Into_cities = "INSERT INTO cities (name,state_id,status,created_at) VALUES(?, ?, ?, ?);";
    private String delete_the_data_in_the_cities_table = "DELETE from u168183796_qabuysell.cities WHERE state_id=?;";
    private String couponProductsGroup ="SELECT coupon_id, COUNT(*) AS product_count FROM coupon_products GROUP BY coupon_id;";
    private String shipping_address="SELECT COUNT(*) AS user_count FROM order_address_details WHERE shipping_address <> billing_address;";
    private String email_template_types_Grouping = "SELECT module, COUNT(*) AS type_count" + "FROM email_template_types" + "WHERE module IS NOT NULL" + "GROUP BY module;";
    private String order_payments_select_query = "select amount from u168183796_qabuysell.order_payments where txn_id!='none' and amount>9000 GROUP BY amount;";
    private String transactionsSelect = "SELECT * FROM transactions t1 WHERE title IN (SELECT title FROM transactions t2 WHERE t2.payment_method = 'Stripe') AND title IN (SELECT title FROM transactions t3 WHERE t3.payment_method = 'Cash On Delivery');";
    private String contactsInsertInto = "INSERT INTO contacts (id, name, email, query_type, message, created_at, updated_at, others) VALUES (?,?,?,?,?,?,?,?)";
    private String contactsMessageUpdate = "UPDATE contacts SET message = ? WHERE id = ?;";
    private String  wallet_balances="SELECT SUM(amount) AS total_amount FROM wallet_balances WHERE type = 'Referral' AND id BETWEEN 10 AND 20;";
    private String attendances="Select DISTINCT note from attendances group by day";
    private String numberOfOrdersByOrderId = "SELECT count(order_id) AS number_of_orders FROM guest_order_details;";
    private String UpdateShippingName = "UPDATE guest_order_details SET shipping_name = 'Updated Name' WHERE order_id = 2;";
    private String addNewDeviceTokens = "INSERT INTO device_tokens (id, user_id, device_token) VALUES (?, ?, ?);";
    private String customerAddress = "SELECT phone, address FROM customer_addresses WHERE phone LIKE '%5%' LIMIT 3;";
    private String logActivity = "SELECT COUNT(subject) AS subject_count FROM log_activity WHERE ip = '46.2.239.35' AND method = 'Delete';";
    private String deliveryProcesses = "SELECT name FROM delivery_processes ORDER BY name DESC LIMIT 5;";
  
}

