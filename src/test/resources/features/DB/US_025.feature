Feature:Backend JDBC Testing:

  Background:Database connection
    * Database connection is established.


  Scenario:In the order_payments table, group the data without txn_id='none'
  according to their txn_id, group the data with max_amount values higher than 9000 and sort them according to their max_amount values.

  # order_payments tablosunda txn_id='none' olmayan verileri txn_id'lerine göre max_amount değerleri
  # 9000 den yüksek olan verileri gruplandırıp max_amount degerlerine göre sıralayın

    * Order_payments select query is prepared and executed.
    * Verify that listed expected values
    * Database connection is closed

