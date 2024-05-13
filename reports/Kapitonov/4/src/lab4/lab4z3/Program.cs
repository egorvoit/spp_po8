using lab4z3;

var client = new Client();
client.AccountsNumbers.Add(1);
client.CreditsCardNumbers.Add(1111222233334444);

Account account = new Account(100, new CreditCard(1111222233334444));

Account account2 = new Account(0, new CreditCard(2222333344445555));

client.CreditCardPayment(1111222233334444,2222333344445555, 25);
Console.WriteLine(account.Balance);
Console.WriteLine(account2.Balance);

client.AccountNumberPayment(1,2,25);
Console.WriteLine(account.Balance);
Console.WriteLine(account2.Balance);


Order order = new Order(account2, 10);
client.PayForTheOrder(order, 1111222233334444);
Console.WriteLine(account.Balance);
Console.WriteLine(account2.Balance);
Console.WriteLine(order.Status);

client.BlockMyCard(1111222233334444);
client.CreditCardPayment(1111222233334444,2222333344445555, 25);
Console.WriteLine(account.Balance);
Console.WriteLine(account2.Balance);

client.ResetToZero(1);
Console.WriteLine(account.Balance);
