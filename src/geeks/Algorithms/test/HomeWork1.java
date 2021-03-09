package geeks.Algorithms.test;

public class HomeWork1 {

    private static class Box {
        private int weight = 0;

        public Box(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return weight+"";
        }
    }

    public static void main(String[] args) {

        //Примитивный тип
        int weightBox1 = 125;
        //Ссылочный тип
        String weightBox2 = "125";
        //Тип класса Box
        Box box3 = new Box(125);

        //Выводим все данные
        System.out.println("Вес первой коробки (примитивный тип) " + weightBox1);
        System.out.println("Вес второй коробки (ссылочный тип) " + weightBox2);
        System.out.println("Вес третьей коробки (тип класса Box) " + box3);

        //Заносим все переменные в массив, для перебора
        Object[] collectionVariable = new Object[3];
        collectionVariable[0] = weightBox1;
        collectionVariable[1] = weightBox2;
        collectionVariable[2] = box3;

        //Создаем переменные примитивного, ссылочного типа и переменные класса Box, find3 новый экземпляр, find4 ссылка на box3
        int find1 = new Integer(125);
        String find2 = "125";
        Box find3 = new Box(125);
        Box find4 = box3;
        //Заносим все переменные в массив, для перебора
        Object[] collectionFind = new Object[4];
        collectionFind[0] = find1;
        collectionFind[1] = find2;
        collectionFind[2] = find3;
        collectionFind[3] = find4;



        //Получаем время начала перебора по массиву объектов
        long lStartTime = System.nanoTime();


        /*
        Перебираем для каждого типа переменной все значения (разных типов) для сравнения и выводим результат сравнения
        */
        for(Object obj : collectionVariable)
            for (Object objFind : collectionFind) {
                if (obj.equals(objFind)) {
                    System.out.println("(" + obj.getClass().getSimpleName() +")" + obj + " равен " + "(" + (objFind).getClass().getSimpleName() + ")" + objFind);
                } else {
                    System.out.println("(" + obj.getClass().getSimpleName() +")" + obj + " не равен " + "(" + (objFind).getClass().getSimpleName() + ")" + objFind);
                }
            }

        //Отнимаем от текущего времени время начала перебора и получаем длительность операции в мс
        System.out.println("Время перебора и сравнения: " + (System.nanoTime() - lStartTime) / 1000000 + " ms");
    }
}

