using System;
using Task_3;

namespace Task_3
{
    class Program
    {
        static void Main(string[] args)
        {
            Dispatcher dispatcher = new Dispatcher(1, "Dispatcher1");
            Driver driver1 = new Driver(1, "Driver1");
            Car car1 = new Car(1, "Car1");
            Trip trip1 = new Trip(1, driver1);

            // Диспетчер назначает автомобиль водителю
            dispatcher.AssignCarToDriver(driver1, car1);

            // Водитель выполняет рейс
            driver1.CompleteTrip(trip1);

            // Диспетчер регистрирует выполненный рейс
            dispatcher.RegisterTrip(trip1);
        }
    }
}
