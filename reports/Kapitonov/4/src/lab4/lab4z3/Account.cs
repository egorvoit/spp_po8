using System.Runtime.InteropServices.JavaScript;

namespace lab4z3;

public class Account
{
    public static List<Account> AllAccounts { get; set; } = new List<Account>();
    public int Number { get; set; }
    public decimal Balance { get; set; }
    public CreditCard Card { get; set; }
    

    public Account(decimal balance, CreditCard card)
    {
        Number = AllAccounts.Count + 1;
        Balance = balance;
        Card = card;
        AllAccounts.Add(this);
    }

    public static Account? GetAccount(long number)
    {
        return AllAccounts.Find(x => x.Card.CardNumber == number);
    }
    
    public static Account? GetAccountByNumber(int number)
    {
        return AllAccounts.Find(x => x.Number == number);
    }
    
}