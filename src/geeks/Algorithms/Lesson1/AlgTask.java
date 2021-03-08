package geeks.Algorithms.Lesson1;
//Приведите пример алгоритмов и структур данных из жизни.
/*
    Вождение автомобиля
    Поиск товара на прилавке, где товары отсортированны по категориям
    Расписание поездов, где их список упорядочен и движение проивходится в очереди этого расписания

 */

//Приведите пример алгоритмов и структур данных в программировании.
/*
    Поиск данных в какой-то коллекции или же строке
    Порядок действий к примеру, по сложению чисел
    Сбор и подготовка данных о необходимом объекте, которые в дальнейшем будут использованы в другом алгоритме, к примеру который будет
    Собранные данные читать в стриме, а дальше преобразует в массив байт(можно и без преобразования, если есть соответствующий перугруженный метод),
     а их потом отправят на сервер
 */
public class AlgTask {

    public static void main(String[] args) {
         /*
    Напишите программный код, в котором все данные хранятся только
     в переменных трех типов данных: Ссылочные, примитивные и своего класса содержащего:
     конструктор и метод отображения данных.
     */
        //ссылочный
        Data data = new Data(5);

        String str = new String("123");
        System.out.println("Ссылочный " + str);
        //Абстрактные, тут я не уверен, но если это говорит о том, что мы получаем данных через методы класса, то ок
        data.printData();
        //или
        Data.printData1();
        //или
        System.out.println("Абстрактный " + Data.data3);
        //примитивный
        int num = 5;
        System.out.println("Примитивный " + num);

       //сравнение данных
        System.out.println(data.compare(num, 5));
        System.out.println(data.compare(str,"123"));
        System.out.println(data.compare(data,new Data(5)));
        System.out.println(data.compare(data,new Data(3)));
        //Дополните предыдущий код сравнением ваших данных с другой переменной,
        // данный код должен имитировать простейший поиск перебором.
        //Оцените время выполнения алгоритма с помощью базового метода System.nanoTime().
        Integer[] nums = new Integer[]{1,2,3,5};
        System.out.println("Поиск числа " + num + " занял " + data.lineSearch(num, nums));

        String[] strs = new String[]{"1","2","3","4","54","12321312","3sadas","123"};
        System.out.println("Поиск строки " + str + " занял " + data.lineSearch(str, strs));

        Data[] dataArr = new Data[]{new Data(1), new Data(2), new Data(3), new Data(4), new Data(5)};
        System.out.println("Поиск объекта data" + " занял " + data.lineSearch(data, dataArr));
    }

}
