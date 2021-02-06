package geeks.Lesson7;

public class Plate {
    private int food;
    Plate(int food){
        this.food = food;
    }
    public void info(){
        System.out.printf("Еды в тарелке осталось %d\n",food);
    }
    public int getFood(){
        return food;
    }
    public void decreaseFood(int n) {
        food = food - n;
    }
    public void setFood(int food){
        if(food < 0){
            System.out.println("Значение еды не может быть отрицательным или 0");
            return;
        }
        this.food = food;
    }

}
