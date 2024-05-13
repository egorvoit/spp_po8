namespace lab4z3;

public class CreditCard
{
    public long CardNumber { get; set; }
    public bool BanStatus { get; set; }

    public CreditCard(long cardNumber)
    {
        CardNumber = cardNumber;
        BanStatus = false;
    }
}