package manage;

public class Manage {
    private String verify_the_name_value_of_categories="Select  name from categories Where slug='fashion';";
    private String list_the_unique_id = "SELECT user_id, count(user_id)=1 from u168183796_qabuysell.support_tickets where reference_no like '%-%' or reference_no not like '%-%' group by user_id;";

    public String getList_the_unique_id() {
        return list_the_unique_id;
    }

    public String getVerify_the_name_value_of_categories() {
        return verify_the_name_value_of_categories;

    }

    public String getBank_account_insert_data() {
        return bank_account_insert_data;
    }

    private String bank_account_insert_data="Insert Into bank_accounts (id,bank_name,branch_name,account_name,account_number,opening_balance,description,status) Values(?,?,?,?,?,?,?,?)";
}