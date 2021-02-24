package geeks.Lesson7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean bellyful;

    Cat(int hungry, String name) {
        this.name = name;
        this.appetite = hungry;
    }

    public boolean getBellyFul() {
        return bellyful;
    }

    /**
     * Выводит информацию о сытости кота
     */
    public void info() {
        if (bellyful) {
            System.out.printf("Кот %s сыт\n", name);
            return;
        }
        System.out.printf("Кот %s голоден\n", name);

    }

    /**
     * Метод изменяет состояние сытости кота, в случае , если еды ему хватило,
     * также изменяет состояние еды в тарелке
     *
     * @param plate тарелка с едой
     */
    public void eat(Plate plate) {
        int food = plate.getFood();

        if (food < appetite) {
            return;
        }
        //изменяем значение еды в Plate
        plate.decreaseFood(appetite);
        bellyful = true;
    }

}
