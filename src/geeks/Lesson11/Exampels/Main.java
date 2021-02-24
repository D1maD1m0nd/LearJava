package geeks.Lesson11.Exampels;

public class Main {
    public static void main(String[] args) {
        SimpleBox<Integer> simpleBox = new SimpleBox<>(20);
        SimpleBox<Integer> simpleBox1 = new SimpleBox<>(30);
        SimpleBox<Integer> result = sumSimpleBoxes(simpleBox1, simpleBox);

        SimpleBox<String> simpleBox3 = new SimpleBox<>("1");
        SimpleBox<String> simpleBox4 = new SimpleBox<>("4");
        System.out.println(result.getObject());
        System.out.println(concactSimpleBoxes(simpleBox3, simpleBox4).getObject());

        Stats<Integer> stats = new Stats<>(new Integer[]{1, 2, 3, 4});
        Stats<Double> doubleStats = new Stats<>(new Double[]{1.9, 3.0, 43.0, 3.0});

        System.out.println(stats.average());
        System.out.println(doubleStats.average());
        System.out.println(stats.sameAverage(doubleStats));
        System.out.println(stats.<String>doSomething("Привет"));
    }

    public static SimpleBox<Integer> sumSimpleBoxes(SimpleBox<Integer> simpleBox1, SimpleBox<Integer> simpleBox2) {

        int sum = simpleBox1.getObject() + simpleBox2.getObject();
        return new SimpleBox<>(sum);
    }

    public static SimpleBox<String> concactSimpleBoxes(SimpleBox<String> simpleBox1, SimpleBox<String> simpleBox2) {
        return new SimpleBox<>(simpleBox1.getObject() + simpleBox2.getObject());
    }
}
