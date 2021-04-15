package books.headfirst.Lesson9;

public class TestBox {
    Integer i;
    int j;

    public static void main(String[] args) {
        TestBox box = new TestBox();
        box.go();
    }
    public void go(){
        j = i;
        System.out.println(i);
        System.out.println(j);
    }
}
