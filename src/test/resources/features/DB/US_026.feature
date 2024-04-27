Feature:Backend JDBC Testing:

  Background:Database connection
    * Database connection is established.

  Scenario:Group the data in the transactions table (id, title, amount, payment_method) according to the payment_method information
  and calculate the sum of the amount values and sort the data with a total amount value above 7000 in reverse order according
  to the payment_method information.

  #  transactions tablosunda bulunan verileri (id,title,amount,payment_method) payment_method bilgilerine göre guruplandırıp
  #  amount degerlerinin toplamını hesaplayınız ve toplam amount degeri 7000 'in üstünde olan verileri payment_method bilgilerine göre
  #  tersten sıralayınız.Toplam amount degerlerine göre dogrulayınız.

    * Transactions select query is prepared and executed.
    * Verify that listed expected values in transactions list
    * Database connection is closed
