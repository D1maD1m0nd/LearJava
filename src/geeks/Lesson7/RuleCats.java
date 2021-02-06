package geeks.Lesson7;

import java.util.Random;

public class RuleCats {
    public static String[] names = {"Барсик", "Сипуша","Юра", "Самасурацу"};
    public static Cat[] GenerateCats(int countCats){
        Cat[] cats = new Cat[countCats];
        for (int i = 0; i < countCats ; i++) {
            String name = genCatsName();

            int appetite = genAppetite();
            cats[i] = new Cat(appetite,name);
        }
        return cats;
    }
    public static String genCatsName(){
        return names[new Random().nextInt(names.length)] + "#" + new Random().nextInt(1000);
    }
    public static int genAppetite(){
        return new Random().nextInt(30);
    }
    public static void infoCats(Cat[] cats){
        for (Cat cat:
             cats) {
            cat.info();
        }
    }
    public static void eatCats(Cat[] cats, Plate plate){
        boolean needFoods = false;
        plate.info();
        for (Cat cat:
                cats) {

            if(!cat.getBellyFul()){
                if(plate.getFood() < 10){
                    needFoods = true;
                    break;
                }
                cat.eat(plate);
            }else{
                continue;
            }

            plate.info();
        }
        infoCats(cats);
        if(needFoods){
            plate.setFood(10 * cats.length);
        }


    }

}
