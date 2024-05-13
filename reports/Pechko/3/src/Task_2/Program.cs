using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

public class Flight
{
    public string Destination { get; set; }
    public string FlightNumber { get; set; }
    public string AircraftType { get; set; }
    public TimeSpan DepartureTime { get; set; }
    public List<string> DaysOfWeek { get; set; }
    public int PassengerCount { get; set; } 
}

public class FlightSystem
{
    private List<Flight> flights = new List<Flight>();

    public void LoadFlightsFromFile(string filename)
    {
        var lines = File.ReadAllLines(filename);
        foreach (var line in lines)
        {
            var data = line.Split(';');
            var flight = new Flight
            {
                Destination = data[0],
                FlightNumber = data[1],
                AircraftType = data[2],
                DepartureTime = TimeSpan.Parse(data[3]),
                DaysOfWeek = data[4].Split(',').ToList(),
                PassengerCount = int.Parse(data[5]) 
            };
            flights.Add(flight);
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            FlightSystem flightSystem = new FlightSystem();
            flightSystem.LoadFlightsFromFile("flights.txt");

            Console.WriteLine("Список всех рейсов:");
            foreach (var flight in flightSystem.flights)
            {
                Console.WriteLine($"Рейс {flight.FlightNumber} в {flight.Destination} вылетает в {flight.DepartureTime}");
            }

            var flightsToParis = flightSystem.GetFlightsByDestination("Paris");
            Console.WriteLine("\nРейсы в Париж:");
            foreach (var flight in flightsToParis)
            {
                Console.WriteLine($"Рейс {flight.FlightNumber} вылетает в {flight.DepartureTime}");
            }
            var flightsOnMonday = flightSystem.GetFlightsByDayOfWeek("Monday");
            Console.WriteLine("\nРейсы в понедельник:");
            foreach (var flight in flightsOnMonday)
            {
                Console.WriteLine($"Рейс {flight.FlightNumber} в {flight.Destination} вылетает в {flight.DepartureTime}");
            }

            var flightsOnMondayAfter10 = flightSystem.GetFlightsByDayAndTime("Monday", new TimeSpan(10, 0, 0));
            Console.WriteLine("\nРейсы в понедельник после 10 утра:");
            foreach (var flight in flightsOnMondayAfter10)
            {
                Console.WriteLine($"Рейс {flight.FlightNumber} в {flight.Destination} вылетает в {flight.DepartureTime}");
            }

            var boeingFlights = flightSystem.GetFlightsByAircraftType("Boeing 737");
            Console.WriteLine("\nРейсы на Boeing 737:");
            foreach (var flight in boeingFlights)
            {
                Console.WriteLine($"Рейс {flight.FlightNumber} в {flight.Destination} вылетает в {flight.DepartureTime}");
            }

            var groupedFlights = flightSystem.GroupFlightsByPassengerCount();
            Console.WriteLine("\nРейсы, сгруппированные по числу пассажиров:");
            foreach (var group in groupedFlights)
            {
                Console.WriteLine($"\n{group.Key}:");
                foreach (var flight in group.Value)
                {
                    Console.WriteLine($"Рейс {flight.FlightNumber} в {flight.Destination} вылетает в {flight.DepartureTime}");
                }
            }

            var roundTrips = flightSystem.GetRoundTrips();
            Console.WriteLine("\nРейсы туда-обратно:");
            foreach (var flight in roundTrips)
            {
                Console.WriteLine($"Рейс {flight.FlightNumber} в {flight.Destination} вылетает в {flight.DepartureTime} и возвращается обратно");
            }
        }
    }

    public List<Flight> GetFlightsByDestination(string destination)
    {
        return flights.Where(f => f.Destination == destination).ToList();
    }

    public List<Flight> GetFlightsByDayOfWeek(string dayOfWeek)
    {
        return flights.Where(f => f.DaysOfWeek.Contains(dayOfWeek)).ToList();
    }

    public List<Flight> GetFlightsByDayAndTime(string dayOfWeek, TimeSpan time)
    {
        return flights.Where(f => f.DaysOfWeek.Contains(dayOfWeek) && f.DepartureTime > time).ToList();
    }

    public List<Flight> GetFlightsByAircraftType(string aircraftType)
    {
        return flights.Where(f => f.AircraftType == aircraftType).ToList();
    }

    public Dictionary<string, List<Flight>> GroupFlightsByPassengerCount()
    {
        return new Dictionary<string, List<Flight>>
        {
            {"Маломестные", flights.Where(f => f.PassengerCount >= 1 && f.PassengerCount <= 100).ToList()},
            {"Средместные", flights.Where(f => f.PassengerCount > 100 && f.PassengerCount <= 200).ToList()},
            {"Крупные", flights.Where(f => f.PassengerCount > 200 && f.PassengerCount <= 350).ToList()}
        };
    }

    public List<Flight> GetRoundTrips()
    {
        return flights.Where(f1 => flights.Any(f2 => f2.Destination.Trim().Equals(f1.FlightNumber.Trim(), StringComparison.OrdinalIgnoreCase) && f2.FlightNumber.Trim().Equals(f1.Destination.Trim(), StringComparison.OrdinalIgnoreCase))).ToList();
    }
}
