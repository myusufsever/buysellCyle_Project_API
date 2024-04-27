Feature:Backend JDBC Testing:

  Background:Database connection
    * Database connection is established.

  Scenario:list data in the transactions table that has a unique description and
  has both 'Stripe' and 'Cash On Delivery' payment methods

  #  transactions tablosunda description'ı benzersiz olan ve hem 'Stripe' hem de
  #  'Cash On Delivery' ödeme yöntemlerine sahip olan verileri listeleyin

    * Transactions select query is prepared and executed.
    * Verify that listed expected values in transactions list
    * Database connection is closed