namespace lab4z3;

public class Order
{
    public Account SellerAccount { get; set; }
    public decimal Price { get; set; }
    
    public OrderStatus Status { get; set; }

    public Order(Account sellerAccount, decimal price)
    {
        SellerAccount = sellerAccount;
        Price = price;
        Status = OrderStatus.Rejected;
    }
}

public enum OrderStatus
{
    Accepted,
    Rejected
}