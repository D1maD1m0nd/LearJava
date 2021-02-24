package geeks.Lesson7;

public class Plate {
    private int food;

    Plate(int food) {
        if (food <= 0) {
            this.food = 500;
        } else {
            this.food = food;
        }

    }

    /**
     * информация о количестве food в экезмепляре Plate
     */
    public void info() {
        System.out.printf("Еды в тарелке осталось %d\n", food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food < 0) {
            System.out.println("Значение еды не может быть отрицательным или 0");
            return;
        }
        this.food += food;
    }

    /**
     * изменение состояния еды
     *
     * @param n - количество appetite из объекта Cat
     */
    public void decreaseFood(int n) {
        food = food - n;
    }

}
