namespace lab4z3;

public class Admin : Client
{
    public Admin() : base()
    {
        
    }

    public void BlockCard(int cardNumber)
    {
        var account = Account.GetAccount(cardNumber);
        if (account == null)
        {
            Console.WriteLine("Error: wrong number");
            return;
        }
        
        account.Card.BanStatus = true;
        Console.WriteLine("Success");
    }
}