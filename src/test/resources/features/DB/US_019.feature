Feature: US_019 Verify that the opening_balance value of the data with bank_name=?
  in the bank_accounts table is not updated with a negative value.

  Background:Database connection
    * Database connection is established.

  @HSDB
  Scenario: In the support_tickets table, list the unique user_ids of the data with and without '-' in reference_no.
    * "Update the opening_balance with a negative value" query is prepared and executed.
#    * Verify that the opening_balance is not updated with a negative value.
    * Database connection is closed
#    * UPDATE "bank_accounts"
#    * SET "opening_balance" = "-1"
#    * WHERE "bank_name" "=" "'Bank Name 1'"
#    * "Update" query is prepared and executed.
#    * SELECT "opening_balance"
#    * FROM "bank_accounts"
#    * WHERE "bank_name" "=" "'Bank Name 1'"
#    * "Select" query is prepared and executed.
#    * Verify that "opening_balance" is positive
#  case "Select":
#  query = manage.getSelect();
#  boolean aaa = getStatement().execute(query);
#  System.out.println(aaa);
#
#  break;