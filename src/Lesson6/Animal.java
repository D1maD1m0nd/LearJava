package Lesson6;

public abstract class Animal {
    public String name;
    public int age;
    public String color;
    public double maxDistSwim;
    public double maxDistRun;
    public static int countAnimal;
    Animal(String name, int age, String color, double maxDistSwim, double maxDistRun){
        this.name = name;
        this.age = age;
        this.color = color;
        this.maxDistRun = maxDistRun;
        this.maxDistSwim = maxDistSwim;

        countAnimal++;
    }
    Animal(String name, int age, String color,  double maxDistRun){
        this.name = name;
        this.age = age;
        this.color = color;
        this.maxDistRun = maxDistRun;
        countAnimal++;
    }

    public void run(double let){
        if(let > maxDistRun){
            System.out.printf("%s не может пробежать больше %.1f м\n", name, maxDistRun);
            return;
        }
        System.out.printf("%s пробежал %.1f метров \n", name, let);
    }

    public void swim(double let){
        if(let > maxDistSwim){
            System.out.printf("%s не может проплыть больше %.1f м\n", name, maxDistSwim);
        }
        System.out.printf("%s проплыл %.1f м\n", name, let);
    };
}
