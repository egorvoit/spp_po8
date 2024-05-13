namespace lab3z2;

public class Bus
{
    public Bus(string name, int busNumber, int routeNumber, string brand, int year, int mileage, BusStatus status)
    {
        Name = name;
        BusNumber = busNumber;
        RouteNumber = routeNumber;
        Brand = brand;
        Year = year;
        Mileage = mileage;
        Status = status;
    }

    public string Name { get; set; }
    public int BusNumber { get; set; }
    public int RouteNumber { get; set; }
    public string Brand { get; set; }
    public int Year { get; set; }
    public int Mileage { get; set; }
    public BusStatus Status { get; set; }
    
    public static List<Bus> Buses = new List<Bus>();

    public static void ShowAllBuses()
    {
        Buses.ForEach(Console.WriteLine);
        
    }
    public static void ShowAllBusesEnRoute()
    {
        Buses.Where(s => s.Status == BusStatus.EnRoute).ToList().ForEach(Console.WriteLine);
    }
    
    public static void ShowAllBusesOnTrip()
    {
        Buses.Where(s => s.Status == BusStatus.OnTrip).ToList().ForEach(Console.WriteLine);
    }
    
    public static void ShowAllBusesWithRouteNumber(int number)
    {
        Buses.Where(s => s.RouteNumber == number).ToList().ForEach(Console.WriteLine);

    }

    public static void ShowAllBusesElder10Years()
    {
        Buses.Where(s => s.Year < DateTime.Now.Year - 10).ToList().ForEach(Console.WriteLine);
    }

    public static void ShowAllBusesWithMileage(int mileage)
    {
        Buses.Where(s => s.Mileage > mileage).ToList().ForEach(Console.WriteLine);
    }
    
    public override string ToString()
    {
        return $"Name: {Name}, BusNumber: {BusNumber}, RouteNumber: {RouteNumber}, Brand: {Brand}, Year: {Year}, Mileage: {Mileage}, Status: {Status}";
    }

}



public enum BusStatus
{
    EnRoute,
    OnTrip
}