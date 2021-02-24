package tests;

public class Cat implements TestInf {
    private String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public int getAppetite() {
        return appetite;
    }

    public void eat(Plate plate) {
        plate.decreaseFood(appetite);
    }

    public void swim() {
        System.out.println("Плыву");
    }
}
