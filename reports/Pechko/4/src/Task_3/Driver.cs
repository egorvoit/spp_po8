using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task_3
{
    internal class Driver
    {
        public int Id { get; }
        public string Name { get; }
        public Car Car { get; set; }
        public bool IsSuspended { get; set; }

        public Driver(int id, string name)
        {
            Id = id;
            Name = name;
            IsSuspended = false;
        }

        public void RequestRepair()
        {
            Console.WriteLine($"Driver {Name} has requested a repair for car {Car.Model}.");
        }

        public void CompleteTrip(Trip trip)
        {
            trip.IsCompleted = true;
            Console.WriteLine($"Driver {Name} has completed trip {trip.Id}.");
        }
    }
}
