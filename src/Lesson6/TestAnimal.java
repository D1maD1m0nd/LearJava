package Lesson6;

public class TestAnimal {
    public static void main(String[] args) {
        System.out.println("Коты");
        Cat dimaCat = new Cat("Дима");
        dimaCat.swim(2000);
        dimaCat.run(150);
        dimaCat.run(201);

        Cat vovaCat = new Cat("Вова");
        vovaCat.swim(2000);
        vovaCat.run(150);
        vovaCat.run(201);

        Cat victorCat = new Cat("Виктор");
        victorCat.swim(2000);
        victorCat.run(150);
        victorCat.run(201);

        System.out.println("\nСобаки");
        Dog dimaDog = new Dog("Бобик" );
        dimaDog.swim(5);
        dimaDog.swim(11);
        dimaDog.run(250);
        dimaDog.run(500);

        Dog vovaDog = new Dog("Вова" );
        vovaDog.swim(5);
        vovaDog.swim(11);
        vovaDog.run(250);
        vovaDog.run(500);
        vovaDog.run(501);
        System.out.printf("Количество котов %d \n",Cat.getCount());
        System.out.printf("Количество собак %d \n",Dog.getCount());
        System.out.printf("суммарное количество животных %d", Animal.getCount());
    }
}
