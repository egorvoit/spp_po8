public class Main {
    public static void main(String[] args) {
        Handbook handbook = new Handbook(456, "Марк Яковлевич Выгодский", "Справочник по высшей математике", 2022, "АСТ", 10);
        Encyclopedia encyclopedia = new Encyclopedia(123, "Евгений Яковлевич Гик", "Большая энциклопедия спорта", 2008, "ОлмаМедиаГрупп", 2);

        System.out.println("Информация о справочнике:");
        handbook.printInfo();

        System.out.println("\nИнформация об энциклопедии:");
        encyclopedia.printInfo();
    }
}