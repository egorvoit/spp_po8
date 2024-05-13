namespace lab4z3;

public class Client
{
    public List<long> CreditsCardNumbers { get; set; }
    
    public List<int> AccountsNumbers { get; set; }

    public Client()
    {
        CreditsCardNumbers = new List<long>();
        AccountsNumbers = new List<int>();
    }
    
    public void CreditCardPayment(long myCreditsCardNumber,long creditsCardNumber, decimal amount)
    {
        Account? account = Account.GetAccount(creditsCardNumber);
        if (account == null)
        {
            Console.WriteLine("Error, wrong number");
            return;
        }

        Account? myAccount = Account.GetAccount(myCreditsCardNumber);
        if (!CreditsCardNumbers.Contains(myCreditsCardNumber) || myAccount == null)
        {
            Console.WriteLine("Error, wrong my number");
            return;
        }

        if (myAccount.Card.BanStatus)
        {
            Console.WriteLine("Error: card banned");
            return;
        }
        Payment(myAccount, account, amount);
        
    }

    public void AccountNumberPayment(int myAccountNumber, int accountNumber, decimal amount)
    {
        Account? account = Account.GetAccountByNumber(accountNumber);
        if (account == null)
        {
            Console.WriteLine("Error, wrong number");
            return;
        }

        Account? myAccount = Account.GetAccountByNumber(myAccountNumber);
        if (!AccountsNumbers.Contains(myAccountNumber) || myAccount == null)
        {
            Console.WriteLine("Error, wrong my number");
            return;
        }
        
        Payment(myAccount, account, amount);
    }

    private void Payment(Account myAccount, Account account, decimal amount)
    {
        if (myAccount.Balance < amount)
        {
            Console.WriteLine("Error, not enough money");
            return;
        }
        
        myAccount.Balance -= amount;
        account.Balance += amount;
        Console.WriteLine("Success");
    }

    public void PayForTheOrder(Order order, long myCreditsCardNumber)
    {
        var myAccount = Account.GetAccount(myCreditsCardNumber);
        if ( !CreditsCardNumbers.Contains(myCreditsCardNumber) || myAccount == null)
        {
            Console.WriteLine("Error: wrong number");
            return;
        }

        if (myAccount.Balance < order.Price)
        {
            Console.WriteLine("Error: not enough money");
            return;
        }
        
        if (myAccount.Card.BanStatus)
        {
            Console.WriteLine("Error: card banned");
            return;
        }
        
        myAccount.Balance -= order.Price;
        order.SellerAccount.Balance += order.Price;
        order.Status = OrderStatus.Accepted;
    }
    
    public void BlockMyCard(long myCreditsCardNumber)
    {
        var myAccount = Account.GetAccount(myCreditsCardNumber);
        if (!CreditsCardNumbers.Contains(myCreditsCardNumber)||myAccount == null)
        {
            Console.WriteLine("Error: wrong number");
            return;
        }
        
        myAccount.Card.BanStatus = true;
        Console.WriteLine("Success");
    }



    public void ResetToZero(int myAccountNumber)
    {
        var myAccount = Account.GetAccountByNumber(myAccountNumber);
        if (!AccountsNumbers.Contains(myAccountNumber) || myAccount == null)
        {
            Console.WriteLine("Error: wrong number");
            return;
        }
        
        
        myAccount.Balance = 0;
        Console.WriteLine("Success");
    }

}