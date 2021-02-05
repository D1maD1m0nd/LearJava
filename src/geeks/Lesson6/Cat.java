package geeks.Lesson6;

public class Cat extends Animal{
    private static int count = 0;
    Cat(String name){
        super(name,200);
        count++;
    }
    public void swim(double let){
        System.out.printf("%s является котом, а коты не умеют плавать \n", getName());

    }

    public static int getCount(){return count; }

}
