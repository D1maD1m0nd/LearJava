package geeks.Lesson7;

public class Cat {
    private final String name;
    private boolean bellyful;
    private final int appetite;

    Cat(int hungry, String name){
        this.name = name;
        this.bellyful = false;
        this.appetite = hungry;
    }

    public boolean getBellyFul(){
        return bellyful;
    }
    public void info(){
        if(bellyful){
            System.out.printf("Кот %s сыт\n",name);
            return;
        }
        System.out.printf("Кот %s голоден\n",name);

    }
    public void eat(Plate plate){
        int food = plate.getFood();

        if(food < appetite){
            return;
        }
        //изменяем значение еды в Plate
        plate.decreaseFood(appetite);
        bellyful = true;
    }

}
