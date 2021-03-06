package geeks.Lesson6;

public abstract class Animal {
    private static int count;
    private String name;
    private double maxDistSwim;
    private double maxDistRun;

    //так как кошки не могут плавать то и параметр максимальной дистанции указывать не к чему
    Animal(String name, double maxDistSwim, double maxDistRun) {
        this.name = name;

        this.maxDistRun = maxDistRun;
        this.maxDistSwim = maxDistSwim;

        count++;
    }

    //конструктор для кошек
    Animal(String name, double maxDistRun) {
        this.name = name;
        this.maxDistRun = maxDistRun;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void run(double let) {
        if (let > maxDistRun) {
            System.out.printf("%s не может пробежать больше %.1f м\n", name, maxDistRun);
            return;
        }
        System.out.printf("%s пробежал %.1f метров \n", name, let);
    }

    public void swim(double let) {
        if (let > maxDistSwim) {
            System.out.printf("%s не может проплыть больше %.1f м\n", name, maxDistSwim);
            return;
        }
        System.out.printf("%s проплыл %.1f м\n", name, let);
    }

    ;
}
