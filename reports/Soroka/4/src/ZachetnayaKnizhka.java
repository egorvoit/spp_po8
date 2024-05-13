import java.util.*;

public class ZachetnayaKnizhka {
    private class Session
    {
        private String nazvaniePredmeta;
        private List<String> zachety;
        private List<String> ekzameny;
        private List<Integer> ocenkiZachet;
        private List<Integer> ocenkiEkzamen;

        public Session(String name) {
            this.nazvaniePredmeta = name;
            zachety = new ArrayList<>();
            ekzameny = new ArrayList<>();
            ocenkiZachet = new ArrayList<>();
            ocenkiEkzamen = new ArrayList<>();
        }

        public void addEkzameny(String discipline, int grade) {
            ekzameny.add(discipline);
            ocenkiEkzamen.add(grade);
        }

        public void addZacheti(String discipline, int grade) {
            zachety.add(discipline);
            ocenkiZachet.add(grade);
        }

        public String creditGrade(int grade) {
            if (grade >= 4) {
                return "зачтено";
            } else {
                return "не зачтено";
            }
        }

        public double averageGrade() {
            double sum = 0;
            int count = 0;

            for (int grade : ocenkiZachet) {
                sum += grade;
                count++;
            }

            for (int grade : ocenkiEkzamen) {
                sum += grade;
                count++;
            }

            if (count == 0) {
                return 0;
            }
            return Math.round((sum / count) * 10) / 10.0;
        }

        public void printSessionResult() {
            StringBuilder result = new StringBuilder();
            result.append("\nСессия: ").append(nazvaniePredmeta).append("\n");
            System.out.print(result.toString());
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Зачёты:");
            System.out.println("_______");
            for (String zachet : zachety) {
                result.setLength(0);
                result.append("Дисциплина: ").append(zachet).append("\n");
                int index = zachety.indexOf(zachet);
                int ocenka = ocenkiZachet.get(index);
                result.append("Оценка: ").append(creditGrade(ocenka)).append(" (").append(ocenka).append(")");
                System.out.println(result.toString());
            }

            System.out.println("\nЭкзамены:");
            System.out.println("_________");
            for (String ekzamen : ekzameny) {
                result.setLength(0);
                result.append("Дисциплина: ").append(ekzamen).append("\n");
                int index = ekzameny.indexOf(ekzamen);
                int ocenka = ocenkiEkzamen.get(index);
                if (ocenka == -1) {
                    result.append("Оценка: " + "оценка отсутствует");
                } else {
                    result.append("Оценка: " + ocenka);
                }
                System.out.println(result.toString());
            }
            System.out.println("-------------------------------------------------------------------------------");
            double average = averageGrade();
            System.out.println("Cредний балл: " + average);
        }
    }


    static class Materick
    {
        private String name;
        public Materick(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void description() {
            System.out.println("Это " + name + " - один из материков планеты.");
        }
        public void populationDensity(double area, int population) {
            double density = population / area;
            double roundedDensity = Math.round(density * 10.0) / 10.0;
            System.out.println("Плотность населения " + name +" составляет " + roundedDensity +" человек на квадратную единицу.");
        }
        public void economySize(double gdp) {
            double roundedGdp = Math.round(gdp * 10.0) / 10.0;
            System.out.println("Размер экономики " + name + " составляет " + roundedGdp + " единиц.");
        }
    }

    static class Planet
    {
        private List<Materick> matericks;
        public Planet(List<Materick> matericks) {
            this.matericks = matericks;
        }
        public List<Materick> getMatericks() {
            return matericks;
        }
        public void setMatericks(List<Materick> matericks) {
            this.matericks = matericks;
        }
        public void description() {
            System.out.print("Планета Земля состоит из следующих материков: ");
            for (Materick materick : matericks) {
                System.out.print(materick.getName() + ", ");
            }
            System.out.println();
        }
        public void launchRocket() {
            System.out.println("Ракета успешно запущена с планеты Земля!");
        }
        public void explorePlanet() {
            System.out.println("Начато исследование планеты Земля.");
        }
        public void launchSatellite() {
            System.out.println("Спутник запущен с планеты Земля!");
        }
        public void weatherForecast(String date) {
            System.out.println("Прогноз погоды на " + date + " - солнечно.");
            System.out.println();
        }
    }






    // Класс Аэропорт
    static class Airport {
        private String name;

        public Airport(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void changeDestination(Flight flight, String newDestination) {
            System.out.println("Рейс изменяет место назначения из " + flight.destinationAirport.getName() + " в " + newDestination);
            flight.setDestination(newDestination);
            flight.destinationAirport = this; // Обновляем аэропорт назначения рейса
        }
    }

    // Класс Самолет
    static class Aircraft
    {
        private int capacity;
        private int range;
        private String model;

        public Aircraft(int capacity, int range, String model) {
            this.capacity = capacity;
            this.range = range;
            this.model = model;
        }

        public int getCapacity() {
            return capacity;
        }
        public int getRange() {
            return range;
        }
    }

    // Класс ЧленЭкипажа
    class CrewMember
    {
        private String name;
        private int age;

        public CrewMember(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public int getAge() {
            return age;
        }
    }

    // Класс Пилот (производный класс от ЧленЭкипажа)
    class Pilot extends CrewMember
    {
        public Pilot(String name, int age) {
            super(name, age);
        }

        public void flyAircraft() {
            System.out.println("Главный пилот " + getName() + " управляет самолётом");
        }

        public void getVoice() {
            System.out.println("Помощник пилота " + getName() + " объявляет необходимую информацию пассажирам по громкоговорителю");
        }
    }

    // Класс Штурман (производный класс от ЧленЭкипажа)
    class Navigator extends CrewMember
    {
        public Navigator(String name, int age) {
            super(name, age);
        }

        public void navigate() {
            System.out.println("Штурман определяет маршрут полёта...");
        }
    }

    // Класс Радист (производный класс от ЧленЭкипажа)
    class RadioOperator extends CrewMember
    {
        public RadioOperator(String name, int age) {
            super(name, age);
        }

        public void speakWithEarth() {
            System.out.println("Радист " + getName() + " докладывает обстановку по рации в диспетчерский центр");
        }
    }

    // Класс Стюардесса (производный класс от ЧленЭкипажа)
    class Stewardess extends CrewMember
    {
        public Stewardess(String name, int age) {
            super(name, age);
        }

        public void servePassengers() {
            System.out.println("Стюардесса " + getName() + " обслуживает пассажиров в самолете");
        }

        public void conductBriefing() {
            System.out.println("Стюардесса " + getName() + " проводит инструктаж пассажиров");
        }
    }

    // Класс Рейс
    static class Flight
    {
        private Airport departureAirport;
        private Airport destinationAirport;
        private Aircraft aircraft;

        public Flight(Airport departureAirport, Airport destinationAirport, Aircraft aircraft) {
            this.departureAirport = departureAirport;
            this.destinationAirport = destinationAirport;
            this.aircraft = aircraft;
        }

        public void changeDestination(String s) {
        }
        public void setDestination(String newDestination) {
        }
    }

    private static void getJob(List<CrewMember> pilotList, CrewMember navigator, CrewMember radioOperator, List<CrewMember> stewardessList, Airport destinationAirport) throws InterruptedException {

        Thread.sleep(500);
        for (CrewMember crewMember : pilotList)
        {
            if (crewMember instanceof Pilot) {
                Pilot pilot = (Pilot) crewMember;
                if (pilot.getName().equals("Сорока Вадим Сергеевич")) {
                    pilot.flyAircraft();
                } else {
                    pilot.getVoice();
                }
            }
        }

        Thread.sleep(500);
        if (navigator instanceof Navigator) {
            Navigator castedNavigator = (Navigator) navigator;
            castedNavigator.navigate();
        }

        Thread.sleep(500);
        if (radioOperator instanceof RadioOperator) {
            RadioOperator castedOperator = (RadioOperator) radioOperator;
            castedOperator.speakWithEarth();
        }
        Thread.sleep(500);
        for (CrewMember crewMember : stewardessList)
        {
            if (crewMember instanceof Stewardess) {
                Stewardess stewardess = (Stewardess) crewMember;
                if (stewardess.getName().equals("Петрова Александра Сергеевна")) {
                    stewardess.conductBriefing();
                } else {
                    stewardess.servePassengers();
                }
            }
        }

        try {
            // Задержка выполнения кода на 3 секунды
            Thread.sleep(2000);
            System.out.println("\nРейс проходит в штатном режиме...");
            Thread.sleep(3000);

            Random random = new Random();
            int randomNumber = random.nextInt(3); // 0, 1, 2
            if (randomNumber == 0)
            {
                if (isGoodWeather())
                {
                    Thread.sleep(500);
                    System.out.println("\nВнимание!!! В процессе рейса произошло резкое ухудшение погодных условий. Конечный аэропорт " + destinationAirport.getName() + " временно недоступен для посадки!");

                    // Создаем новый объект Airport
                    Airport newDestinationAirport = new Airport("Аэропорт Иваново-Северный");
                    Thread.sleep(500);
                    System.out.println("Конечный пункт прибытия изменён с " + destinationAirport.getName() + " на " + newDestinationAirport.getName());
                    // Обновляем значение destinationAirport
                    destinationAirport = newDestinationAirport;

                    try {
                        System.out.println("\nРейс проходит в штатном режиме...");
                        // Задержка выполнения кода на 5 секунд
                        Thread.sleep(2000);
                        System.out.println("\nСамолёт прибыл в " + destinationAirport.getName());
                        Thread.sleep(500);
                        System.out.println("Рейс №228 был успешно завершён в другой конечной точке!");
                    } catch (InterruptedException e) {
                        // Обработка исключения, если прерывание произошло
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("\nСамолёт прибыл в " + destinationAirport.getName());
                    Thread.sleep(500);
                    System.out.println("Рейс №228 успешно завершён!");
                }

            } else if (randomNumber == 1) {
                Thread.sleep(500);
                System.out.println("\nГоворит главный пилот самолёта " + pilotList.get(0).getName() + "! В связи с технической неисправностью воздушного судна мы не сможем долететь до аэропорта назначения: " + destinationAirport.getName() + ". ");

                // Создаем новый объект Airport
                Airport newDestinationAirport = new Airport("Аэропорт Кобылёво");
                Thread.sleep(500);
                System.out.println("Поэтому мы изменяем курс на ближайший к нам аэропорт: " + newDestinationAirport.getName() + ". Авиакомпания заранее приносит свои извенения, все подробности будут позже!");

                // Обновляем значение destinationAirport
                destinationAirport = newDestinationAirport;

                try {
                    System.out.println("\nРейс проходит в аварийном режиме...");
                    // Задержка выполнения кода на 5 секунд
                    Thread.sleep(2000);
                    System.out.println("\nСамолёт прибыл в " + destinationAirport.getName());
                    Thread.sleep(500);
                    System.out.println("Рейс №228 завершён преждевременно из-за технической неисправности!");
                } catch (InterruptedException e) {
                    // Обработка исключения, если прерывание произошло
                    e.printStackTrace();
                }

            } else {
                System.out.println("\nСамолёт прибыл в " + destinationAirport.getName());
                Thread.sleep(500);
                System.out.println("Рейс №228 успешно завершён!");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Переменная для отслеживания количества срабатываний условия else
    private static int badWeatherCount = 0;
    private static void scheduleFlight(List<CrewMember> stewardessList, List<CrewMember> pilotList, CrewMember navigator, CrewMember radioOperator, Airport destinationAirport)
    {
        System.out.println("Ожидаем изменения погоды...");
        try {
            // Пауза на 5 секунд
            long delay = 5000;
            long startTime = System.currentTimeMillis();
            while (System.currentTimeMillis() - startTime < delay) {
                Thread.sleep(1000); // Можно делать проверки каждую секунду
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (isGoodWeather()) {
            System.out.println("Погода улучшилась. Начинаем подготовку к рейсу... \n");
            try {
                getJob(pilotList, navigator, radioOperator, stewardessList, destinationAirport);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Увеличиваем счетчик при каждом срабатывании условия else
            badWeatherCount++;

            if (badWeatherCount < 2) {
                System.out.println("Продолжается плохая погода. Повторная проверка через 5 секунд...");
                scheduleFlight(stewardessList, pilotList, navigator, radioOperator, destinationAirport);
            } else {
                System.out.println("Продолжается плохая погода. Рейс отменён.");
            }
        }
    }

    private static int getWeatherCondition()
    {
        Random random = new Random();
        return  random.nextInt(3);
    }

    private static boolean isGoodWeather()
    {
        Random random = new Random();
        return random.nextBoolean();
    }


    public static void main(String[] args) throws InterruptedException
    {
        Scanner in = new Scanner(System.in);
        int choice = 0;
        String input = "";

        while (choice != 4)
        {
            while (true)
            {
                System.out.println("1. Задание 1\n2. Задание 2\n3. Задание 3\n4. Выход\n");
                System.out.print("Выберите необходимое:  ");
                input = in.nextLine();

                // Проверка, что введено только одно целое число
                if (input.matches("^\\d+$")) {
                    choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= 4) {
                        break; // Выбор корректен, выходим из цикла
                    }
                }
                System.out.println("Неверный ввод! Введите только одно число от 1 до 4.\n");
            }

            switch (choice)
            {
                case 1:
                    System.out.print("\n===============================================================================");
                    ZachetnayaKnizhka zahtnayaKnizhka = new ZachetnayaKnizhka();
                    Session session = zahtnayaKnizhka.new Session("№6, семестр №6 (лето 2024):");

                    session.addZacheti("Современные платформы программирования (СПП)", 7);
                    session.addZacheti("Проектирование интернет-систем (ПИС)", 6);
                    session.addZacheti("Надежность программного обеспечения (НПО)", 6);
                    session.addZacheti("Физическая культура", 8);
                    session.addZacheti("Технологическая практика", 6);

                    session.addEkzameny("Программное обеспечение мобильной робототехники (ПОМР)", 7);
                    session.addEkzameny("Разработка программного обеспечения для мобильных платформ (РПОМП)", 8);
                    session.addEkzameny("Базы данных (БД)", 6);
                    session.addEkzameny("Основы бизнеса и права в сфере ИКТ", 7);

                    session.printSessionResult();
                    System.out.print("===============================================================================\n\n");
                    break;

                case 2:
                    System.out.println("\n===============================================================================");

                    Materick eurasia = new Materick("Евразия");
                    Materick africa = new Materick("Африка");
                    Materick northAmerica = new Materick("Северная Америка");

                    List<Materick> matericks = new ArrayList<>();
                    matericks.add(eurasia);
                    matericks.add(africa);
                    matericks.add(northAmerica);

                    Planet Earth = new Planet(matericks);
                    Earth.description();
                    Earth.launchRocket();
                    Earth.explorePlanet();
                    Earth.launchSatellite();
                    Earth.weatherForecast("22-03-2024");

                    eurasia.populationDensity(1000, 505005);
                    africa.populationDensity(2000, 3030003);
                    northAmerica.populationDensity(1500, 4040004);

                    eurasia.economySize(5000540.5434);
                    africa.economySize(3004300.25);
                    northAmerica.economySize(4045000.92);

                    System.out.println("===============================================================================\n");
                    break;

                case 3:
                    System.out.println("\n===============================================================================");

                    ZachetnayaKnizhka zachetnayaKnizhka = new ZachetnayaKnizhka();

                    List<CrewMember> stewardessList = new ArrayList<>();
                    List<CrewMember> pilotList = new ArrayList<>();

                    // Создаем объекты классов
                    Aircraft aircraft = new Aircraft(200, 1500, "Boeing 737 №555");
                    Airport departureAirport = new Airport("Аэропорт Брестский ()");
                    Airport destinationAirport = new Airport("Аэропорт Иваново (IWA)");

                    // Создаем рейс
                    Flight flight = new Flight(departureAirport, destinationAirport, aircraft);

                    // Создаем и добавляем членов экипажа
                    CrewMember first_pilot = zachetnayaKnizhka.new Pilot("Сорока Вадим Сергеевич", 30);
                    pilotList.add(first_pilot);
                    CrewMember second_pilot = zachetnayaKnizhka.new Pilot("Капитонов Максим Игоревич", 29);
                    pilotList.add(second_pilot);

                    CrewMember navigator = zachetnayaKnizhka.new Navigator("Таразевич Никита Александрович", 29);
                    CrewMember radioOperator = zachetnayaKnizhka.new RadioOperator("Дорошков Александр Дмитриевич", 29);

                    CrewMember first_stewardess = zachetnayaKnizhka.new Stewardess("Сидорова Елена Николаевна", 24);
                    stewardessList.add(first_stewardess);
                    CrewMember second_stewardess = zachetnayaKnizhka.new Stewardess("Петрова Александра Сергеевна", 23);
                    stewardessList.add(second_stewardess);

                    // Вывод сообщения о формировании лётной бригады
                    Thread.sleep(500);
                    System.out.println("Администратор сформировал лётную бригаду:");

                    // Вывод списка пилотов с нумерацией
                    Thread.sleep(500);
                    System.out.println("Пилоты:");
                    for (int i = 0; i < pilotList.size(); i++) {
                        System.out.println((i + 1) + ") " + pilotList.get(i).getName());
                    }

                    // Вывод навигатора и радиооператора
                    Thread.sleep(500);
                    System.out.println("Навигатор: " + navigator.getName());
                    System.out.println("Радиооператор: " + radioOperator.getName());

                    // Вывод списка стюардесс с нумерацией
                    Thread.sleep(500);
                    System.out.println("Стюардессы:");
                    for (int i = 0; i < stewardessList.size(); i++)
                    {
                        System.out.println((i + 1) + ") " + stewardessList.get(i).getName());
                    }
                    Thread.sleep(500);
                    System.out.println("\nРейс №228: " + departureAirport.getName() + " -- " + destinationAirport.getName() + "\nСамолёт: " + aircraft.model + "\nВместимость: " + aircraft.capacity + "\nДальность рейса: " + aircraft.range);
                    System.out.println("\n============================================================\n");

                    int weatherCondition = getWeatherCondition();
                    switch (weatherCondition) {
                        case 0:
                            System.out.println("Солнечная погода в обоих аэропортах. Рейс разрешен.\n");
                            try {
                                getJob(pilotList, navigator, radioOperator, stewardessList, destinationAirport);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 1:
                            System.out.println("Сильные осадки, штормовое предупреждение в аэропорту отправления. Рейс задерживается.");
                            scheduleFlight(stewardessList, pilotList , navigator, radioOperator, destinationAirport);
                            break;
                        case 2:
                            System.out.println("Сильные осадки, штормовое предупреждение в аэропорту назначения. Рейс задерживается.");
                            scheduleFlight(stewardessList, pilotList , navigator, radioOperator, destinationAirport);
                            break;
                        default:
                            System.out.println("Непредвиденное состояние погоды.");
                            scheduleFlight(stewardessList, pilotList , navigator, radioOperator, destinationAirport);
                            break;
                    }

                    Thread.sleep(500);
                    System.out.println("===============================================================================\n");
                    break;

                case 4:
                    System.out.println("Завершение работы...");
                    break;

                default:
                    System.out.println("Неверное значение!\n");
            }
        }
    }
}
