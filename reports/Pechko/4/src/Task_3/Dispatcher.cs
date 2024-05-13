using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task_3
{
    internal class Dispatcher
    {
        public int Id { get; }
        public string Name { get; }
        public List<Driver> Drivers { get; }
        public List<Car> Cars { get; }

        public Dispatcher(int id, string name)
        {
            Id = id;
            Name = name;
            Drivers = new List<Driver>();
            Cars = new List<Car>();
        }

        public void AssignCarToDriver(Driver driver, Car car)
        {
            driver.Car = car;
            Console.WriteLine($"Car {car.Model} assigned to driver {driver.Name}.");
        }

        public void SuspendDriver(Driver driver)
        {
            driver.IsSuspended = true;
            Console.WriteLine($"Driver {driver.Name} is suspended from work.");
        }

        public void RegisterTrip(Trip trip)
        {
            trip.IsCompleted = true;
            Console.WriteLine($"Trip {trip.Id} has been completed by driver {trip.Driver.Name}.");
        }
    }
}
