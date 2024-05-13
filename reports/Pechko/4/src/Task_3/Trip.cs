using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task_3
{
    internal class Trip
    {
        public int Id { get; }
        public Driver Driver { get; }
        public bool IsCompleted { get; set; }

        public Trip(int id, Driver driver)
        {
            Id = id;
            Driver = driver;
            IsCompleted = false;
        }
    }
}
