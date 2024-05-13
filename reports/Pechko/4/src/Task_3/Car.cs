using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Task_3
{
    internal class Car
    {
        public int Id { get; }
        public string Model { get; }

        public Car(int id, string model)
        {
            Id = id;
            Model = model;
        }
    }
}
