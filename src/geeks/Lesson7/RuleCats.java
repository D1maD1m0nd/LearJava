package geeks.Lesson7;

import java.util.Random;

public class RuleCats {
    public static String[] names = {"Барсик", "Сипуша","Юра", "Самасурацу"};

    /**
     * Генерирует массив экземпляров класса Cat
     * @param countCats  количество экземпляров Cat, которые необходимо сгенерировать
     * @return массив экземпляров Cat
     */
    public static Cat[] GenerateCats(int countCats){
        Cat[] cats = new Cat[countCats];
        for (int i = 0; i < countCats ; i++) {
            String name = genCatsName();
            int appetite = genAppetite();
            cats[i] = new Cat(appetite,name);
        }
        return cats;
    }

    /**
     * Генерация имени кота, которая выбирается случайно из массива names
     * @return возвращает имя кота
     */
    public static String genCatsName(){
        return names[new Random().nextInt(names.length)] + "#" + new Random().nextInt(1000);
    }

    public static int genAppetite(){
        return new Random().nextInt(30);
    }

    /**
     * выводит информация о всех котах в массиве Cats
     * @param cats массив экземпляров Cat
     */
    public static void infoCats(Cat[] cats){
        for (Cat cat:
             cats) {
            cat.info();
        }
    }

    /**
     * Вызывает метод eat у всех экземпляров cat в массиве cats, если коты не были покормлены, то в конце добавляет еще  в Plate.food
     * @param cats массив экземпляров Cat
     * @param plate экземпляр Plate
     */
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
